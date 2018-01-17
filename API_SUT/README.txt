-Instructions to run API-SUT exercice (Windows):

1. Clone project in a folder
2. You must download Apache Maven 3.5.2 and Java SDK 1.8. Set the enviorment paths before running the project. 
For Maven, add the route of the Maven folder downloaded to "PATH" in Enviorement Variables. example: C:\apache-maven-3.5.2-bin\apache-maven-3.5.2\bin
For Java SDK, create a new variable under Envriorement Variables called "JAVA_HOME" with the route of your SDK. example: C:\Program Files\Java\jdk1.8.0_25
3. Locate yourself under the root of the project: \API_SUT
4. Open the CMD in the root of the folder (SHIFT+RIGH CLICK)
5. Run the command "mvn clean install" to run the project.

Dependencies used:
-TestNG 6.13.1
-REST Assured 3.0.6
-HAMCREST 1.3
-JAYWAY schema Validator 2.9.0
-log4j 2.10

Maven 3.5 


Test Criteria:

For these testCases, Unit testing was used in order to test the endpoint by modules. 
