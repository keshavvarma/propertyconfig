package com.mystudy.propertyconfig;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mystudy.propertyconfig.factory.PropertyListener;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean(name = "MyProperties")
	public Properties loadProperty() throws Exception {
		PropertyListener propertyListener = new PropertyListener();
		return propertyListener.getProperties();
	}

}
