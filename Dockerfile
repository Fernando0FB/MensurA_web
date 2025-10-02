FROM ubuntu:latest as BUILD

RUN apt-get update
RUN apt-get install temurin-21-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean package


FROM eclipse-temurin:21-jdk-alpine

EXPOSE 8080

COPY --from=build /target/web-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]