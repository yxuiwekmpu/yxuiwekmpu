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
@Table(name="fm_tablemeta")
@Access(AccessType.FIELD)
public class Tablemeta extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="class_name")
	private String className;

	private String comments;

	@Column(name="comments_simple")
	private String commentsSimple;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private BigInteger isHaveDelete;

	private BigInteger isHaveDisableEnable;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_time")
	private Date modifyTime;

	@Lob
	private String options;

	@Column(name="parent_table_fk_name")
	private String parentTableFkName;

	@Column(name="parent_table_name")
	private String parentTableName;

	@Lob
	private String remarks;

	@Column(name="table_name")
	private String tableName;

	@Column(name="tpl_category")
	private String tplCategory;

	public Tablemeta() {
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCommentsSimple() {
		return this.commentsSimple;
	}

	public void setCommentsSimple(String commentsSimple) {
		this.commentsSimple = commentsSimple;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigInteger getIsHaveDelete() {
		return this.isHaveDelete;
	}

	public void setIsHaveDelete(BigInteger isHaveDelete) {
		this.isHaveDelete = isHaveDelete;
	}

	public BigInteger getIsHaveDisableEnable() {
		return this.isHaveDisableEnable;
	}

	public void setIsHaveDisableEnable(BigInteger isHaveDisableEnable) {
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

	public String getTplCategory() {
		return this.tplCategory;
	}

	public void setTplCategory(String tplCategory) {
		this.tplCategory = tplCategory;
	}

}