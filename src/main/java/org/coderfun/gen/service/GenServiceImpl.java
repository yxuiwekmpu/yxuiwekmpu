package org.coderfun.gen.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import klg.common.utils.MyPrinter;
import klg.j2ee.query.jpa.expr.AExpr;

@Service
public class GenServiceImpl implements GenService {

	private static final Logger logger = LoggerFactory.getLogger(GenService.class);
	
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
	
	@Value("${fieldmeta.hibernate.dialect}")
	String hibernateDialect;

	public CodeModel init(Tablemeta tablemeta) {
		// TODO Auto-generated method stub

		CodeModel codeModel = new CodeModel();
		codeModel.setTablemeta(tablemeta);
		codeModel.setEntityNameOfAllLowcase(StringUtils.uncapitalize(tablemeta.getEntityName()));
		codeModel.setEntityNameOfFirstLowcase(tablemeta.getEntityName().toLowerCase());
		codeModel.setNowTime(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(new Date()));
		codeModel.setModule(moduleService.getOne(AExpr.eq(Module_.moduleName, tablemeta.getModuleName())));

		String entitySuperClassFullName = DictReader.getCodeItem(tablemeta.getEntitySuperClass(),SystemCode.ClassCode.ENTITY_SUPER_CLASS).getValue();
		codeModel.setEntitySuperClassFullName(entitySuperClassFullName);
		
		Sort efSort = new Sort(Direction.ASC, "columnSort");
		List<EntityField> entityFields = entityFieldService.findList(efSort, AExpr.eq(EntityField_.tableName, tablemeta.getTableName()));
		List<EntityField> baseEntityFields = entityFieldService.findList(efSort, AExpr.eq(EntityField_.tableName, entitySuperClassFullName));
		
		Sort pfSort = new Sort(Direction.ASC, "entityField.columnSort");
		List<PageField> pageFields = pageFieldService.findList(pfSort, AExpr.eq(PageField_.tableName, tablemeta.getTableName()));
		List<PageField> basePageFields = pageFieldService.findList(pfSort, AExpr.eq(PageField_.tableName, entitySuperClassFullName));
		
		codeModel.setEntityFields(entityFields);
		codeModel.setBaseEntityFields(baseEntityFields);
		codeModel.setPageFields(pageFields);
		codeModel.setBasePageFields(basePageFields);
		
		genEntityImportList(codeModel);
		
		lookUpValidation(codeModel);
		lookUpPkColumn(codeModel);
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
			
			//gen file dir pattern	
			String packagePath = codeModel.getModule().getPackageName().replace(".", "/");
			String dir = templateFile.getGenFiledirPattern().replace(MOD_PKG_PATH, packagePath);
			dir = dir.replace(MOD_NAME,codeModel.getModule().getModuleName());
			genCodeFile.setDir(dir);

			
			if(!genCodeFile.getDir().endsWith("/")){
				genCodeFile.setDir(genCodeFile.getDir() + "/");;
			}
			
			//gen file name pattern
			String name = templateFile.getGenFilekeyPattern().replace(ENP, codeModel.getTablemeta().getEntityName());
			name = name.replace(LFENP, codeModel.getEntityNameOfFirstLowcase());
			genCodeFile.setName(name);
			
			genCodeFile.setContent(processTemplate(templateFile, codeModel));
			
			genCodeFiles.add(genCodeFile);
			logger.info("{}<==={}",codeModel.getTablemeta().getTableName( ), genCodeFile.getDir() +genCodeFile.getName());
		}
		
		return genCodeFiles;
	}
	
	
	private static String processTemplate(TemplateFile templateFile, Object codeModel) {
		StringWriter writer = new StringWriter();
		String result = null;
		try {
			Template template = FreemarkerHelper.getTemplate(templateFile.getDir() + templateFile.getName());
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
	public byte[] genCodeByZip(List<Long> tablemetaIds) throws IOException {
		// TODO Auto-generated method stub
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for(Long tablemetaId : tablemetaIds ){
        	List<GenCodeFile> genCodeFiles = genCodeFiles(tablemetaId);
        	for(GenCodeFile genCodeFile : genCodeFiles){
        		String filePath = genCodeFile.getDir() +genCodeFile.getName();
        		if(filePath.startsWith("/")){
        			filePath = filePath.substring(1);
        		}
        		
        		zip.putNextEntry(new ZipEntry(filePath));
                IOUtils.write(genCodeFile.getContent(), zip, "utf-8");
                zip.closeEntry();
        	}
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		System.out.println("aaa".replaceAll(LFENP, "bb"));
		System.out.println("aaa".replace(LFENP, "bb"));
		System.out.println("aaa[LENP]".replace(ENP, "XXX"));
		System.out.println("org.coderfun.common".replace(".", "/"));
		System.out.println("/src/main/java/[MOD_PKG_PATH]/entity/".replace(MOD_PKG_PATH, "org.coderfun.common".replace(".", "/")));
		
//		System.out.println("[lenp].java".contains("[lenp]"));
//		System.out.println("[lenp].java".replace("[lenp]", "BBB"));
//		Object obj = Class.forName("org.coderfun.fieldmeta.entity.Validation").newInstance();
//		MyPrinter.printJson(obj.getClass());
//		
//		System.out.println("/asa".startsWith("/"));
//		System.out.println("/asa".substring(1));
	}
	
}
