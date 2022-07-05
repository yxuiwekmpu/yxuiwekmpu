package org.coderfun.fieldmeta.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.coderfun.common.exception.AppException;
import org.coderfun.common.exception.ErrorCodeEnum;
import org.coderfun.fieldmeta.dao.EntityFieldDAO;
import org.coderfun.fieldmeta.dao.PageFieldDAO;
import org.coderfun.fieldmeta.dao.TablemetaDAO;
import org.coderfun.fieldmeta.entity.EntityField;
import org.coderfun.fieldmeta.entity.EntityField_;
import org.coderfun.fieldmeta.entity.PageField;
import org.coderfun.fieldmeta.entity.Project;
import org.coderfun.fieldmeta.entity.Tablemeta;
import org.coderfun.fieldmeta.entity.Tablemeta_;
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
	
	/**
	 * 同一模块下，不允许存在重复的表
	 */
	@Override
	@Transactional
	public synchronized Tablemeta save(Tablemeta entity) {
		// TODO Auto-generated method stub
	
		Tablemeta tablemeta =  tablemetaDAO.getOne(
				AExpr.eq(Tablemeta_.moduleId, entity.getModuleId()),
				AExpr.eq(Tablemeta_.tableName, entity.getTableName()));
		if(tablemeta !=null){
			throw new AppException(ErrorCodeEnum.DATA_EXISTED);
		}
		return super.save(entity);
	}
	
	@Override
	@Transactional
	public void saveFieldsTbname(String tableName, List<EntityField> entityFields, List<PageField> pageFields) {
		// TODO Auto-generated method stub
		
		for(int i=0 ; i <entityFields.size();i++){
			EntityField entityField = entityFields.get(i);
			
			if(entityField.getId() == null){
				EntityField unique = entityFieldDAO.getOne(
						AExpr.eq(EntityField_.tableName, tableName),
						AExpr.eq(EntityField_.attrName, entityField.getAttrName()));
				if(unique != null){
					continue;
				}
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


	
	@Override
	public void saveFields(Long tableId, List<EntityField> entityFields, List<PageField> pageFields) {
		// TODO Auto-generated method stub
		
		Tablemeta tablemeta = tablemetaDAO.getById(tableId);
		for(int i=0 ; i <entityFields.size();i++){
			EntityField entityField = entityFields.get(i);
			
			if(entityField.getId() == null){
				EntityField unique = entityFieldDAO.getOne(
						AExpr.eq(EntityField_.tableId, tablemeta.getId()),
						AExpr.eq(EntityField_.attrName, entityField.getAttrName()));
				if(unique != null){
					continue;
				}
			}
	
			entityField.setTableName(tablemeta.getTableName());
			entityField.setTableId(tablemeta.getId());
			entityField.setColumnSort(BigDecimal.valueOf(i));
			entityFieldDAO.save(entityField);
			
			PageField pageField=pageFields.get(i);
			pageField.setEntityField(entityField);
			pageField.setTableName(tablemeta.getTableName());
			pageField.setTableId(tablemeta.getId());
			
			pageFieldDAO.save(pageField);
		}
	}	
}
