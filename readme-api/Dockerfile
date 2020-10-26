FROM openjdk:8-jdk-alpine as copy-files-step
RUN mkdir readme-api
COPY src readme-api/src
COPY pom.xml readme-api/pom.xml
COPY config readme-api/config


FROM maven:3.5-jdk-8-alpine as build-step
WORKDIR /app
COPY --from=copy-files-step /readme-api /app
RUN mvn install -DskipTests=true

FROM openjdk:8-jdk-alpine

COPY --from=build-step /app/target/readme-api.jar app.jar
COPY --from=build-step /app/config config
RUN apk update && apk add bash
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.config.location=file:/config/"]