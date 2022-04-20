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
import org.coderfun.fieldmeta.entity.Tablemeta;
import org.coderfun.fieldmeta.service.TablemetaService;


@Controller("adminTablemetaController")
@RequestMapping("/admin/tablemeta")
public class TablemetaController {
	@Autowired
	TablemetaService tablemetaService;
	
	@ResponseBody
	@RequestMapping("/add")
	public JsonData add(
			@ModelAttribute Tablemeta tablemeta){
		JsonData jsonData=new JsonData();
		tablemetaService.save(tablemeta);
		return jsonData;
	}
	
	
	@ResponseBody
	@RequestMapping("/edit")
	public JsonData edit(
			@ModelAttribute Tablemeta tablemeta){
		JsonData jsonData=new JsonData();
		tablemetaService.update(tablemeta);
		return jsonData;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public JsonData delete(
			@RequestParam Long id){
		JsonData jsonData=new JsonData();
		tablemetaService.delete(id);
		return jsonData;
	}
	
	@ResponseBody
	@RequestMapping("/findpage")
	public EasyUIPage findpage(
			@ModelAttribute Tablemeta tablemeta,
			@RequestParam int page,
			@RequestParam int rows){
		Pageable pageable=new PageRequest(page<1?0:page-1, rows, new Sort(Direction.DESC,"id"));
		Page<Tablemeta> pageData=tablemetaService.findPage(tablemeta, pageable);
		return new EasyUIPage(pageData);
	}
	
	@ResponseBody
	@RequestMapping("/findlist")
	public JsonData findlist(
			@ModelAttribute Tablemeta tablemeta){
		JsonData jsonData=new JsonData();
		List<Tablemeta> listData=tablemetaService.findList(tablemeta, new Sort(Direction.DESC,"id"));
		return jsonData.setData(listData);
	}	
}