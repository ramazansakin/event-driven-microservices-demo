# Running the application
- Please enter the correct credentials in twitter4j.properties file in twitter-to-kafka-service 
and enter your github password and url on bootstrap.yml file of config-server
- Then run mvn install -DskipTests command
- Then run docker-compose up command in docker-compose folder
- Check discovery-service, where we created discovery registration and discovery service
- Also check all microservices which are updated to become a discovery client using EnableDiscoveryClient annotation