package org.coderfun.gen.service;

import java.io.IOException;
import java.util.List;

public interface GenService {


	/**
	 * 实体名
	 */
	
	static final String ENP = "[ENP]";
	/**
	 * 实体名 ，首字母小写
	 */
	static final String LFENP = "[LENP]";
	
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
	 * @throws IOException 
	 */
	public byte[] genCodeByZip(List<Long> tablemetaIds) throws IOException ;
	
	
	/**
	 * 从数据库导入表结构
	 * @param tableName
	 */
	public void importTable(String tableName);
	public void importTables(List<String> tableNames);
	

}
