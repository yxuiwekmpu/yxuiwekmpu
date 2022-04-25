package org.coderfun.fieldmeta.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.coderfun.common.BaseEntity;

/**
 * The persistent class for the fm_project database table.
 * 
 */
@Entity
@Table(name = "fm_project")
@Access(AccessType.FIELD)
public class Project extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "db_password")
	private String dbPassword;

	@Column(name = "db_url")
	private String dbUrl;

	@Column(name = "db_username")
	private String dbUsername;

	@Column(name = "is_default_code")
	private String isDefaultCode;

	@Column(name = "name")
	private String name;

	@Column(name = "sql_dialect_code")
	private String sqlDialectCode;

	@Column(name = "template_type_code")
	private String templateTypeCode;

	public Project() {
	}


	public String getDbPassword() {
		return this.dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbUrl() {
		return this.dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return this.dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getIsDefaultCode() {
		return this.isDefaultCode;
	}

	public void setIsDefaultCode(String isDefaultCode) {
		this.isDefaultCode = isDefaultCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSqlDialectCode() {
		return this.sqlDialectCode;
	}

	public void setSqlDialectCode(String sqlDialectCode) {
		this.sqlDialectCode = sqlDialectCode;
	}

	public String getTemplateTypeCode() {
		return this.templateTypeCode;
	}

	public void setTemplateTypeCode(String templateTypeCode) {
		this.templateTypeCode = templateTypeCode;
	}

}