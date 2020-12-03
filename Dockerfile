FROM gradle:4.2.1-jdk8-alpine

USER root
RUN chown -R gradle ./
USER gradle
RUN gradle wrapper
RUN ./gradlew build --stacktrace
COPY build/libs/hack-be-0.0.1-SNAPSHOT.jar demo-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo-docker.jar"]