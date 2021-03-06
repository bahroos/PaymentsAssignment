# PaymentsAssignment

## Scope and Purpose
A simple angular app and a Java spring boot application for CRUD operations for managing your favorite receipes.

This consists of two parts
* The Angular 8 responsive app which is FavoriteReceipesManagerFE
* The spring boot Java application which is FavoriteReceipesManager

## Installation requirements
The basic requirements to run this are:
* That you have minimum Java 8 (jdk) installed on your computer
* That you have maven 3.5 installed on your computer
* That you have node 11 installed on your computer.
* That you have the angular cli package npm installed
* Clone the repository into your local computer

## Build instructions
* Open two git bash terminals - one for the front end and one for backend
* In the first bash, change the directory to FavoriteReceipesManager, this is the Java application
* * Execute the command mvnw spring-boot:run => see that the spring boot application spins off
* In the second bash, change the directory to FavoriteReceipesManagerFE, this is the front end application
* * Execute the command npm i => see that this installs all the dependency nodel modules
* * Execute the command ng serve => see that the front end application spins off

## Verify the working application
In order to make sure it works, here are the steps to follow:
* Open a browser like chrome
* Go to http://localhost:4200/ => see that the application loads

## Design considerations
1. Annotation based Spring boot is used for the Web service creation.
2. A in memory H2 embedded database is added to be able to perform the CRUD operations.
3. The Web Layer is Unit testing using Spring’s MockMvc
4. Integration tests are added to check the end to end response flows









