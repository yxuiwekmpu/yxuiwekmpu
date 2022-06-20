package org.coderfun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebRouter {
	
	@Value("${fieldmeta.template}")
	String template = "";
	
	/**
	 * 首页
	 * @param model
	 * @return
	 */
    @RequestMapping("/index") 
    public String GoToIndex(Model model){ 
    	model.addAttribute("template", template);
        return "index"; 
    }
}
