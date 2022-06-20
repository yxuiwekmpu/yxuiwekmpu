package org.coderfun.gen.service;

import java.util.List;

public interface GenService {

	static final String TEMPLATE_DIR_KEY = "/template/";
	/**
	 * 实体名
	 */
	
	static final String ENP = "#{enp}";
	/**
	 * 实体名 ，首字母小写
	 */
	static final String LFENP = "#{lenp}";
	
	static final String[] JAVA_LANG_TYPES = {"Long","String","Integer"}; 
	
	
	/**
	 * 生成代码
	 * @param tablemetaId
	 */
	public List<GenCodeFile> genCodeFiles(Long tablemetaId);
	
	/**
	 * 
	 * 生成代码，并打包zip
	 * 
	 * @param tablemetaIds
	 * @return zip 数据
	 */
	public byte[] genCodeByZip(List<Long> tablemetaIds);


	/**
	 * 生成建表sql
	 * 
	 * @param tablemetaId
	 */
	public String genSql(Long tablemetaId);
	public String genSql(List<Long> tablemetaIds);
	
	
	/**
	 * 从数据库导入表结构
	 * @param tableName
	 */
	public void importTable(String tableName);
	public void importTables(List<String> tableNames);
	
}
