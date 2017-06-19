package com.myproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.model.Project;
import com.myproject.service.IProjectService;

//@RequestMapping("/next") //指定下级
@Controller
public class ProjectController {
	@Resource
    private IProjectService projectService;
 
    @RequestMapping("/getcount.do")
    public @ResponseBody String getProjectsCount() {
    	return projectService.getProjectsCount().toString();
    }
    
    @RequestMapping("/getbyid.do")
    public @ResponseBody String getProjectById(int id) {
        Project project = this.projectService.getProjectById(id);
        return project.toString();
    }
    
    @RequestMapping("/getjson.do")
    public @ResponseBody String getProjectsJson(HttpServletRequest request) {
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("sort", request.getParameter("sort"));
    	map.put("order", request.getParameter("order"));
    	map.put("offset", request.getParameter("offset"));
    	map.put("limit", request.getParameter("limit"));
    	
    	List<Project> list = projectService.getProjectsJson(map);
        return list.toString();
    }
    
    @RequestMapping("/getlist.do")
    public @ResponseBody String getProjectsList(@RequestParam(value="offset", required=true) int offset,@RequestParam(value="limit", required=true) int limit) {
    	List<Project> list = projectService.getProjectsList(offset,limit);
        return list.toString();
    }
    
    @RequestMapping("/add.do")
    public @ResponseBody String addProject(@RequestBody Project obj) {
        projectService.addProject(obj);
        
        return "index.html";//直接跳转回首页
    }
}
