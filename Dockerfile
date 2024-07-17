FROM openjdk:17-jdk-slim

EXPOSE 8080

ADD build/libs/justgo-server-0.0.1-SNAPSHOT.jar justgo-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","justgo-server-0.0.1-SNAPSHOT.jar"]