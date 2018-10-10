package com.appsclub.controller;

import com.appsclub.model.OperatorPackApp;
import com.appsclub.repository.OperatorPackAppRepository;
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

/**
 * Realiza o tratamento do tráfego de requests para acesso a informações de pacotes de aplicativos de uma operadora
 */

@Controller
@JsonIgnoreProperties
public class OperatorPackAppController {
	
	private static final Logger logger = LoggerFactory.getLogger(OperatorPackAppController.class);

	@Autowired
    OperatorPackAppRepository operatorPackAppRepository;

	@RequestMapping(value = RestURIConstants.GET_ALL_PACK_APP, method = RequestMethod.GET)
	public @ResponseBody List<OperatorPackApp> getAllPackApps() {
		logger.info("Start getAllPackApps.");
		List<OperatorPackApp> results = operatorPackAppRepository.findAll();
		return results;
	}

	@RequestMapping(value = RestURIConstants.APP_GET_OP_PACK, method = RequestMethod.GET)
	public @ResponseBody List<OperatorPackApp> getAllAppsByOperatorAndPack(@PathVariable("operator") String operator, @PathVariable("pack") String pack) {
		logger.info("Start getAllApps by operator and pack name.");
		List<OperatorPackApp> results = operatorPackAppRepository.findByOperatorAndPack(operator, pack);
		return results;
	}

}
