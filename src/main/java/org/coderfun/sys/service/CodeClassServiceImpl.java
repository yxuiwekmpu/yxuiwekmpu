package org.coderfun.sys.service;

import org.coderfun.sys.dao.CodeClassDAO;
import org.coderfun.sys.entity.CodeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klg.j2ee.common.dataaccess.BaseServiceImpl;

@Service
public class CodeClassServiceImpl  extends BaseServiceImpl<CodeClass, Long> implements CodeClassService{
	@Autowired
	CodeClassDAO codeClassDAO;
}
