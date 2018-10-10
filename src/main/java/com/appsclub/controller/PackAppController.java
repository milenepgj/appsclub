package com.appsclub.controller;

import com.appsclub.model.PackApp;
import com.appsclub.model.PackType;
import com.appsclub.repository.PackAppRepository;
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
 * Realiza o tratamento do tráfego de requests para acesso a informações de pacotes de aplicativos
 */

@Controller
public class PackAppController {
	
	private static final Logger logger = LoggerFactory.getLogger(PackAppController.class);

	@Autowired
	PackAppRepository packAppRepository;

	@RequestMapping(value = RestURIConstants.GET_PACKAPP_NAME, method = RequestMethod.GET)
	public @ResponseBody List<PackApp> getPackApp(@PathVariable("name") String name) {
		logger.info("Start getPackType. Name ="+name);

		List<PackApp> packApps = packAppRepository.findByName(name);

		return packApps;
	}
	
	@RequestMapping(value = RestURIConstants.GET_ALL_PACKAPP, method = RequestMethod.GET)
	public @ResponseBody List<PackApp> getAllPackApps() {
		logger.info("Start getAllPackTypes.");
		List<PackApp> results = packAppRepository.findAll();
		return results;
	}

	@RequestMapping(value = RestURIConstants.GET_ALL_PACKAPP_BY_COUNTRY, method = RequestMethod.GET)
	public @ResponseBody List<PackApp> getAllPackAppsByCountryPackname(@PathVariable("country") String country) {
		logger.info("Start getAllPackTypesByCountry where country = " + country);
		List<PackApp> results = packAppRepository.findByCountry(country);
		return results;
	}

}
