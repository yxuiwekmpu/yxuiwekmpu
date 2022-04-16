package org.coderfun.fieldmeta.service;

import static org.junit.Assert.fail;

import org.coderfun.fieldmeta.entity.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest{
	@Autowired
	ProjectService projectService;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void save(){
		Project project=new Project();
		project.setName("test");
		projectService.save(project);
	}
	
	
}
