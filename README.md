# Running the application
- Please enter the correct credentials in twitter4j.properties file in twitter-to-kafka-service 
and enter your github password and url on bootstrap.yml file of config-server
- Then run mvn install -DskipTests command
- Then run docker-compose up command in docker-compose folder
- Check keycloak_authorization_server.yml file under docker-compose folder, which can be used to run keycloak on docker
- Run keycloak docker image and do configure it