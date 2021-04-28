# springbootsample

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

Conventions
Most service classes have prefix or suffixes to easy Java coding in the IDE, enabling fast import of the class 
avoiding  name duplication. But these can not be always achieved.

