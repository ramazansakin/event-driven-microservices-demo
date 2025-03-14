# Running the application
- Please enter the correct credentials in twitter4j.properties file in twitter-to-kafka-service 
and enter your github password and url on bootstrap.yml file of config-server
- Then run mvn install -DskipTests command
- Then run docker-compose up command in docker-compose folder
- Check configuration file of services where we added monitoring
- Check docker-compose folder, where we added monitoring.yml file to add prometheus and grafana docker containers