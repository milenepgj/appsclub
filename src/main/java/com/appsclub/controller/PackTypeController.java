package com.appsclub.controller;

import com.appsclub.model.PackType;
import com.appsclub.repository.PackTypeRepository;
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
 * Handles requests for the PackType service.
 */
@Controller
public class PackTypeController {
	
	private static final Logger logger = LoggerFactory.getLogger(PackTypeController.class);

	@Autowired
	PackTypeRepository packTypeRepository;

	@RequestMapping(value = EmpRestURIConstants.GET_APP, method = RequestMethod.GET)
	public @ResponseBody PackType getPackType(@PathVariable("id") Integer id) {
		logger.info("Start getPackType. ID="+id);

		Optional<PackType> PackType = packTypeRepository.findById(id);

		if (!PackType.isPresent())
			throw new RuntimeException("id-" + id);

		return PackType.get();
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_APP, method = RequestMethod.GET)
	public @ResponseBody List<PackType> getAllPackTypes() {
		logger.info("Start getAllPackTypes.");
		List<PackType> results = packTypeRepository.findAll();
		return results;
	}
	
}
