package org.coderfun.fieldmeta.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.coderfun.common.BaseEntity_;

@Generated(value="Dali", date="2019-08-13T19:41:29.408+0800")
@StaticMetamodel(TemplateFile.class)
public class TemplateFile_ extends BaseEntity_ {
	public static volatile SingularAttribute<TemplateFile, String> name;
	public static volatile SingularAttribute<TemplateFile, String> path;
	public static volatile SingularAttribute<TemplateFile, String> genFilekeyPath;
	public static volatile SingularAttribute<TemplateFile, String> genFilekeyType;
	public static volatile SingularAttribute<TemplateFile, String> genFilekeyPattern;
}
