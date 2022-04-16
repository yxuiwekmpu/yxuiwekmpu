package org.coderfun.fieldmeta.common;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-07T20:23:49.773+0800")
@StaticMetamodel(BaseEntity.class)
public class BaseEntity_ {
	public static volatile SingularAttribute<BaseEntity, Serializable> id;
	public static volatile SingularAttribute<BaseEntity, Long> version;
	public static volatile SingularAttribute<BaseEntity, Date> createTime;
	public static volatile SingularAttribute<BaseEntity, Date> modifyTime;
}
