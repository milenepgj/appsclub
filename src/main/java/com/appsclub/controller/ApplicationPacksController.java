package com.appsclub.controller;

import com.appsclub.model.*;
import com.appsclub.repository.AppPackRepository;
import com.appsclub.repository.EmployeeRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import java.util.*;

/**
 * Handles requests for the Application service.
 */
@Controller
@JsonIgnoreProperties
public class ApplicationPacksController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationPacksController.class);

	@Autowired
	AppPackRepository appPackRepository;

	@RequestMapping(value = EmpRestURIConstants.APPPACK_GET_OP_PACK, method = RequestMethod.GET)
	public @ResponseBody List<PackApp> getAllAppsByOperatorAndPack(@PathVariable("operator") String operator, @PathVariable("pack") String pack) {
		logger.info("Start getAllEmployees.");
		List<PackApp> results = appPackRepository.findByOperatorAndPack(operator, pack);
		return results;

/*		List<Tuple> results = appPackRepository.findByOperatorAndPack(operator, pack);

		for (Tuple t : results)
		{
			List<TupleElement<?>> cols = t.getElements();
			Application app = new Application();
			PackApp packApp = new PackApp();
			Operator op = new Operator();
			PackType packType = new PackType();

			for (TupleElement col : cols)
			{


				String colName = col.getAlias();
				if (colName.equals("appid"))


			}
		}*/

	}
	
}
