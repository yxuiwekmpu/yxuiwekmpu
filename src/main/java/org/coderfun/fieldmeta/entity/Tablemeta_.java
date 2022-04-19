package org.coderfun.fieldmeta.entity;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.coderfun.common.BaseEntity_;

@Generated(value="Dali", date="2018-05-13T23:27:08.249+0800")
@StaticMetamodel(Tablemeta.class)
public class Tablemeta_ extends BaseEntity_ {
	public static volatile SingularAttribute<Tablemeta, String> className;
	public static volatile SingularAttribute<Tablemeta, String> comments;
	public static volatile SingularAttribute<Tablemeta, String> commentsSimple;
	public static volatile SingularAttribute<Tablemeta, Date> createTime;
	public static volatile SingularAttribute<Tablemeta, BigInteger> isHaveDelete;
	public static volatile SingularAttribute<Tablemeta, BigInteger> isHaveDisableEnable;
	public static volatile SingularAttribute<Tablemeta, Date> modifyTime;
	public static volatile SingularAttribute<Tablemeta, String> options;
	public static volatile SingularAttribute<Tablemeta, String> parentTableFkName;
	public static volatile SingularAttribute<Tablemeta, String> parentTableName;
	public static volatile SingularAttribute<Tablemeta, String> remarks;
	public static volatile SingularAttribute<Tablemeta, String> tableName;
	public static volatile SingularAttribute<Tablemeta, String> tplCategory;
}
