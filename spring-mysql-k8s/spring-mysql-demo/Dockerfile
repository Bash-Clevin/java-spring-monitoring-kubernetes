FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/spring-mysql-demo-3.2.1.jar /app

EXPOSE 8080

CMD [ "java", "-jar", 'spring-mysql-demo-3.2.1.jar' ]