package org.coderfun.fieldmeta.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.coderfun.common.BaseEntity_;

@Generated(value="Dali", date="2018-05-13T23:27:08.264+0800")
@StaticMetamodel(Validation.class)
public class Validation_ extends BaseEntity_ {
	public static volatile SingularAttribute<Validation, String> code;
	public static volatile SingularAttribute<Validation, String> description;
	public static volatile SingularAttribute<Validation, String> javaValid;
	public static volatile SingularAttribute<Validation, String> jsValid;
	public static volatile SingularAttribute<Validation, String> message;
	public static volatile SingularAttribute<Validation, String> name;
	public static volatile SingularAttribute<Validation, String> remark;
}