FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/spring-mysql-demo-3.2.1.jar spring-mysql-demo-3.2.1.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "spring-mysql-demo-3.2.1.jar" ]