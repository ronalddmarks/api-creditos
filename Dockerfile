FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo jar gerado para dentro do container
COPY target/creditos-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que o Spring Boot vai rodar
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]