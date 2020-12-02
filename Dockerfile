FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY build/libs/hack-be-0.0.1-SNAPSHOT.jar app/demo-docker.jar
ENTRYPOINT ["java","-jar","app/demo-docker.jar"]