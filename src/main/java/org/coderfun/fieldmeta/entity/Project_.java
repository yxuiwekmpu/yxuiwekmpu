package org.coderfun.fieldmeta.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.coderfun.common.BaseEntity_;

@Generated(value="Dali", date="2018-05-13T23:27:08.242+0800")
@StaticMetamodel(Project.class)
public class Project_ extends BaseEntity_ {
	public static volatile SingularAttribute<Project, String> dbPassword;
	public static volatile SingularAttribute<Project, String> dbUrl;
	public static volatile SingularAttribute<Project, String> dbUsername;
	public static volatile SingularAttribute<Project, String> isDefaultCode;
	public static volatile SingularAttribute<Project, String> name;
	public static volatile SingularAttribute<Project, String> sqlDialectCode;
	public static volatile SingularAttribute<Project, String> templateTypeCode;
}