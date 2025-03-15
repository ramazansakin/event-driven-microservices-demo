# Running the application
- Please enter the correct credentials in twitter4j.properties file in twitter-to-kafka-service 
and enter your github password and url on bootstrap.yml file of config-server
- Then run mvn install -DskipTests command
- Then run docker-compose up command in docker-compose folder
- Check new sleuth and zipkin dependencies, new trace and span id variables in logback-common.xml file,
zipkin.yml file where zipkin docker images defined, and services.yml file changes where spring cloud sleuth 
properties configured to send trace/span data to zipkin