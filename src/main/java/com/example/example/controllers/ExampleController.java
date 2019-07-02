package com.example.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("examples")
public class ExampleController {

	private Logger logger = LoggerFactory.getLogger(ExampleController.class);
	
	
	@RequestMapping(method=RequestMethod.GET,value="secure")
	public ExampleResponse get(Authentication authentication) {
		logger.info("Subject: {}",authentication.getName());
		Jwt jwt = (Jwt)authentication.getPrincipal();
		
		jwt.getClaims().forEach((k,v)-> {
			logger.info("Claim : {} -> {}", k, v);
		});
		return ExampleResponse.buildRandom();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="open")
	public ExampleResponse open() {
		return ExampleResponse.buildRandom();
	}
	
}
