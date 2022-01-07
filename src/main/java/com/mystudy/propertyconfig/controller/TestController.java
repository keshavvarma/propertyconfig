package com.mystudy.propertyconfig.controller;

import javax.naming.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/")
public class TestController {

	@GetMapping(path = "greeting", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE
			)
	public String greetings() throws NamingException {
		
		Context context = new InitialContext();
		Context envContext = (Context) context.lookup("java:/comp/env");
		String endpoint = (String) envContext.lookup("endpoint");
		System.out.println("endpint:" + endpoint);
		
		return "Greetings";
	}
	
}
