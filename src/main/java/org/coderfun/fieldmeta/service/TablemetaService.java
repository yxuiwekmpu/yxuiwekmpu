package org.coderfun.fieldmeta.service;

import java.util.List;

import org.coderfun.fieldmeta.entity.EntityField;
import org.coderfun.fieldmeta.entity.PageField;
import org.coderfun.fieldmeta.entity.Tablemeta;

import klg.j2ee.common.dataaccess.BaseService;

public interface TablemetaService extends BaseService<Tablemeta, Long>{
	

	public void saveFields(Long tableId,List<EntityField> entityFields,List<PageField> pageFields);
	public void saveFieldsTbname(String tableName,List<EntityField> entityFields,List<PageField> pageFields);
}
