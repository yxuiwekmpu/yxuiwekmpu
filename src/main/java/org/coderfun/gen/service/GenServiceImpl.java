package org.coderfun.gen.service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.coderfun.fieldmeta.entity.EntityField;
import org.coderfun.fieldmeta.entity.EntityField_;
import org.coderfun.fieldmeta.entity.Module_;
import org.coderfun.fieldmeta.entity.PageField;
import org.coderfun.fieldmeta.entity.PageField_;
import org.coderfun.fieldmeta.entity.Tablemeta;
import org.coderfun.fieldmeta.entity.TemplateFile;
import org.coderfun.fieldmeta.entity.Validation;
import org.coderfun.fieldmeta.service.EntityFieldService;
import org.coderfun.fieldmeta.service.ModuleService;
import org.coderfun.fieldmeta.service.PageFieldService;
import org.coderfun.fieldmeta.service.TablemetaService;
import org.coderfun.fieldmeta.service.TemplateFileService;
import org.coderfun.fieldmeta.service.ValidationService;
import org.coderfun.sys.dict.DictReader;
import org.coderfun.sys.dict.SystemCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import klg.common.utils.DateTools;
import klg.common.utils.MyPrinter;
import klg.j2ee.query.jpa.expr.AExpr;

@Service
public class GenServiceImpl implements GenService {

	@Autowired
	TemplateFileService templateFileService;
	
	@Autowired
	ModuleService moduleService;

	@Autowired
	TablemetaService tablemetaService;

	@Autowired
	EntityFieldService entityFieldService;

	@Autowired
	PageFieldService pageFieldService;
	
	@Autowired
	ValidationService validationService;
	

	public CodeModel init(Tablemeta tablemeta) {
		// TODO Auto-generated method stub

		CodeModel codeModel = new CodeModel();
		codeModel.setTablemeta(tablemeta);
		codeModel.setEntityNameOfAllLowcase(StringUtils.uncapitalize(tablemeta.getEntityName()));
		codeModel.setEntityNameOfAllLowcase(tablemeta.getEntityName().toLowerCase());
		codeModel.setNowTime(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(new Date()));
		codeModel.setModule(moduleService.getOne(AExpr.eq(Module_.moduleName, tablemeta.getModuleName())));

		String entitySuperClassFullName = DictReader.getCodeItem(tablemeta.getEntitySuperClass(),SystemCode.ClassCode.ENTITY_SUPER_CLASS).getValue();
		codeModel.setEntitySuperClassFullName(entitySuperClassFullName);
		
		Sort efSort = new Sort(Direction.DESC, "columnSort");
		List<EntityField> entityFields = entityFieldService.findList(efSort, AExpr.eq(EntityField_.tableName, tablemeta.getTableName()));
		List<EntityField> baseEntityFields = entityFieldService.findList(efSort, AExpr.eq(EntityField_.tableName, entitySuperClassFullName));
		
		Sort pfSort = new Sort(Direction.DESC, "entityField.columnSort");
		List<PageField> pageFields = pageFieldService.findList(pfSort, AExpr.eq(PageField_.tableName, tablemeta.getTableName()));
		List<PageField> basePageFields = pageFieldService.findList(pfSort, AExpr.eq(PageField_.tableName, entitySuperClassFullName));
		
		codeModel.setEntityFields(entityFields);
		codeModel.setBaseEntityFields(baseEntityFields);
		codeModel.setPageFields(pageFields);
		codeModel.setBasePageFields(basePageFields);
		
		genEntityImportList(codeModel);
		
		lookUpValidation(codeModel);
		lookUpPkColumn(codeModel);
		
		MyPrinter.printJson(codeModel);
		
		return codeModel;
	}
	
	private  void lookUpValidation(CodeModel codeModel){
		Map<String,Validation> mappedValidations = mappingValidations();
		
		
		for(EntityField entityField:codeModel.getEntityFields()){
			if(StringUtils.isNotEmpty(entityField.getFieldValidCode()))
				entityField.setFieldValidation(mappedValidations.get(entityField.getFieldValidCode()).getJavaValid());
		}
		
		for(PageField pageField : codeModel.getPageFields()){
			if(StringUtils.isNotEmpty(pageField.getEntityField().getFieldValidCode()))
				pageField.setFieldValidation(mappedValidations.get(pageField.getEntityField().getFieldValidCode()).getJsValid());
		}
	}
	
	private Map<String,Validation> mappingValidations(){
		List<Validation> validations= validationService.findAll();
		Map<String,Validation> mapping = new HashMap<>();
		for(Validation validation : validations){
			mapping.put(validation.getCode(), validation);
		}
		return mapping;
	}
	
	
	private void lookUpPkColumn(CodeModel codeModel){
		for(EntityField baseEntityField:codeModel.getBaseEntityFields()){
			if(SystemCode.YES.equals(baseEntityField.getPkRestrict())){
				codeModel.setPkColumn(baseEntityField);
				return;
			}
		}
		
		for(EntityField entityField:codeModel.getEntityFields()){
			if(SystemCode.YES.equals(entityField.getPkRestrict())){
				codeModel.setPkColumn(entityField);
				return;
			}
		}
	}
	
	private void genEntityImportList(CodeModel codeModel){
		Set<String> importList = new LinkedHashSet<>();
		importList.add(codeModel.getEntitySuperClassFullName());
		for(EntityField entityField:codeModel.getEntityFields()){
			if(!ArrayUtils.contains(JAVA_LANG_TYPES, entityField.getAttrType())){
				String fullJavaType = DictReader.getCodeItem(entityField.getAttrType(),SystemCode.ClassCode.JAVA_TYPE).getValue();
				importList.add(fullJavaType);				
			}
		}
		
		codeModel.setEntityImportList(importList);
	}
	
	
	@Override
	public List<GenCodeFile> genCodeFiles(Long tablemetaId){
		// TODO Auto-generated method stub
		CodeModel codeModel = init(tablemetaService.getById(tablemetaId));
		List<TemplateFile> templateFiles = templateFileService.findAll();
		List<GenCodeFile> genCodeFiles = new ArrayList<>();
		
		for(TemplateFile templateFile:templateFiles){
			GenCodeFile genCodeFile = new GenCodeFile();
			if(templateFile.getGenFilekeyPattern().contains(ENP)){
				genCodeFile.setName(templateFile.getGenFilekeyPattern().replace(ENP, codeModel.getTablemeta().getEntityName()));
			}else{
				genCodeFile.setName(templateFile.getGenFilekeyPattern().replace(LFENP, codeModel.getEntityNameOfFirstLowcase()));
			}
			
			if(templateFile.getGenFilekeyType().equals(SystemCode.GenFileKeyType.MODULE_NAME)){
				genCodeFile.setPath(templateFile.getGenFilekeyPath() + codeModel.getModule().getModuleName() +"/");
			}else{
				genCodeFile.setPath(templateFile.getGenFilekeyPath() + codeModel.getModule().getPackageName().replaceAll("\\.", "/") +"/");
			}
			
			genCodeFile.setContent(processTemplate(templateFile, codeModel));
			
			genCodeFiles.add(genCodeFile);
		}
		
		return genCodeFiles;
	}
	
	
	private static String processTemplate(TemplateFile templateFile, Object codeModel) {
		StringWriter writer = new StringWriter();
		String result = null;
		try {
			Template template = FreemarkerHelper.getTemplate(templateFile.getUuidName());
			template.process(codeModel, writer); 
			result = writer.toString();
		} catch (IOException | TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return result;
	}
	


	@Override
	public byte[] genCodeByZip(List<Long> tablemetaIds) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public String genSql(Long tablemetaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String genSql(List<Long> tablemetaIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void importTable(String tableName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void importTables(List<String> tableNames) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		System.out.println(StringUtils.uncapitalize("AaddEb"));
		
		System.out.println("org.coderfun.common".replaceAll("\\.", "/"));
	
		
		System.out.println(DateTools.formatDatetime(new Date()));
		System.out.println(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(new Date()));
		
		
		System.out.println("#{lenp}.java".contains("#{lenp}"));
		Set<String> importList = new LinkedHashSet<>();
		MyPrinter.printJson(importList);
		
		MyPrinter.printJson(new ArrayList<>());
	}


	
	
}
