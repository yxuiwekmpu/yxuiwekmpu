package org.coderfun.fieldmeta.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.coderfun.common.BaseEntity;




/**
 * The persistent class for the fm_fieldmeta database table.
 * 
 */
@Entity
@Table(name="fm_fieldmeta")
public class Fieldmeta extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="attr_name")
	private String attrName;

	@Column(name="attr_type")
	private String attrType;

	@Column(name="column_label")
	private String columnLabel;

	@Column(name="column_name")
	private String columnName;

	@Column(name="column_sort")
	private BigDecimal columnSort;

	@Column(name="column_type")
	private String columnType;

	private String comments;

	@Column(name="is_edit")
	private String isEdit;

	@Column(name="is_insert")
	private String isInsert;

	@Column(name="is_list")
	private String isList;

	@Column(name="is_null")
	private String isNull;

	@Column(name="is_pk")
	private String isPk;

	@Column(name="is_query")
	private String isQuery;

	@Column(name="is_update")
	private String isUpdate;

	@Lob
	private String options;

	@Column(name="query_type")
	private String queryType;

	@Column(name="show_type")
	private String showType;

	@Column(name="table_name")
	private String tableName;

	public Fieldmeta() {
	}

	public String getAttrName() {
		return this.attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrType() {
		return this.attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public String getColumnLabel() {
		return this.columnLabel;
	}

	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public BigDecimal getColumnSort() {
		return this.columnSort;
	}

	public void setColumnSort(BigDecimal columnSort) {
		this.columnSort = columnSort;
	}

	public String getColumnType() {
		return this.columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getIsEdit() {
		return this.isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public String getIsInsert() {
		return this.isInsert;
	}

	public void setIsInsert(String isInsert) {
		this.isInsert = isInsert;
	}

	public String getIsList() {
		return this.isList;
	}

	public void setIsList(String isList) {
		this.isList = isList;
	}

	public String getIsNull() {
		return this.isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public String getIsPk() {
		return this.isPk;
	}

	public void setIsPk(String isPk) {
		this.isPk = isPk;
	}

	public String getIsQuery() {
		return this.isQuery;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	public String getIsUpdate() {
		return this.isUpdate;
	}

	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getQueryType() {
		return this.queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getShowType() {
		return this.showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}