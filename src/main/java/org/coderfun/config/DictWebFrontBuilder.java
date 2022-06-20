package org.coderfun.config;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.coderfun.sys.dict.dao.CodeClassDAO;
import org.coderfun.sys.dict.dao.CodeItemDAO;
import org.coderfun.sys.dict.entity.CodeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import klg.common.utils.CollectionTools;
import klg.common.utils.JacksonUtil;

@Component
public class DictWebFrontBuilder {
	private static final Logger logger = LoggerFactory.getLogger(DictWebFrontBuilder.class);
	
	@Autowired
	CodeItemDAO itemDao;
	
	@Autowired
	CodeClassDAO classDao;
	
	@Autowired
	ServletContext servletContext;
	
	
	@Autowired
	WebRes webRes;
	

	
	
	/**
	 * 
	 * 通过写JSON文件的方式构建前端dict reader
	 * 
	 * @throws IOException
	 */

	// 会执行两次?
	@PostConstruct
	public void build() throws IOException {

		Sort sort = new Sort(new Order(Direction.ASC, "classCode"), new Order(Direction.DESC, "orderNum"));
		List<CodeItem> codeItemList = itemDao.findAll(sort);

		// list可保持items的顺序
		Map<String, List> tempMap = null;
		try {
			// 根据classCode分类
			tempMap = CollectionTools.classify(false, codeItemList, "classCode");
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}

		// 将原有的数据字典的js文件覆盖
		String dictJson = JacksonUtil.toJSONString(tempMap);
		dictJson = "var dictJson=" + dictJson;

		String dictFile = webRes.getAbsolutePath() + "/js/dictData.js";
		FileUtils.writeStringToFile(new File(dictFile), dictJson, "utf-8");
		logger.info("reload dictData.js:{}", dictFile);
		
	}
}
