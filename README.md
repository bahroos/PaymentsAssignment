# PaymentsAssignment
A simple angular app and a Java spring boot application for CRUD operations for managing your favorite receipes.

This consists of two parts
* The Angular 8 responsive app which is FavoriteReceipesManagerFE
* The spring boot Java application which is FavoriteReceipesManager

THe basic requirements to run this are:
* That you have minimum Java 8 (jdk) installed on your computer
* That you have maven 3.5 installed on your computer
* That you have node 11 installed on your computer.
* That you have the angular cli package npm installed

In order to build it here are the steps to follow:
* Clone the repoistory into your local computer
* Open two git bash terminals - one for the front end and one for backend
* In the first bash, change the directory to FavoriteReceipesManager, this is the Java application
* * Execute the command mvnw spring-boot:run => see that the spring boot application spins off
* In the second bash, change the directory to FavoriteReceipesManagerFE, this is the front end application
* * Execute the command npm i => see that this installs all the dependency nodel modules
* * Execute the command ng serve => see that the front end application spins off

In order to make sure it works, here are the steps to follow:
* Open a browser like chrome
* Go to http://localhost:4200/ => see that the application loads







