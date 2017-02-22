wicket-spring-hibernate
=======================

A dumb application based on the wicket archetype using wicket spring injection, spring transaction management, hibernate5, hibernate OGM.

## configuration
 - [SpringListener](src/main/java/org/example/app/SpringListener.java): a web listener configured to create a spring context using org.example.app.Context as it's configuration
 - [ExampleFilter](src/main/java/org/example/app/ExampleFilter.java): a web filter that extends wicket filter, configured to use org.example.app.WicketApplication as the application class
 - [Context](src/main/java/org/example/app/Context.java):
   - loads application.properties from the classpath as a property source
   - creates transaction manager
   - enables spring transaction management
 - [WicketApplication](src/main/java/org/example/app/WicketApplication.java): sets homepage and adds a component instantiation listener that can do spring injection into wicket components
 - [HomePage](src/main/java/org/example/HomePage.java): uses SpringBean annotation to wire in bean from the spring context
 - [Service](src/main/java/org/example/Service.java): @Transactional annotations on methods to open and close transactions on entry/exit

## extra dependencies
 - wicket-spring
 - spring-web
 - spring-orm
 - hibernate-core
 - servlet-api
 - hibernate-ogm-infinispan (we pull in the ogm bom and use that to provide versions for hibernate deps)
 - narayana-jta

## running it
`mvn jetty:run` will start it on port 8080
