FROM openjdk:11-jre
WORKDIR /opt
COPY ./target/*.jar /opt/app.jar
COPY src/main/resources/application-docker.properties /opt/config/application.properties
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]