package org.coderfun.sys.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.coderfun.common.BaseEntity_;

@Generated(value="Dali", date="2018-05-14T13:04:02.380+0800")
@StaticMetamodel(CodeItem.class)
public class CodeItem_ extends BaseEntity_ {
	public static volatile SingularAttribute<CodeItem, String> classCode;
	public static volatile SingularAttribute<CodeItem, Long> code;
	public static volatile SingularAttribute<CodeItem, String> name;
	public static volatile SingularAttribute<CodeItem, String> value;
	public static volatile SingularAttribute<CodeItem, String> param;
	public static volatile SingularAttribute<CodeItem, String> extension;
	public static volatile SingularAttribute<CodeItem, Integer> ordernum;
	public static volatile SingularAttribute<CodeItem, String> pinyin;
	public static volatile SingularAttribute<CodeItem, String> remark;
}
