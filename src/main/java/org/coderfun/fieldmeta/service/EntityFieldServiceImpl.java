package org.coderfun.fieldmeta.service;

import org.coderfun.fieldmeta.dao.EntityFieldDAO;
import org.coderfun.fieldmeta.dao.PageFieldDAO;
import org.coderfun.fieldmeta.entity.EntityField;
import org.coderfun.fieldmeta.entity.PageField;
import org.coderfun.fieldmeta.entity.PageField_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import klg.common.utils.BeanTools;
import klg.j2ee.common.dataaccess.BaseServiceImpl;
import klg.j2ee.query.jpa.expr.AExpr;

@Service
public class EntityFieldServiceImpl extends BaseServiceImpl<EntityField, Long> implements EntityFieldService {
	@Autowired
	EntityFieldDAO entityFieldDAO;

	@Autowired
	PageFieldDAO pageFieldDAO ;

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		EntityField entityField = BeanTools.newAndSet(EntityField.class, "id", id);
		PageField pageField = pageFieldDAO.getOne(AExpr.eq(PageField_.entityField, entityField));
		if(pageField !=null){
			pageFieldDAO.delete(pageField.getId());	
		}
		entityFieldDAO.delete(id);
	}

	@Override
	public EntityField save(EntityField entityField) {
		// TODO Auto-generated method stub

		return null;
	}
}
