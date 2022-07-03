Testing framework for PetStore API
----

#####Necessary Set-Up
1) Java 14 or higher
2) maven version 3.5.2 or higher
3) Ensure that maven has access to central maven repo or
check that your artifactory contains all necessary artifacts


#####Short framework description 
Simple testing framework for API testing 
- Main architecture framework is Spring  - used to provide DI and inversion of control
- Java test framework is junit5
- Framework for actual rest requests - restTemplate.
At such small projects will be much faster to choose restAssure or Retrofit, but RestTemplate was choosen
cause much more suitable for customisation.
- Reporting - Allure
- Syntax sugar - Lombok
- YAML - as endpoints storage
- Project builder - Maven
- Couple of custom things were implemented
    1) Custom engine for work with yaml thought the Spring 
    2) Custom Allure attachments collection for REST requests and responses. 
    Aspects (AspectJ) and Spring RestTemplate Interceptor were used for
 
 #####Short tests description 
- Tests were chose based on decision-making process and tests check list described in CRIT_TESTS.md

#####How to run and collect report
 - to run test - execute at terminal _mvn clean install allure:report_
 - to open Allure report - find it at APITest/target/site/allure-maven-plugin/index.html and open at eny browser 