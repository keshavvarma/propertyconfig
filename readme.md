# Overview
This project describes how to use tomcat level Resource/properties in java using spring JNDI.


# Configuration
## Create server specific resource .xml file

1.  Create ApplicationName.xml file with resource content under Tomcat/serverVersion dir
	
	Please refer Tomcat dir
2.  File name should be same as application name
3. For production version .xml you can add real values on tomcat level, in application, provide dummy data

## Configure .xml file on tomcat

	Copy ApplicationName.xml to tomcat/conf/CATALINA/localhost/ of your tomcat
	
## Java code configuration

1. Create Factory class to bind the context from tomcat to application.
2. factory="com.mystudy.propertyconfig.factory.ResourceFactory" - This is the path of factory class of the project, if the path is wrong then context will not bind.
3. name="core/DemoResource" - Resource name to lookup
4. Refer com.mystudy.propertyconfig.factory.ResourceFactory for factory class.
5. Refer com.mystudy.propertyconfig.factory.PropertyListner for how to load resource/proeprty
6. Created bean of properties com.mystudy.propertyconfig.Application.class, this is optional we can also crate object using new keyword.

## Resource configuration in IDE for development

	Add all <Resource> tags under context.xml of IDE's tomcat if tomcat/conf/CATALINA/localhost/ is not present.
	Do not copy <context> tag in context.xml it already contains it.


