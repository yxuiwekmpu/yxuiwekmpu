package org.coderfun.fieldmeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import klg.j2ee.common.dataaccess.BaseServiceImpl;
import org.coderfun.fieldmeta.dao.TablemetaDAO;
import org.coderfun.fieldmeta.entity.Tablemeta;

@Service
public class TablemetaServiceImpl  extends BaseServiceImpl<Tablemeta, Long> implements TablemetaService{
	@Autowired
	TablemetaDAO tablemetaDAO;
}
