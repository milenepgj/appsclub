package com.appsclub.controller;

import com.appsclub.model.Application;
import com.appsclub.model.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Handles requests for the Application service.
 */
@Controller
public class ApplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	//Map to store Applications, ideally we should use database
	Map<Integer, Application> empData = new HashMap<Integer, Application>();
	
	@RequestMapping(value = EmpRestURIConstants.DUMMY_APP, method = RequestMethod.GET)
	public @ResponseBody Application getDummyApplication() {
		logger.info("Start getDummyApplication");
		Application emp = new Application();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		empData.put(9999, emp);
		return emp;
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_APP, method = RequestMethod.GET)
	public @ResponseBody Application getApplication(@PathVariable("id") int empId) {
		logger.info("Start getApplication. ID="+empId);
		
		return empData.get(empId);
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_APP, method = RequestMethod.GET)
	public @ResponseBody List<Application> getAllApplications() {
		logger.info("Start getAllApplications.");
		List<Application> emps = new ArrayList<Application>();
		Set<Integer> empIdKeys = empData.keySet();
		for(Integer i : empIdKeys){
			emps.add(empData.get(i));
		}
		return emps;
	}
	
	@RequestMapping(value = EmpRestURIConstants.CREATE_APP, method = RequestMethod.POST)
	public @ResponseBody Application createApplication(@RequestBody Application emp) {
		logger.info("Start createApplication.");
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;
	}
	
	@RequestMapping(value = EmpRestURIConstants.DELETE_APP, method = RequestMethod.PUT)
	public @ResponseBody Application deleteApplication(@PathVariable("id") int empId) {
		logger.info("Start deleteApplication.");
		Application emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
	
}
