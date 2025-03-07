# Running the application
- Please enter the correct credentials in twitter4j.properties file in twitter-to-kafka-service 
and enter your github password and url on bootstrap.yml file of config-server
- Then run mvn install -DskipTests command
- Then run docker-compose up command in docker-compose folder
- Check elastic-query-service, where we changed response model and add assembler package to enable hateoas, then
updated service component to use hateoas enabled assembler to be able to add hateoas links to response