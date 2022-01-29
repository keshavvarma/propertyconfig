package com.mystudy.propertyconfig.controller;

import java.util.Properties;

import javax.naming.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class TestController {
	
	@Autowired
	@Qualifier(value = "MyProperties")
	Properties properties;

	@GetMapping(path = "greeting", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE
			)
	public String greetings() throws NamingException {
		System.out.println("server.type:" + properties.getProperty("server.type"));
		
		return "Greetings";
	}
	
	@GetMapping(path = "property")
	public String getAllProperties() throws NamingException {
		return properties.toString();
	}
	
	
	
}
