package org.coderfun.common.dict;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.coderfun.common.dict.entity.CodeClass;
import org.coderfun.common.dict.entity.CodeItem;
import org.coderfun.common.dict.service.CodeClassService;
import org.coderfun.common.dict.service.CodeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import klg.common.utils.CollectionTools;
import klg.common.utils.MyBeanUtil;

@Component
@Lazy(value=false)
public class DictManagerUtil {
	@Autowired
	CodeItemService codeItemService;
	@Autowired
	CodeClassService codeClassService;
	
	static Map<String, ImmutableMap<Long, Map>> codeMap =Maps.newLinkedHashMap();
	static Map<String,String> classMap=new HashMap();

	/**
	 * 不可变的常量集合Immutable有如下优点<br>
	 *　 1.对不可靠的客户代码库来说，它使用安全，可以在未受信任的类库中安全的使用这些对象<br>
	 *　 2.线程安全的：immutable对象在多线程下安全，没有竞态条件<br>
	 *　 3.不需要支持可变性, 可以尽量节省空间和时间的开销. 所有的不可变集合实现都比可变集合更加有效的利用内存 (analysis)<br>
	 *　 4.可以被使用为一个常量，并且期望在未来也是保持不变的<br>
	 * 
	 */
	public static ImmutableMap<Long, CodeItem> buildChildItemMap(
			List<CodeItem> codeItemList) {
		return Maps.uniqueIndex(codeItemList,
				new Function<CodeItem, Long>() {
					@Override
					public Long apply(CodeItem arg0) {
						return arg0.getCode();
					}
				});
	}

	
	@SuppressWarnings("unchecked")
	public static ImmutableMap<Long, Map> getChildItemMap(String classCode){
		return (ImmutableMap<Long, Map>) codeMap.get(classCode);
	}
	
	public static String getClassName(String classCode) {
		return classMap.get(classCode);
	}
	
	public static String getCodeName(Long code, String classCode) {
		Map codeItem = codeMap.get( classCode).get(code);
		if(codeItem==null)
			return null;
		return (String) codeItem.get("name");
	}

	public static Map<String, String> mapClassName(List<CodeClass> codeClassList){
		for(CodeClass codeClass:codeClassList){
			classMap.put(codeClass.getCode(), codeClass.getName());
		}
		return classMap;
	}
	
	public static Map<String, ImmutableMap<Long, Map>> getCodeMap() {
		return codeMap;
	}


	public static Map<String, String> getClassMap() {
		return classMap;
	}
	
	//会执行两次，
	@PostConstruct
	public void load() throws IOException {
		if(codeMap.isEmpty())
			reload();
	}
	
	public void reload() throws IOException {
		
		List<CodeItem> codeItemList = codeItemService.findAll(new Sort(Direction.DESC,"ordernum"));
		List<CodeClass> codeClassList=codeClassService.findAll();
		mapClassName(codeClassList);
		Map<String, List> tempMap = null;
		try {
			// 根据classCode分类
			tempMap = CollectionTools.classify(false, codeItemList, "classCode");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 将codeItem的code字段映射为map的key,并将codeitem按照指定属性转化为map
		for (Map.Entry<String, List> entry : tempMap.entrySet()) {
			@SuppressWarnings("unchecked")
			ImmutableMap<Long, CodeItem> temp=buildChildItemMap(entry.getValue());
			LinkedHashMap<Long, Map> target=Maps.newLinkedHashMap();
			for(Long key:temp.keySet()){
				target.put(key, MyBeanUtil.transToMapInclude(temp.get(key), false, "code","name"));
			}

			codeMap.put(entry.getKey(), ImmutableMap.copyOf(target));
		}
		
		//将原有的数据字典的js文件覆盖 
		String dictJson=new ObjectMapper().writeValueAsString(getCodeMap());
		dictJson="var dictJson="+dictJson;
		String dictFile= webRes+"/js/dictData.js"; 
		FileUtils.writeStringToFile(new File(dictFile),dictJson, "utf-8");
		System.out.println("----------重新加载数据字典-----------");
	}
	
	@Value("${web.res}")
	private String webRes;
}
