package org.coderfun.fieldmeta.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.coderfun.fieldmeta.entity.Module;
import org.coderfun.fieldmeta.entity.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import klg.common.utils.MyBeanUtil;
import klg.common.utils.MyPrinter;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ModuleServicceTest {
	@Autowired
	ModuleService moduleService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EntityManager em;
	
	/**
	 * 没有带上version ， object references an unsaved transient instance
	 */
	@Test
	public void testSave(){
		Module module=new Module();
		module.setModuleName("test");
		module.setProject(MyBeanUtil.newAndSet(Project.class, "id", 2L));
		
		moduleService.save(module);
	}
	
	/**
	 * 带上version 保存成功
	 */
	
	@Test
	public void testSave1(){
		Module module=new Module();
		module.setModuleName("test");
		Project project=MyBeanUtil.newAndSet(Project.class, "id", 2L);
		 project.setVersion(projectService.getById(2L).getVersion());
		module.setProject(project);
		
		moduleService.save(module);
	}
	
	@Test
	@Transactional
	public void testRefresh1(){
		Module module=new Module();
		module.setModuleName("test2");
		module.setProject(projectService.getById(2L));
		em.refresh(module);
		MyPrinter.printJson(module);
	}
	
	@Test
	@Transactional
	public void testRefresh2(){
		Project project=MyBeanUtil.newAndSet(Project.class, "id", 2L);
		project.setVersion(1L);
		em.refresh(project);
		MyPrinter.printJson(project);
	}
	
}
