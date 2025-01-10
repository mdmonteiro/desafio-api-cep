# Usar uma imagem base do Java
FROM openjdk:17-jdk-slim

# Criar um diretório para a aplicação
WORKDIR /app

# Copiar o arquivo JAR gerado para dentro do container
COPY target/cepservice-0.0.1-SNAPSHOT.jar app.jar

# Definir a porta que será exposta
EXPOSE 8080

# Definir o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]