package org.coderfun.sys.controller.admin;



import java.util.List;

import org.coderfun.sys.entity.CodeItem;
import org.coderfun.sys.entity.CodeItem_;
import org.coderfun.sys.service.CodeItemService;
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


@Controller("adminCodeItemController")
@RequestMapping("/admin/action/codeitem")
public class CodeItemController {
	@Autowired
	CodeItemService codeItemService;
	
	@ResponseBody
	@RequestMapping("/add")
	public JsonData add(
			@ModelAttribute CodeItem codeItem){
		JsonData jsonData=new JsonData();
		if(codeItemService.getOne(AExpr.eq(CodeItem_.classCode, codeItem.getClassCode()),AExpr.eq(CodeItem_.code, codeItem.getCode()))==null)
			codeItemService.save(codeItem);
		else
			jsonData.setType(Type.error).setMessage("重复的代码！");
		return jsonData;
	}
	
	
	@ResponseBody
	@RequestMapping("/edit")
	public JsonData edit(
			@ModelAttribute CodeItem codeItem){
		JsonData jsonData=new JsonData();
		codeItemService.update(codeItem);
		return jsonData;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public JsonData delete(
			@RequestParam Long id){
		JsonData jsonData=new JsonData();
		codeItemService.delete(id);
		return jsonData;
	}
	
	@ResponseBody
	@RequestMapping("/findpage")
	public EasyUIPage findpage(
			@ModelAttribute CodeItem codeItem,
			@RequestParam int page,
			@RequestParam int rows){
		Pageable pageable=new PageRequest(page<1?0:page-1, rows, new Sort(Direction.DESC,"id"));
		Page<CodeItem> pageData=codeItemService.findPage(codeItem, pageable);
		return new EasyUIPage(pageData);
	}
	
	@ResponseBody
	@RequestMapping("/findlist")
	public JsonData findlist(
			@ModelAttribute CodeItem codeItem){
		JsonData jsonData=new JsonData();
		List<CodeItem> listData=codeItemService.findList(codeItem, new Sort(Direction.DESC,"id"));
		return jsonData.setData(listData);
	}
	
	@ResponseBody
	@RequestMapping("/datalist")
	public List datalist(
			@ModelAttribute CodeItem codeItem){
		List<CodeItem> listData=codeItemService.findList(codeItem, new Sort(Direction.DESC,"ordernum"));
		return listData;
	}
}
