package org.coderfun.sys.dict.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.coderfun.common.BaseEntity;

@Entity
@Table(name = "sys_codeclass")
@Access(AccessType.FIELD)
public class CodeClass extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String value;
	private Integer ordernum;

	@Column(name = "module_code")
	private String moduleCode;

	@Column(name = "is_sys")
	private String isSys;

	private String remark;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getIsSys() {
		return isSys;
	}

	public void setIsSys(String isSys) {
		this.isSys = isSys;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
}
