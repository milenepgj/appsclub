package com.appsclub.controller;

import com.appsclub.model.OperatorPackApp;
import com.appsclub.model.PackApp;
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
 * Realiza o tratamento do tráfego de requests para acesso a informações de pacotes de aplicativos
 */

@Controller
public class PackTypeController {
	
	private static final Logger logger = LoggerFactory.getLogger(PackTypeController.class);

	@Autowired
	PackTypeRepository packTypeRepository;

	@RequestMapping(value = RestURIConstants.GET_PACK_TYPE_APP_NAME, method = RequestMethod.GET)
	public @ResponseBody PackType getPackType(@PathVariable("name") String name) {
		logger.info("Start getPackType. Name ="+name);

		Optional<PackType> PackType = packTypeRepository.findByName(name);

		if (!PackType.isPresent())
			throw new RuntimeException("name -" + name);

		return PackType.get();
	}
	
	@RequestMapping(value = RestURIConstants.GET_ALL_PACK_TYPE_APP, method = RequestMethod.GET)
	public @ResponseBody List<PackType> getAllPackTypes() {
		logger.info("Start getAllPackTypes.");
		List<PackType> results = packTypeRepository.findAll();
		return results;
	}

	@RequestMapping(value = RestURIConstants.GET_ALL_PACK_TYPE_BY_COUNTRY_PACKNAME, method = RequestMethod.GET)
	public @ResponseBody List<PackType> getAllPackTypesByCountryPackname(@PathVariable("country") String country,
																				@PathVariable("packname") String packName) {
		logger.info("Start getAllPackTypesByCountryPackname where country = " + country + " and packname = " + packName);
		List<PackType> results = packTypeRepository.findByCountryAndPackName(country, packName);
		return results;
	}

}
