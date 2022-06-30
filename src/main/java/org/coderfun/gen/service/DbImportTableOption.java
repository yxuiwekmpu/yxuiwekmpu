package org.coderfun.gen.service;

public class DbImportTableOption {
	private boolean removeTableNamePrefix;
	private String tablePrefix;

	private String moduleName;
	private String entitySuperClass;
	private String canDelete;
	private String canEdit;

	public boolean isRemoveTableNamePrefix() {
		return removeTableNamePrefix;
	}

	public void setRemoveTableNamePrefix(boolean removeTableNamePrefix) {
		this.removeTableNamePrefix = removeTableNamePrefix;
	}

	public String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getEntitySuperClass() {
		return entitySuperClass;
	}

	public void setEntitySuperClass(String entitySuperClass) {
		this.entitySuperClass = entitySuperClass;
	}

	public String getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(String canDelete) {
		this.canDelete = canDelete;
	}

	public String getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(String canEdit) {
		this.canEdit = canEdit;
	}

}
