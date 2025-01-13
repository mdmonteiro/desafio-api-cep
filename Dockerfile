# Etapa 1: Construir a aplicação
FROM maven:3.8.3-openjdk-17 AS builder

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml e as dependências para o cache
COPY pom.xml .
COPY src ./src

# Instala as dependências e compila a aplicação
RUN mvn clean package -DskipTests

# Etapa 2: Executar a aplicação
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho para o runtime
WORKDIR /app

# Copia o arquivo JAR gerado na etapa de build
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta 8080 (porta padrão do Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]