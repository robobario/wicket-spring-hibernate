wicket-spring-hibernate
=======================

A dumb application based on the wicket archetype using wicket spring injection, spring transaction management, hibernate5.

Configuration :
  * web.xml - spring ContextLoaderListener to load application context on container load, uses contextConfigLocation
  * web.xml - spring OpenSessionInViewFilter opens a hibernate session for each request
  * applicationContext.xml - configures a property placeholder configurer using application.properties
  * applicationContext.xml - configures sessionFactory using package scan to find annotated entities
  * applicationContext.xml - enables spring transaction management by annotations
  * WicketApplication.java - on initialise registers SpringComponentInjector
  
