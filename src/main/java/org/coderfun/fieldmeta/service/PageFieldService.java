package org.coderfun.fieldmeta.service;

import java.util.List;

import org.coderfun.fieldmeta.entity.PageField;

import klg.j2ee.common.dataaccess.BaseService;

public interface PageFieldService extends BaseService<PageField, Long> {
	public List<PageField> getExamples();
}
