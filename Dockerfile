FROM openjdk:17-jdk-slim

WORKDIR /app

# faz Build e gera o jar
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn .mvn     

RUN ./mvnw clean package -DskipTests

COPY /target/creditos-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]