package org.coderfun.fieldmeta.service;

import java.util.List;

import org.coderfun.fieldmeta.dao.PageFieldDAO;
import org.coderfun.fieldmeta.entity.PageField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klg.j2ee.common.dataaccess.BaseServiceImpl;

@Service
public class PageFieldServiceImpl  extends BaseServiceImpl<PageField, Long> implements PageFieldService{
	@Autowired
	PageFieldDAO pageFieldDAO;
	
	public List<PageField> getExamples(){
		String sql = "SELECT fp.* FROM fm_field_page fp INNER JOIN fm_field_entity fe ON fp.entity_field_id=fe.id  WHERE fe.attr_name LIKE 'eg_%'";
		
		return pageFieldDAO.getEntityManager().createNativeQuery(sql,PageField.class).getResultList();
	}
}
