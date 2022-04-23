package org.coderfun.fieldmeta.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.coderfun.common.BaseEntity;

/**
 * The persistent class for the fm_type_mapping database table.
 * 
 */
@Entity
@Table(name = "fm_type_mapping")
@Access(AccessType.FIELD)
public class TypeMapping extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "dialect")
	private String dialect;

	@Column(name = "full_java_type")
	private String fullJavaType;

	@Column(name = "java_type")
	private String javaType;

	@Column(name = "sql_type")
	private String sqlType;

	public TypeMapping() {
	}

	public String getDialect() {
		return this.dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public String getFullJavaType() {
		return this.fullJavaType;
	}

	public void setFullJavaType(String fullJavaType) {
		this.fullJavaType = fullJavaType;
	}

	public String getJavaType() {
		return this.javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getSqlType() {
		return this.sqlType;
	}

	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}

}