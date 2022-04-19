package org.coderfun.fieldmeta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.coderfun.common.BaseEntity;


/**
 * The persistent class for the fm_validation database table.
 * 
 */
@Entity
@Table(name="fm_validation")

public class Validation extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;



	private String description;

	@Lob
	@Column(name="java_valid")
	private String javaValid;

	@Lob
	@Column(name="js_valid")
	private String jsValid;

	private String message;



	private String name;

	@Lob
	private String remark;

	public Validation() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJavaValid() {
		return this.javaValid;
	}

	public void setJavaValid(String javaValid) {
		this.javaValid = javaValid;
	}

	public String getJsValid() {
		return this.jsValid;
	}

	public void setJsValid(String jsValid) {
		this.jsValid = jsValid;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}