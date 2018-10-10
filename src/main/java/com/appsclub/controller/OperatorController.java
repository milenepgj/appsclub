package com.appsclub.controller;

import com.appsclub.model.Operator;
import com.appsclub.repository.OperatorRepository;
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
 * Realiza o tratamento do tráfego de requests para acesso a informações de operadoras
 */
@Controller
public class OperatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(OperatorController.class);

	@Autowired
	OperatorRepository operatorRepository;

	@RequestMapping(value = RestURIConstants.GET_OP_BY_NAME, method = RequestMethod.GET)
	public @ResponseBody Operator getOperator(@PathVariable("name") String name) {
		logger.info("Start getOperator. name="+name);

		Optional<Operator> Operator = operatorRepository.findByName(name);

		if (!Operator.isPresent())
			throw new RuntimeException("name-" + name);

		return Operator.get();
	}
	
	@RequestMapping(value = RestURIConstants.GET_ALL_OP, method = RequestMethod.GET)
	public @ResponseBody List<Operator> getAllOperators() {
		logger.info("Start getAllOperators.");
		List<Operator> results = operatorRepository.findAll();
		return results;
	}
	
}
