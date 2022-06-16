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
	private String path;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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