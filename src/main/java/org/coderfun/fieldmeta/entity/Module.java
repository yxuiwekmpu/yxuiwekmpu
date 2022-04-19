package org.coderfun.fieldmeta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.coderfun.common.BaseEntity;


/**
 * The persistent class for the fm_module database table.
 * 
 */
@Entity
@Table(name="fm_module")
public class Module extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String author;

	@Column(name="copy_right")
	private String copyRight;



	private String description;

	@Column(name="gen_path")
	private String genPath;



	@Column(name="module_name")
	private String moduleName;

	@Column(name="package_name")
	private String packageName;

	@Column(name="project_code")
	private String projectCode;

	@Lob
	private String remark;

	public Module() {
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCopyRight() {
		return this.copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}



	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenPath() {
		return this.genPath;
	}

	public void setGenPath(String genPath) {
		this.genPath = genPath;
	}


	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}