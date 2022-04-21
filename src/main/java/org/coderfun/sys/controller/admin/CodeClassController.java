package org.coderfun.sys.controller.admin;



import java.util.List;

import org.coderfun.sys.entity.CodeClass;
import org.coderfun.sys.entity.CodeClass_;
import org.coderfun.sys.service.CodeClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import klg.j2ee.common.model.EasyUIPage;
import klg.j2ee.common.model.JsonData;
import klg.j2ee.common.model.JsonData.Type;
import klg.j2ee.query.jpa.expr.AExpr;


@Controller("adminCodeClassController")
@RequestMapping("/admin/action/codeclass")
public class CodeClassController {
	@Autowired
	CodeClassService codeClassService;
	
	@ResponseBody
	@RequestMapping("/add")
	public JsonData add(
			@ModelAttribute CodeClass codeClass){
		JsonData jsonData=new JsonData();
		if(codeClassService.getOne(AExpr.eq(CodeClass_.code,codeClass.getCode()))==null)
			codeClassService.save(codeClass);
		else
			jsonData.setType(Type.error).setMessage("重复的代码！");
		return jsonData;
	}
	
	
	@ResponseBody
	@RequestMapping("/edit")
	public JsonData edit(
			@ModelAttribute CodeClass codeClass){
		JsonData jsonData=new JsonData();
		codeClassService.update(codeClass);
		return jsonData;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public JsonData delete(
			@RequestParam Long id){
		JsonData jsonData=new JsonData();
		codeClassService.delete(id);
		return jsonData;
	}
	
	@ResponseBody
	@RequestMapping("/findpage")
	public EasyUIPage findpage(
			@ModelAttribute CodeClass codeClass,
			@RequestParam int page,
			@RequestParam int rows){
		Pageable pageable=new PageRequest(page<1?0:page-1, rows, new Sort(Direction.DESC,"id"));
		Page<CodeClass> pageData=codeClassService.findPage(codeClass, pageable);
		return new EasyUIPage(pageData);
	}
	
	@ResponseBody
	@RequestMapping("/findlist")
	public JsonData findlist(
			@ModelAttribute CodeClass codeClass){
		JsonData jsonData=new JsonData();
		List<CodeClass> listData=codeClassService.findList(codeClass, new Sort(Direction.DESC,"id"));
		return jsonData.setData(listData);
	}	
	@ResponseBody
	@RequestMapping("/datalist")
	public List datalist(
			@ModelAttribute CodeClass codeClass){
		List<CodeClass> listData=codeClassService.findList(codeClass, new Sort(Direction.DESC,"id"));
		return listData;
	}	
}
