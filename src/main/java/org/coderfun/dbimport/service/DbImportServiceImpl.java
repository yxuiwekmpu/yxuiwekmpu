package org.coderfun.dbimport.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang3.StringUtils;
import org.coderfun.dbmeta.ColumnMeta;
import org.coderfun.dbmeta.DbMetaCrawler;
import org.coderfun.dbmeta.DbMetaCrawlerFactory;
import org.coderfun.fieldmeta.entity.EntityField;
import org.coderfun.fieldmeta.entity.EntityField_;
import org.coderfun.fieldmeta.entity.ImportedTable;
import org.coderfun.fieldmeta.entity.PageField;
import org.coderfun.fieldmeta.entity.Project;
import org.coderfun.fieldmeta.entity.Tablemeta;
import org.coderfun.fieldmeta.service.EntityFieldService;
import org.coderfun.fieldmeta.service.PageFieldService;
import org.coderfun.fieldmeta.service.ProjectService;
import org.coderfun.fieldmeta.service.TablemetaService;
import org.coderfun.sys.dict.DictReader;
import org.coderfun.sys.dict.SystemCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import klg.common.utils.BeanTools;
import klg.common.utils.MyPrinter;
import klg.j2ee.query.jpa.expr.AExpr;

@Service
public class DbImportServiceImpl implements DbImportService {
	@Autowired
	ProjectService projectService;

	@Autowired
	ImportedTableService importedTableService;
	
	@Autowired
	EntityFieldService entityFieldService;
	
	@Autowired
	PageFieldService pageFieldService;
	
	@Autowired
	TablemetaService tablemetaService;

	@Override
	public Set<String> getTableNames() throws SQLException {
		// TODO Auto-generated method stub
		BasicDataSource dataSource = getDataSource();
		DbMetaCrawlerFactory crawlerFactory = new DbMetaCrawlerFactory(dataSource);
		DbMetaCrawler dbMetaCrawler = crawlerFactory.newInstance();

		Set<String> tableNames = dbMetaCrawler.getTableNames();
		List<ImportedTable> importedTables = importedTableService.findAll();

		for (ImportedTable importedTable : importedTables) {
			if (tableNames.contains(importedTable.getTableName()))
				;
			tableNames.remove(importedTable.getTableName());
		}

		dataSource.close();

		return tableNames;
	}

	private BasicDataSource getDataSource() {
		Project defaultProject = projectService.getDefaultProject();
		BasicDataSource datasource = new BasicDataSource();
		datasource.setUrl(defaultProject.getDbUrl());
		datasource.setUsername(defaultProject.getDbUsername());
		datasource.setPassword(defaultProject.getDbPassword());
		datasource.setInitialSize(1);
		datasource.setMaxActive(1);

		return datasource;
	}
	
	@Override
	public void importTable(String tableName, DbImportTableOption option) throws SQLException {
		BasicDataSource dataSource = getDataSource();
		DbMetaCrawlerFactory crawlerFactory = new DbMetaCrawlerFactory(dataSource);
		DbMetaCrawler dbMetaCrawler = crawlerFactory.newInstance();
		List<PageField> examples = pageFieldService.getExamples();
		
		importTable(tableName, option, dbMetaCrawler,examples);

		dataSource.close();
	}
	@Transactional
	private void importTable(String tableName, 
			DbImportTableOption option, 
			DbMetaCrawler dbMetaCrawler,
			List<PageField> examples) throws SQLException {
		//初始化tablemeta，并持久化
		Tablemeta tablemeta = initTablemeta(tableName, option);
		tablemetaService.save(tablemeta);
		
		//实体基类的字段
		List<EntityField> baseEntityFields = null;
		if(!option.getEntitySuperClass().equals("Object")){
			String entitySuperClassFullName = DictReader.getCodeItem(tablemeta.getEntitySuperClass(),SystemCode.ClassCode.ENTITY_SUPER_CLASS).getValue();
			baseEntityFields = entityFieldService.findList(AExpr.eq(EntityField_.tableName, entitySuperClassFullName));			
		}
	
		List<ColumnMeta> columns = dbMetaCrawler.getColumns(tableName);	
		for (ColumnMeta column : columns) {
			if(isBaseField(baseEntityFields, column)){
				continue;
			}
			EntityField entityField = new EntityField();
			PageField pageField = new PageField();

			PageField example = lookupExample(examples, column.getTypeName());
			if(example != null){
				BeanTools.copyProperties(pageField, example, "id","entityField");
				BeanTools.copyProperties(entityField,  example.getEntityField(), "id");				
			}

			
			entityField.setTableName(tableName);
			pageField.setTableName(tableName);

			setEntityField(entityField, column);
			
			entityFieldService.save(entityField);
			pageField.setEntityField(entityField);
			pageFieldService.save(pageField);
		}

	}
	
	private PageField lookupExample(List<PageField> examples,String sqlType){
		for(PageField example:examples){
			String tag = example.getEntityField().getColumnName().toLowerCase();
			System.out.println("<<----------------：" + tag);
			if(tag.equals(new String("eg_"+sqlType).toLowerCase())){
				MyPrinter.print(example);
				return example;
			}			
		}
		return null;
	}
	
	private boolean isBaseField(List<EntityField> baseEntityFields,ColumnMeta columnMeta){
		if(baseEntityFields == null)
			return false;
		for(EntityField entityField : baseEntityFields){
			if(entityField.getAttrName().equals(NameUtils.underlineToHump(columnMeta.getName()))){
				return true;
			}
		}
		return false;
	}
	
	
	private Tablemeta initTablemeta(String tableName, DbImportTableOption option){
		//去掉表前缀
		String removeTablePrefix = option.getRemoveTablePrefix();
		String temp = new String(tableName);
		if(StringUtils.isNotEmpty(removeTablePrefix)){
			temp = tableName.substring(removeTablePrefix.trim().length());
		}
		Tablemeta tablemeta = new Tablemeta();
		tablemeta.setTableName(tableName);
		tablemeta.setEntityName(NameUtils.underlineToHump(temp));
		tablemeta.setModuleId(option.getModuleId());
		tablemeta.setModuleName(option.getModuleName());
		tablemeta.setEntitySuperClass(option.getEntitySuperClass());
		return tablemeta;
	}
	
	private void setEntityField(EntityField entityField,ColumnMeta columnMeta){
		entityField.setColumnName(columnMeta.getName());
		entityField.setAttrName(NameUtils.underlineToHump(columnMeta.getName()));
		entityField.setLength(Long.valueOf(columnMeta.getLength()));
		entityField.setComments(columnMeta.getComment());
	}
	

	
	@Override
	public void importTables(List<String> tableNames, DbImportTableOption option) throws SQLException {
		// TODO Auto-generated method stub
		BasicDataSource dataSource = getDataSource();
		DbMetaCrawlerFactory crawlerFactory = new DbMetaCrawlerFactory(dataSource);
		DbMetaCrawler dbMetaCrawler = crawlerFactory.newInstance();
		List<PageField> examples = pageFieldService.getExamples();
		for(String tableName:tableNames){
			importTable(tableName, option, dbMetaCrawler,examples);
		}
		dataSource.close();
	}

}
