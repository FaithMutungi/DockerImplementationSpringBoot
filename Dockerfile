FROM openjdk:21-jdk

COPY target/Docker-Impl-0.0.1-SNAPSHOT.jar app-1.0.0.jar

ENTRYPOINT ["java", "-jar", "app-1.0.0.jar"]

