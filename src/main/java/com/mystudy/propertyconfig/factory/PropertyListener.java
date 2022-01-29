/**
 * 
 */
package com.mystudy.propertyconfig.factory;

import java.util.Properties;

import org.springframework.jndi.JndiTemplate;

/**
 * @author Keshav Varma
 *
 */
public class PropertyListener {
	
	private final String PROPERTY_RESOURCE = "java:comp/env/core/DemoResource";

	Properties properties = null;

	public Properties getProperties() throws Exception {
		if (this.properties == null) {
			init();
		}
		return this.properties;
	}
	
	public void init() throws Exception {
		JndiTemplate jndiTemplate = null;
		jndiTemplate = new JndiTemplate();
		try {
			properties = (Properties) jndiTemplate.lookup(PROPERTY_RESOURCE);
			System.out.println("proprties read done");
		} catch (Exception e) {
			System.out.println("proprties reading exception");
			System.out.println(e);
		}
		if (this.properties == null) {
			throw new Exception("Properties not found execption");
		}
	}
	
	

}
