package org.coderfun.gen.service;

import java.io.File;
import java.io.IOException;

import org.coderfun.config.WebRes;
import org.coderfun.fieldmeta.service.TemplateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;


@Component
public class FreemarkerHelper{
	
	private static Configuration configuration;
	
	public FreemarkerHelper(@Autowired WebRes webRes){
		try {
			configuration = buildConfiguration(webRes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Configuration buildConfiguration(WebRes webRes) throws IOException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setDirectoryForTemplateLoading(new File(webRes.getAbsolutePath() + TemplateFileService.TEMPLATE_DIR_KEY));
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
		return cfg;
	}
	
	public static Template getTemplate(String name){
		try {
			return configuration.getTemplate(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
