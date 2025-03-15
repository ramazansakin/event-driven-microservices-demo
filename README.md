# Running the application
- Please enter the correct credentials in twitter4j.properties file in twitter-to-kafka-service 
and enter your github password and url on bootstrap.yml file of config-server
- Then run mvn install -DskipTests command
- Then run docker-compose up command in docker-compose folder
- Check services.yml in docker-compose folder, where we added new instances for gateway and config server 
for high availability and set log file name through config to prevent conflict with multiple instances of same service