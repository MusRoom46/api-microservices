FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/eureka-server.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]