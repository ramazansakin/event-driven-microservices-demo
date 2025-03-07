# Running the application
- Please enter the correct credentials in twitter4j.properties file in twitter-to-kafka-service 
and enter your github password and url on bootstrap.yml file of config-server
- Then run mvn install -DskipTests command
- Then run docker-compose up command in docker-compose folder
- Check pom.xml of elastic-query-service, where we added build-image goal to spring-boot-maven-plugin
- Check services.yml in docker-compose folder, which is updated for elastic-query-service docker image