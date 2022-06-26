package org.coderfun.fieldmeta.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.coderfun.gen.service.GenCodeFile;
import org.coderfun.gen.service.GenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import klg.j2ee.common.model.JsonData;

@Controller("adminGenController")
@RequestMapping("/admin/action/gen")
public class GenController {
	
	@Autowired
	GenService genService;

	
	@RequestMapping("/genCodeByZip")
	public void genCodeByZip(
			@RequestParam(value = "tablemetaIds") List<Long> tablemetaIds,
			HttpServletResponse response) throws IOException{
		
		byte[] data = genService.genCodeByZip(tablemetaIds);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"fieldmeta-gen.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());        
        //默认不需要关闭
		//response.getOutputStream().close();
	}
	
	@ResponseBody
	@RequestMapping("/genCodeFiles")
	public JsonData genCodeFiles(Long tablemetaId){
		List<GenCodeFile> genCodeFiles = genService.genCodeFiles(tablemetaId);
		System.out.println(genCodeFiles.get(0).getContent());
		return JsonData.success(genCodeFiles);
	}
	
	
}
