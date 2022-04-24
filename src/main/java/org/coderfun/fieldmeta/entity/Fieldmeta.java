package org.coderfun.fieldmeta.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.coderfun.common.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.math.BigInteger;

/**
 * The persistent class for the fm_fieldmeta database table.
 * 
 */
@Entity
@Table(name = "fm_fieldmeta")
public class Fieldmeta extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "table_name")
	private String tableName;

	// field begin

	@Column(name = "column_name")
	private String columnName;

	@Column(name = "column_sort")
	private BigDecimal columnSort;

	@Column(name = "column_type")
	private String columnType;

	@Column(name = "column_label")
	private String columnLabel;

	private String comments;

	@Column(name = "attr_name")
	private String attrName;

	@Column(name = "attr_type")
	private String attrType;

	@Column(name = "is_pk")
	private String isPk;

	@Column(name = "not_null")
	private String notNull; 

	@Column(name = "is_insert")
	private String isInsert;

	@Column(name = "is_update")
	private String isUpdate;

	// field end

	@Column(name = "is_list")
	private String isList;

	@Column(name = "is_query")
	private String isQuery;

	@Column(name = "query_type")
	private String queryType;

	// form

	@Column(name = "is_edit")
	private String isEdit;

	@Column(name = "is_required")
	private String isRequired;

	@Column(name = "show_type")
	private String showType;

	@Column(name = "grid_row_col")
	private String gridRowCol;

	@Column(name = "is_new_line")
	private String isNewLine;

	@Column(name = "code_class")
	private String codeClass;

	@Column(name = "code_name")
	private String codeName;

	@Lob
	@Column(name = "field_valid")
	private String fieldValid;

	@Lob
	private String options;

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

	public String getCodeClass() {
		return this.codeClass;
	}

	public void setCodeClass(String codeClass) {
		this.codeClass = codeClass;
	}

	public String getCodeName() {
		return this.codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
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

	public String getFieldValid() {
		return this.fieldValid;
	}

	public void setFieldValid(String fieldValid) {
		this.fieldValid = fieldValid;
	}

	public String getGridRowCol() {
		return this.gridRowCol;
	}

	public void setGridRowCol(String gridRowCol) {
		this.gridRowCol = gridRowCol;
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

	public String getIsNewLine() {
		return this.isNewLine;
	}

	public void setIsNewLine(String isNewLine) {
		this.isNewLine = isNewLine;
	}

	public String getNotNull() {
		return notNull;
	}

	public void setNotNull(String notNull) {
		this.notNull = notNull;
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

	public String getIsRequired() {
		return this.isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
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