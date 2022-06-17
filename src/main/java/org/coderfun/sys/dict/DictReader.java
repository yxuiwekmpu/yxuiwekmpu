package org.coderfun.sys.dict;

import java.util.List;

import org.coderfun.sys.dict.dao.CodeClassDAO;
import org.coderfun.sys.dict.dao.CodeItemDAO;
import org.coderfun.sys.dict.entity.CodeClass;
import org.coderfun.sys.dict.entity.CodeClass_;
import org.coderfun.sys.dict.entity.CodeItem;
import org.coderfun.sys.dict.entity.CodeItem_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import klg.j2ee.query.jpa.expr.AExpr;

/**
 * 字典读取器
 * 
 * @author klguang[klguang@foxmail.com]
 * @date 2018年9月28日
 */
@Component
public class DictReader {

	private static CodeItemDAO itemDao;
	private static CodeClassDAO classDao;
	
	/**
	 * 静态变量注入
	 * @param itemDao
	 * @param classDao
	 */
	@Autowired	
	public DictReader(CodeItemDAO itemDao, CodeClassDAO classDao) {
		DictReader.itemDao=itemDao;
		DictReader.classDao=classDao;
	}

	/**
	 * 不可变的常量集合Immutable有如下优点<br>
	 * 1.对不可靠的客户代码库来说，它使用安全，可以在未受信任的类库中安全的使用这些对象<br>
	 * 2.线程安全的：immutable对象在多线程下安全，没有竞态条件<br>
	 * 3.不需要支持可变性, 可以尽量节省空间和时间的开销. 所有的不可变集合实现都比可变集合更加有效的利用内存 (analysis)<br>
	 * 4.可以被使用为一个常量，并且期望在未来也是保持不变的<br>
	 * 
	 */
	private static ImmutableMap<String, CodeItem> buildChildItemMap(List<CodeItem> codeItemList) {
		return Maps.uniqueIndex(codeItemList, new Function<CodeItem, String>() {
			@Override
			public String apply(CodeItem arg0) {
				return arg0.getCode();
			}
		});
	}

	/**
	 * 不可变map
	 * 
	 * @param classCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ImmutableMap<String, CodeItem> getChildItemMap(String classCode) {
		List<CodeItem> codeItemList = itemDao.findList(AExpr.eq(CodeItem_.classCode, classCode));
		return buildChildItemMap(codeItemList);
	}

	public static CodeClass getCodeClass(String classCode) {
		return classDao.getOne(AExpr.eq(CodeClass_.code, classCode));
	}

	public static String getCodeClassName(String classCode) {
		return getCodeClass(classCode).getName();
	}

	public static CodeItem getCodeItem(String code, String classCode) {
		CodeItem codeItem = itemDao.getOne(AExpr.eq(CodeItem_.classCode, classCode),
				AExpr.eq(CodeItem_.code, code));
		return codeItem;
	}

	public static String getCodeItemName(String code, String classCode) {
		CodeItem codeItem = getCodeItem(code, classCode);
		if (codeItem == null)
			return null;
		return codeItem.getName();
	}
}
