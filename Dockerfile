FROM adoptopenjdk/openjdk11:latest
COPY ./target/parking-1.0-SNAPSHOT.jar /home/admin-pc/

WORKDIR /home/admin-pc/

RUN sh -c 'touch parking-1.0-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","parking-1.0-SNAPSHOT.jar"]
