package org.coderfun.gen.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbcp.BasicDataSource;
import org.coderfun.fieldmeta.entity.Project;
import org.coderfun.fieldmeta.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgs.db.meta.core.MetaLoader;
import com.cgs.db.meta.core.MetaLoaderImpl;

public class DbImportServiceImpl implements DbImportService {
	@Autowired
	ProjectService projectService;

	@Override
	public Set<String> getTableNames() {
		// TODO Auto-generated method stub
		BasicDataSource dataSource = getDataSource();
		MetaLoader metaLoader = new MetaLoaderImpl(dataSource);
		Set<String> tableNames = metaLoader.getTableNames();
		try {
			dataSource.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableNames;
	}

	private BasicDataSource getDataSource() {
		Project defaultProject = projectService.getDefaultProject();
		BasicDataSource datasource = new BasicDataSource();
		datasource.setUrl(defaultProject.getDbUrl());
		datasource.setUsername(defaultProject.getDbUsername());
		datasource.setPassword(defaultProject.getDbPassword());
		datasource.setInitialSize(1);
		datasource.setMaxActive(1);

		return datasource;
	}

	@Override
	public void importTable(String tableName, DbImportTableOption option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void importTables(List<String> tableNames, DbImportTableOption option) {
		// TODO Auto-generated method stub

	}

}
