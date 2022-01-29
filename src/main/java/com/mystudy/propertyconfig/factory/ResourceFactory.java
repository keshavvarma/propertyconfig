package com.mystudy.propertyconfig.factory;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

import org.apache.naming.ResourceRef;

/**
 * The java class ResourceFactory
 * 
 * @author Keshav Varma
 * @version 1.0
 */
public class ResourceFactory implements ObjectFactory {

	/**
	   * This method is used to get the object instance.
	   * 
	   * @param obj
	   * @param name
	   * @param nameCtx
	   * @param environment
	   * @return Object
	   * @throws Exception
	   */
	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)
			throws NamingException {
		try {
			if (obj instanceof ResourceRef) {
				Reference ref = (Reference) obj;
				Enumeration<RefAddr> e = ref.getAll();
				Properties retProperties = new Properties();
				while (e.hasMoreElements()) {
					RefAddr ra = e.nextElement();
					String propName = ra.getType();
					String value = (String) ra.getContent();
					retProperties.put(propName, value);
				}
				return retProperties;
			} else {
				return null;
			}
		} catch (Exception ie) {
			NamingException ne = new NamingException(ie.getMessage());
			ne.setRootCause(ie);
			throw ne;
		}
	}
}
