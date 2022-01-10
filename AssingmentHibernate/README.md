# JavaRNDTraining

1.      Establish connection between Java application and database using hibernate configuration.

2.      Create the following database tables using hibernate (hibernate should generate the tables in database).

3.      Design appropriate View using JSP and Controller using Servlet.

 

COUNTRY_TABLE

LANGUAGE_TABLE

CITY_TABLE

SPORT_TABLE

COUNTRY_ID (pk)

LANGUAGE_ID (pk)

CITY_ID(pk)

SPORT_ID(pk)

COUNTRY_NAME

LANGUAGE_NAME

CITY_NAME

SPORT_NAME

LANGUAGE

CAPITAL

 

 Constraints:

1.      pk stands for primary key where ever defined in table design

2.      LANGUAGE in COUNTRY_TABLE is a foreign key to LANGUAGE_TABLE

3.      CAP ITAL in COUNTRY_TABLE is a foreign key to CITY_TABLE

 

Requirements:

1.      Country can play multiple sports.

2.      Sport can be played by multiple country.

3.      Country can have only 1 language.

4.      Language can be spoken my multiple countries.

5.      Country can have only 1 capital city.

6.      City can be a capital of only 1 country.

7.      If I fetch an object of country then I should be able to fetch its language, capital city and sports played in the country.

8.       If I fetch the object of language then I should be able to fetch the set of countries where it is spoken.

 

Note:-

 

1.      Follow proper project structure.

2.      Use different package for Domain, DAO, Service classes.

3.      Use Proper Naming convention.

4.      Use proper collection for implementing DAO

5.      User Singleton design pattern for obtaining db connection

6.      Apply property files for loading driver information, url etc.

7.      Proper use of HQL queries and  Criteria.

8.      Apply the inheritance model with “Table per class hierarchy model, “Table per subclass model” or “Table per concrete class model” appropriate to your project needs.

9.      Apply second level cache

10.  Appropriate fetch should be apply.