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
 * Handles requests for the Operator service.
 */
@Controller
public class OperatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(OperatorController.class);

	@Autowired
	OperatorRepository operatorRepository;

	@RequestMapping(value = EmpRestURIConstants.GET_OP, method = RequestMethod.GET)
	public @ResponseBody Operator getOperator(@PathVariable("id") Integer id) {
		logger.info("Start getOperator. ID="+id);

		Optional<Operator> Operator = operatorRepository.findById(id);

		if (!Operator.isPresent())
			throw new RuntimeException("id-" + id);

		return Operator.get();
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_OP, method = RequestMethod.GET)
	public @ResponseBody List<Operator> getAllOperators() {
		logger.info("Start getAllOperators.");
		List<Operator> results = operatorRepository.findAll();
		return results;
	}
	
}
