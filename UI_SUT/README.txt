-Instructions to run UI-SUT exercice (Windows):

1. Clone project in a folder
2. You must download Apache Maven 3.5.2 and Java SDK 1.8. Set the enviorment paths before running the project. 
For Maven, add the route of the Maven folder downloaded to "PATH" in Enviorement Variables. example: C:\apache-maven-3.5.2-bin\apache-maven-3.5.2\bin
For Java SDK, create a new variable under Envriorement Variables called "JAVA_HOME" with the route of your SDK. example: C:\Program Files\Java\jdk1.8.0_25
3. Locate yourself under the root of the project: \UI_SUT
4. Open the CMD in the root of the folder (SHIFT+RIGH CLICK)
5. Run the command "mvn clean install" to run the project.

Dependencies used:
-TestNG 6.13.1
-Selenium 3.8.1
-log4j 2.10

Maven 3.5 

Note: If build fails, check logs. There is a Test Case that is coded to fail.

Test Criteria:

For these testCases, Functional testing was used in order to assure the functionality of the site end to end. 
