FROM openjdk:8-jre-alpine
COPY target/spring-oauth-jwt-0.0.1-SNAPSHOT.jar /usr/src/myapp/spring-oauth-jwt.jar
WORKDIR /usr/src/myapp
CMD ["java","-jar","spring-oauth-jwt.jar"]