package com.appsclub.controller;

import com.appsclub.model.Application;
import com.appsclub.model.PackApp;
import com.appsclub.model.PackType;
import com.appsclub.repository.PackAppRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


@Controller
@JsonIgnoreProperties
public class ApplicationPacksController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationPacksController.class);

	@Autowired
	PackAppRepository packAppRepository;

	@RequestMapping(value = RestURIConstants.GET_PACK_APP_ID, method = RequestMethod.GET)
	public @ResponseBody PackApp getPackApp(@PathVariable("id") Integer id) {
		logger.info("Start getPackApp. ID="+id);

		Optional<PackApp> PackApp = packAppRepository.findById(id);

		if (!PackApp.isPresent())
			throw new RuntimeException("id-" + id);

		return PackApp.get();
	}

	@RequestMapping(value = RestURIConstants.GET_ALL_PACK_APP, method = RequestMethod.GET)
	public @ResponseBody List<PackApp> getAllPackApps() {
		logger.info("Start getAllPackApps.");
		List<PackApp> results = packAppRepository.findAll();
		return results;
	}

	@RequestMapping(value = RestURIConstants.APP_GET_OP_PACK, method = RequestMethod.GET)
	public @ResponseBody List<PackApp> getAllAppsByOperatorAndPack(@PathVariable("operator") String operator, @PathVariable("pack") String pack) {
		logger.info("Start getAllApps by operator and pack name.");
		List<PackApp> results = packAppRepository.findByOperatorAndPack(operator, pack);
		return results;
	}


	@RequestMapping(value = RestURIConstants.APP_GET_BY_COUNTRY, method = RequestMethod.GET)
	public @ResponseBody List<PackApp> getAllApplicationsPacksByCountry(@PathVariable("country") String country) {
		logger.info("Start getAllApplicationsPacksByCountry by country.");
		List<PackApp> results = packAppRepository.findByCountry(country);
		return results;
	}

    @RequestMapping(value = RestURIConstants.GET_ALL_PACK_TYPE_BY_COUNTRY_PACKNAME, method = RequestMethod.GET)
    public @ResponseBody List<PackApp> getAllPackTypesByCountryPackname(@PathVariable("country") String country,
                                                                         @PathVariable("packname") String packName) {
        logger.info("Start getAllPackTypesByCountryPackname where country = " + country + " and packname = " + packName);
        List<PackApp> results = packAppRepository.findByCountryAndPackName(country, packName);
        return results;
    }
}
