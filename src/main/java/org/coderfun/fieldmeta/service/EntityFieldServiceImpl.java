package org.coderfun.fieldmeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import klg.common.utils.MyBeanUtil;
import klg.j2ee.common.dataaccess.BaseServiceImpl;
import klg.j2ee.query.jpa.expr.AExpr;

import org.coderfun.fieldmeta.dao.EntityFieldDAO;
import org.coderfun.fieldmeta.entity.EntityField;
import org.coderfun.fieldmeta.entity.PageField;
import org.coderfun.fieldmeta.entity.PageField_;

@Service
public class EntityFieldServiceImpl extends BaseServiceImpl<EntityField, Long> implements EntityFieldService {
	@Autowired
	EntityFieldDAO entityFieldDAO;

	@Autowired
	PageFieldService pageFieldService;

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		EntityField entityField = MyBeanUtil.newAndSet(EntityField.class, "id", id);
		PageField pageField = pageFieldService.getOne(AExpr.eq(PageField_.entityField, entityField));
		if(pageField !=null){
			pageFieldService.delete(pageField.getId());			
		}
		super.delete(id);
	}

	@Override
	@Transactional
	public EntityField save(EntityField entity) {
		// TODO Auto-generated method stub
		EntityField entityField = super.save(entity);
		PageField pageField = MyBeanUtil.newAndSet(PageField.class, "entityField", entityField);
		pageFieldService.save(pageField);
		return entityField;
	}
}
