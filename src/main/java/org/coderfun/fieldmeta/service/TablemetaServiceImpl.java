package org.coderfun.fieldmeta.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.coderfun.fieldmeta.dao.EntityFieldDAO;
import org.coderfun.fieldmeta.dao.PageFieldDAO;
import org.coderfun.fieldmeta.dao.TablemetaDAO;
import org.coderfun.fieldmeta.entity.EntityField;
import org.coderfun.fieldmeta.entity.EntityField_;
import org.coderfun.fieldmeta.entity.PageField;
import org.coderfun.fieldmeta.entity.Tablemeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klg.j2ee.common.dataaccess.BaseServiceImpl;
import klg.j2ee.query.jpa.expr.AExpr;

@Service
public class TablemetaServiceImpl  extends BaseServiceImpl<Tablemeta, Long> implements TablemetaService{
	@Autowired
	TablemetaDAO tablemetaDAO;
	
	@Autowired
	PageFieldDAO pageFieldDAO ;

	@Autowired
	EntityFieldDAO entityFieldDAO;
	
	@Override
	@Transactional
	public void saveFields(String tableName, List<EntityField> entityFields, List<PageField> pageFields) {
		// TODO Auto-generated method stub
		
		for(int i=0 ; i <entityFields.size();i++){
			EntityField entityField = entityFields.get(i);
			
			EntityField unique = entityFieldDAO.getOne(
					AExpr.eq(EntityField_.tableName, tableName),
					AExpr.eq(EntityField_.attrName, entityField.getAttrName()));
			if(unique != null){
				continue;
			}
			
			entityField.setTableName(tableName);
			entityField.setColumnSort(BigDecimal.valueOf(i));
			entityFieldDAO.save(entityField);
			
			PageField pageField=pageFields.get(i);
			pageField.setEntityField(entityField);
			pageField.setTableName(tableName);
			
			pageFieldDAO.save(pageField);
		}
	}	
}
