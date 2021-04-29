# springbootsample

This is a sample project for Spring Boot application

Shows:
- how to create microservices with DB access.
- The REST api (currently only the CRUD list and create)
- JPA and Spirng DAta repositories example
- REST communication from one service to another
- Easy tool menu for development/testing





Frontend
========

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
-cuh       shows the use cases.




