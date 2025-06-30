FROM openjdk:18-jdk-slim
VOLUME /tmp
COPY target/produit-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]