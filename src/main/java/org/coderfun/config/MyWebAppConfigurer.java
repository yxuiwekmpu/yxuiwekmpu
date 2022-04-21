package org.coderfun.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer 
        extends WebMvcConfigurerAdapter {

	Logger logger=LoggerFactory.getLogger(MyWebAppConfigurer.class);
	
	@Value("${web.res}")
	private String webRes;
		
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
    	
    	logger.info("static resource mapping [{}] -> [{}]", "/res**","file:"+webRes);
        registry.addResourceHandler("/res/**").addResourceLocations("file:"+webRes);        
        super.addResourceHandlers(registry);
    }

}