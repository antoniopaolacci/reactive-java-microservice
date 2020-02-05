package com.quicktutorialz.nio.controllers;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/rest/")
public class SpringBootController {
	
	private static Logger log = LoggerFactory.getLogger(SpringBootController.class);
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView homepage() {

		log.info("SpringBootController - INIT homepage()");

			LinkedList<String> resultList = new LinkedList<String>();
			
			resultList.add("word");
			resultList.add("word 1");
			resultList.add("word 2");
			resultList.add("word 3");
		
		log.info("SpringBootController - END homepage()");

		return new ModelAndView("homepage", "outList", resultList);
	
	} //end method
	
} //end class


