## Introduce

This is an application level project. This project is a web project based on *Java language* and *mysql*. This system uses the *springboot framework*, which has built-in Tomcat server. You only need to run the main program to start the project. If you need to configure some parameters of tomcat, you can configure them in *application.yml* in the template directory.The project uses *mybatis plus* as the framework of database control layer.

## Build

Install Java and MySQL first!

If you just want to run the project, you can directly use the jar package that I have packed and run *Java - jar laji-0.0.1-snapshot.jar* on the terminal.

Don't forget to deploy the database. The database backup required by the project is in the *laji.sql* file. You can import it in your own *mysql*.

## Category Guide

> /src/main/java/com/huni/config  configuration

> /src/main/java/com/huni/controller Controller

> /src/main/java/com/huni/handler Handler 

> /src/main/java/com/huni/service Specific service code of business processing

> /src/main/java/com/huni/interceptor Interceptor  for Access management

> /src/main/java/com/huni/mapper Mapper for Mybatis plus

> /src/main/java/com/huni/pojo Entity classes

> /src/main/java/com/huni/util  Tools

> /src/main/java/com/vo View Object

> /src/main/resource/static Static resources such as images and CSS files

> /src/main/resource/templates Template of web front end

## Other

If access to the database is forbidden, please make sure that your database is running in the background and the database password is correct. You can configure the database address and password in **application.yml* in the template directory.