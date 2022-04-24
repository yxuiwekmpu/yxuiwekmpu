package org.coderfun.fieldmeta.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.coderfun.common.BaseEntity;

/**
 * The persistent class for the fm_tablemeta database table.
 * 
 */
@Entity
@Table(name = "fm_tablemeta")
@Access(AccessType.FIELD)
public class Tablemeta extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "entity_name")
	private String entityName;

	@Column(name = "simple_name")
	private String simpleName;

	@Column(name = "module_name")
	private String moduleName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "is_have_delete")
	private String isHaveDelete;

	@Column(name = "is_have_disable_enable")
	private String isHaveDisableEnable;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_time")
	private Date modifyTime;

	@Lob
	private String options;

	@Column(name = "parent_table_fk_name")
	private String parentTableFkName;

	@Column(name = "parent_table_name")
	private String parentTableName;

	@Lob
	private String remarks;

	@Column(name = "table_name")
	private String tableName;

	public Tablemeta() {
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIsHaveDelete() {
		return isHaveDelete;
	}

	public void setIsHaveDelete(String isHaveDelete) {
		this.isHaveDelete = isHaveDelete;
	}

	public String getIsHaveDisableEnable() {
		return isHaveDisableEnable;
	}

	public void setIsHaveDisableEnable(String isHaveDisableEnable) {
		this.isHaveDisableEnable = isHaveDisableEnable;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getParentTableFkName() {
		return this.parentTableFkName;
	}

	public void setParentTableFkName(String parentTableFkName) {
		this.parentTableFkName = parentTableFkName;
	}

	public String getParentTableName() {
		return this.parentTableName;
	}

	public void setParentTableName(String parentTableName) {
		this.parentTableName = parentTableName;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}