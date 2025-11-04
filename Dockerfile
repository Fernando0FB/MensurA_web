# Etapa de build (Maven + JDK 21)
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copie o pom primeiro para cachear dependências
COPY pom.xml .
RUN mvn -B -q -DskipTests dependency:go-offline

# Agora o código
COPY src ./src
RUN mvn -B -DskipTests package

# Etapa de runtime (JRE 21 enxuta)
FROM eclipse-temurin:21-jre
WORKDIR /app
EXPOSE 8080

# Ajuste o nome do jar conforme o seu artifactId/version
COPY --from=build /app/target/web-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]