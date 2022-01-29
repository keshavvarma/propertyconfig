package com.mystudy.propertyconfig.controller;

import javax.naming.NamingException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@GetMapping(path = "/", produces = {MediaType.TEXT_HTML_VALUE})
	public String greetings() throws NamingException {
		StringBuilder s = new StringBuilder();
		s.append("<html>");
		s.append("<body>");
		s.append("<h1>Application started.</h1>");
		s.append("<br> <a href='v1/property'>Click to see all proprties</a>");
		s.append("</body>");
		s.append("</html>");
		return s.toString();
	}
	
}
