FROM adoptopenjdk/openjdk11:latest
COPY ./target/parking-1.0-SNAPSHOT.jar /home/ubuntu/

#default Jarname 
ARG jarname=parking-1.0-SNAPSHOT.jar
ENV JAR_NAME=$jarname

#default profile name
ARG profile=testh2db
ENV PROFILE=$profile

#default mysql url
ARG mysql_url=jdbc:mysql://23.22.164.0:3306/final
ENV MYSQL_URL=$mysql_url


#default mysql username
ARG mysql_user_name=parking
ENV MYSQL_USER_NAME=$mysql_user_name

#default mysql password
ARG mysql_password=newpassword
ENV MYSQL_PASSWORD=$mysql_password

#Working dirctory
WORKDIR /home/ubuntu/


CMD ["sh","-c","java -jar $JAR_NAME  --spring.profiles.active=$PROFILE --spring.datasource.url=$MYSQL_URL --spring.datasource.username=$MYSQL_USER_NAME  --spring.datasource.password=$MYSQL_PASSWORD"]
