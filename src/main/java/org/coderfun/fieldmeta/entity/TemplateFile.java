package org.coderfun.fieldmeta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.coderfun.common.BaseEntity;

/**
 * The persistent class for the wp_template_file database table.
 * 
 */
@Entity
@Table(name = "fm_template_file")
public class TemplateFile extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	private String name;
	
	@Column(name = "uuid_name")
	private String uuidName;

	@Column(name = "gen_filekey_path")
	private String genFilekeyPath;

	@Column(name = "gen_filekey_type")
	private String genFilekeyType;

	@Column(name = "gen_filekey_pattern")
	private String genFilekeyPattern;

	public String getGenFilekeyPattern() {
		return genFilekeyPattern;
	}

	public void setGenFilekeyPattern(String genFilekeyPattern) {
		this.genFilekeyPattern = genFilekeyPattern;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuidName() {
		return uuidName;
	}

	public void setUuidName(String uuidName) {
		this.uuidName = uuidName;
	}

	public String getGenFilekeyPath() {
		return this.genFilekeyPath;
	}

	public void setGenFilekeyPath(String genFilekeyPath) {
		this.genFilekeyPath = genFilekeyPath;
	}

	public String getGenFilekeyType() {
		return this.genFilekeyType;
	}

	public void setGenFilekeyType(String genFilekeyType) {
		this.genFilekeyType = genFilekeyType;
	}
}