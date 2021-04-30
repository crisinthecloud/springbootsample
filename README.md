# springbootsample

This is a sample project for Spring Boot application.
Is a one-week of spare time project... not a production one.

Shows:
- how to create microservices with DB access in Spring Boot.
- The REST api (currently only the CRUD list and create)
- JPA and Spirng DAta repositories example
- REST communication from one service to another
- Easy tool menu for development/testing


Frontend
========

Simple frontend in AngularJS
Integrated in srv-client module.
REST testing with a menu thas uses groovy scripts in the background.


Backend
=======

Mouules
-model. one model shared by all services. To use a relationa DB with JPA
there we can use submodels for each functional area, with related entities 
or one sinble model with all entities in it.
-dao Modules  to stores JPA/Spring data stuff, like repositries
-util. Modules to stores utilities and common clases like annotations, enumerated values, utilities clases, etc.
-services. One module for ecah service.

Prequisites
===========

- Java JDK 1.8 
- Maven 3.6
- Groovy (for testing use cases)
- NodeJs, to use fronted served with NodeJs

Conventions
===========
Most service classes have prefix or suffixes to easy Java coding in the IDE, enabling fast import of the class 
avoiding  name duplication. But these can not be always achieved.


The development menu.bat
========================
The menu.bat script accelerates the development cycle..  It is a pseudo command line for launching tasts.
The most important ones are:
-install   calls mvn clean install
-launch    starts three services
-cu        launch a groovy based tool to test the REsT API based on use cases
-cuh       shows the list of use cases.

The project can be compiled as usual, mvn clean install -DskipTEsts
To run the application, execute launch from the menu. For linux user, the comands 
are analogous to windows ones.

To test the application, open http://localhost:9091  for serve with srv-client,
or http://localhost:7777 if served with node,.

The user interface is very simple, only for text some REST methods and show 
results in a easy way.

Database
========
The project uses an in-memory database for each service. 
Referencial integrity then is maintained by the services,
not the database. Then they are true Microservices, but this 
aproach often is not useful for criktical applications. 




