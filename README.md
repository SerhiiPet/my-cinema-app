# my-cinema-app
## Project description:
A simple web application for a cinema, the main purpose of which is to compile a program of showing movies and sell tickets.
The program is written in Java, so it will work stably on any platform Windows, Linux or Mac. The program is written according to the principles of SOLID.

This project has administrator and user roles.
To get user rights, you need to register, for this you need to specify your email address and password (the password must contain at least 8 characters and must be duplicated).

Unique administrator rights:
- add movie theaters, movies, movie sessions;
- edit and delete movie-sessions by id;
- receive users by their email.

Unique user rights:
- add movies to shopping carts;
- get shopping carts;
- issue and receive orders.

## Features:
1. Implemented concepts of dependency injection (DI), inversion of control (IoC), MVC and DTO;
2. Configured DB authentication;
3. Realized role entity;
4. Configured role access to specific resources for `ADMIN` and for `USER`: 
- POST: /register - all
- GET: /cinema-halls - user/admin
- POST: /cinema-halls - admin
- GET: /movies - user/admin
- POST: /movies - admin
- GET: /movie-sessions/available - user/admin
- POST: /movie-sessions - admin
- PUT: /movie-sessions/{id} - admin
- DELETE: /movie-sessions/{id} - admin
- GET: /orders - user
- POST: /orders/complete - user
- PUT: /shopping-carts/movie-sessions - user
- GET: /shopping-carts/by-user - user
- GET: /users/by-email - admin

## Project structure:
- Config - program configuration;
- Controller - processing user requests and calling server services;
- DAO - data access layer;
- DTO - data transfer objects;
- Model - models of the application;
- service - application logic layer. 

## User technologies and libraries:
- Java 11;
- Git;
- MySQL;
- Hibernate;
- Spring (Core, Web, Security); 
- Apache Log4j-core;
- Checkstyle plugin.
 
## Steps to run the program on your computer:
- create a project fork in your repository;
- clone the project locally;
- create a separate branch;
- configure and run Tomcat version 9.0.50

## Database UML diagram:
![pic](Spring_cinema.png)