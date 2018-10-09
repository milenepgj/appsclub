package com.appsclub.controller;

import com.appsclub.model.PackApp;
import com.appsclub.repository.PackAppRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
 * Handles requests for the PackApp service.
 */
@Controller
public class PackAppController {
	
	private static final Logger logger = LoggerFactory.getLogger(PackAppController.class);

	@Autowired
	PackAppRepository packAppRepository;

	@RequestMapping(value = EmpRestURIConstants.GET_APP, method = RequestMethod.GET)
	public @ResponseBody PackApp getPackApp(@PathVariable("id") Integer id) {
		logger.info("Start getPackApp. ID="+id);

		Optional<PackApp> PackApp = packAppRepository.findById(id);

		if (!PackApp.isPresent())
			throw new RuntimeException("id-" + id);

		return PackApp.get();
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_APP, method = RequestMethod.GET)
	public @ResponseBody List<PackApp> getAllPackApps() {
		logger.info("Start getAllPackApps.");
		List<PackApp> results = packAppRepository.findAll();
		return results;
	}
	
}
