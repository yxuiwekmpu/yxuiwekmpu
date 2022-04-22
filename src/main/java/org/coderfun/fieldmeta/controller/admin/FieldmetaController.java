package org.coderfun.fieldmeta.controller.admin;



import java.util.List;

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
import org.coderfun.fieldmeta.entity.Fieldmeta;
import org.coderfun.fieldmeta.service.FieldmetaService;


@Controller("adminFieldmetaController")
@RequestMapping("/admin/action/fieldmeta")
public class FieldmetaController {
	@Autowired
	FieldmetaService fieldmetaService;
	
	@ResponseBody
	@RequestMapping("/add")
	public JsonData add(
			@ModelAttribute Fieldmeta fieldmeta){
		JsonData jsonData=new JsonData();
		fieldmetaService.save(fieldmeta);
		return jsonData;
	}
	
	
	@ResponseBody
	@RequestMapping("/edit")
	public JsonData edit(
			@ModelAttribute Fieldmeta fieldmeta){
		JsonData jsonData=new JsonData();
		fieldmetaService.update(fieldmeta);
		return jsonData;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public JsonData delete(
			@RequestParam Long id){
		JsonData jsonData=new JsonData();
		fieldmetaService.delete(id);
		return jsonData;
	}
	
	@ResponseBody
	@RequestMapping("/findpage")
	public EasyUIPage findpage(
			@ModelAttribute Fieldmeta fieldmeta,
			@RequestParam int page,
			@RequestParam int rows){
		Pageable pageable=new PageRequest(page<1?0:page-1, rows, new Sort(Direction.DESC,"id"));
		Page<Fieldmeta> pageData=fieldmetaService.findPage(fieldmeta, pageable);
		return new EasyUIPage(pageData);
	}
	
	@ResponseBody
	@RequestMapping("/findlist")
	public JsonData findlist(
			@ModelAttribute Fieldmeta fieldmeta){
		JsonData jsonData=new JsonData();
		List<Fieldmeta> listData=fieldmetaService.findList(fieldmeta, new Sort(Direction.DESC,"id"));
		return jsonData.setData(listData);
	}	
}
