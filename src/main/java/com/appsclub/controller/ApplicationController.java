package com.appsclub.controller;

import com.appsclub.model.Application;
import com.appsclub.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Handles requests for the Application service.
 */
@Controller
public class ApplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	ApplicationRepository appRepository;

	@RequestMapping(value = RestURIConstants.GET_APP, method = RequestMethod.GET)
	public @ResponseBody Application getApplication(@PathVariable("id") int id) {
		logger.info("Start getApplication. ID="+id);

		Optional<Application> application = appRepository.findById(id);

		if (!application.isPresent())
			throw new RuntimeException("id-" + id);

		return application.get();
	}
	
	@RequestMapping(value = RestURIConstants.GET_ALL_APP, method = RequestMethod.GET)
	public @ResponseBody List<Application> getAllApplications() {
		logger.info("Start getAllApplications.");
		List<Application> results = appRepository.findAll();
		return results;
	}

	@RequestMapping(value = RestURIConstants.GET_ALL_APP_BY_COUNTRY, method = RequestMethod.GET)
	public @ResponseBody List<Application> getAllApplicationsByCountry(@PathVariable("country") String country) {
		logger.info("Start getAllApplicationsByCountry by country.");
		List<Application> results = appRepository.findByCountry(country);
		return results;
	}

	
}
