package org.coderfun.fieldmeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import klg.j2ee.common.dataaccess.BaseServiceImpl;
import org.coderfun.fieldmeta.dao.FieldmetaDAO;
import org.coderfun.fieldmeta.entity.Fieldmeta;

@Service
public class FieldmetaServiceImpl  extends BaseServiceImpl<Fieldmeta, Long> implements FieldmetaService{
	@Autowired
	FieldmetaDAO fieldmetaDAO;
}
