package org.coderfun.gen.service;

import java.util.List;
import java.util.Set;

import org.coderfun.fieldmeta.entity.EntityField;
import org.coderfun.fieldmeta.entity.Module;
import org.coderfun.fieldmeta.entity.PageField;
import org.coderfun.fieldmeta.entity.Tablemeta;

public class CodeModel {

	private Tablemeta tablemeta;
	private String entityNameOfFirstLowcase;
	private String entityNameOfAllLowcase;
	private String entitySuperClassFullName;
	private Set<String> entityImportList;
	private EntityField pkColumn;

	private List<EntityField> entityFields;
	private List<EntityField> baseEntityFields;

	private List<PageField> pageFields;
	private List<PageField> basePageFields;
	// 所有pageField
	private List<PageField> allPageFields;

	private Module module;
	private String permissionPrefix;
	private String nowTime;

	public String getPermissionPrefix() {
		return permissionPrefix;
	}

	public void setPermissionPrefix(String permissionPrefix) {
		this.permissionPrefix = permissionPrefix;
	}

	public String getEntitySuperClassFullName() {
		return entitySuperClassFullName;
	}

	public void setEntitySuperClassFullName(String entitySuperClassFullName) {
		this.entitySuperClassFullName = entitySuperClassFullName;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Tablemeta getTablemeta() {
		return tablemeta;
	}

	public void setTablemeta(Tablemeta tablemeta) {
		this.tablemeta = tablemeta;
	}

	public String getEntityNameOfFirstLowcase() {
		return entityNameOfFirstLowcase;
	}

	public void setEntityNameOfFirstLowcase(String entityNameOfFirstLowcase) {
		this.entityNameOfFirstLowcase = entityNameOfFirstLowcase;
	}

	public String getEntityNameOfAllLowcase() {
		return entityNameOfAllLowcase;
	}

	public void setEntityNameOfAllLowcase(String entityNameOfAllLowcase) {
		this.entityNameOfAllLowcase = entityNameOfAllLowcase;
	}

	public String getNowTime() {
		return nowTime;
	}

	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}

	public EntityField getPkColumn() {
		return pkColumn;
	}

	public void setPkColumn(EntityField pkColumn) {
		this.pkColumn = pkColumn;
	}

	public List<EntityField> getEntityFields() {
		return entityFields;
	}

	public void setEntityFields(List<EntityField> entityFields) {
		this.entityFields = entityFields;
	}

	public List<EntityField> getBaseEntityFields() {
		return baseEntityFields;
	}

	public void setBaseEntityFields(List<EntityField> baseEntityFields) {
		this.baseEntityFields = baseEntityFields;
	}

	public List<PageField> getPageFields() {
		return pageFields;
	}

	public void setPageFields(List<PageField> pageFields) {
		this.pageFields = pageFields;
	}

	public List<PageField> getBasePageFields() {
		return basePageFields;
	}

	public void setBasePageFields(List<PageField> basePageFields) {
		this.basePageFields = basePageFields;
	}

	public Set<String> getEntityImportList() {
		return entityImportList;
	}

	public void setEntityImportList(Set<String> entityImportList) {
		this.entityImportList = entityImportList;
	}

	public List<PageField> getAllPageFields() {
		return allPageFields;
	}

	public void setAllPageFields(List<PageField> allPageFields) {
		this.allPageFields = allPageFields;
	}

}
