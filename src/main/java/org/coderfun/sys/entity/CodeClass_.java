package org.coderfun.sys.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.coderfun.common.BaseEntity_;

@Generated(value="Dali", date="2018-05-14T13:04:02.367+0800")
@StaticMetamodel(CodeClass.class)
public class CodeClass_ extends BaseEntity_ {
	public static volatile SingularAttribute<CodeClass, String> code;
	public static volatile SingularAttribute<CodeClass, String> name;
	public static volatile SingularAttribute<CodeClass, Integer> ordernum;
	public static volatile SingularAttribute<CodeClass, String> param;
	public static volatile SingularAttribute<CodeClass, String> moduleCode;
	public static volatile SingularAttribute<CodeClass, Integer> isSys;
	public static volatile SingularAttribute<CodeClass, String> remark;
}
