package com.myproject.dao;

import org.apache.ibatis.annotations.Param; 

import java.util.List;
import java.util.Map;

import com.myproject.model.Project;

public interface MyProjectDao {
	Integer getProjectsCount();
	Project getProjectById(int id);
	List<Project> getProjectsJson(Map<String,Object> param);
	List<Project> getProjectsList(@Param("offset") int offset,@Param("limit") int limit);
	void addProject(Project obj);
}
