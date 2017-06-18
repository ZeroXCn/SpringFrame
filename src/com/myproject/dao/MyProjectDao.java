package com.myproject.dao;

import java.util.List;
import java.util.Map;

import com.myproject.model.Project;

public interface MyProjectDao {
	Integer getProjectsCount();
	Project getProjectById(int id);
	List<Project> getProjectsJson(Map<String,Object> param);
	List<Project> getProjectsList(int offset,int limit);
	void addProject(Project obj);
}
