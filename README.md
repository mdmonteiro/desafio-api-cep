# Java SpringBoot Application - Desafio CEP Santander

## Descrição

Esta é uma aplicação Java desenvolvida com SpringBoot e Maven, utilizando Java 17. A aplicação faz uso de um banco de dados PostgreSQL e está conteinerizada com Docker. Um mock também está incluído na infraestrutura para fins de simulação ou testes.

## Requisitos

Para executar este projeto, certifique-se de ter os seguintes itens instalados:

- **Java 17**
- **Maven**
- **Docker**
- **Docker Compose**

## Configuração

1. Clone este repositório:

   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd <NOME_DO_DIRETORIO>
   ```

2. Certifique-se de que as configurações no `application.properties` estão corretas. O arquivo deve conter as configurações necessárias para conexão com o banco de dados e outros recursos.

## Estrutura Docker

- O **`Dockerfile`** define a imagem da aplicação Java SpringBoot.
- O **`docker-compose.yml`** define os serviços:
  - **App**: A aplicação Java.
  - **Banco de Dados**: PostgreSQL.
  - **Mock**: Um serviço simulado para testes ou integração.

## Como Executar

1. **Construa a aplicação Java com Maven**:

   ```bash
   mvn clean install
   ```

   Isso gerará o arquivo `.jar` na pasta `target`.

2. **Inicie os contêineres com Docker Compose**:

   ```bash
   docker-compose up --build
   ```

   Este comando irá:

   - Construir a imagem da aplicação.
   - Iniciar os contêineres definidos no `docker-compose.yml`.

3. **Acesse a aplicação**:

   A aplicação estará disponível em:

   ```
   http://localhost:<PORTA>
   ```

   Substitua `<PORTA>` pela porta configurada no `application.properties` ou no `docker-compose.yml`.

4. **Verifique os logs** (opcional):

   Para monitorar os logs da aplicação, execute:

   ```bash
   docker logs -f <NOME_DO_CONTAINER>
   ```

## Comandos Adicionais

- **Parar todos os contêineres**:

  ```bash
  docker-compose down
  ```

- **Limpar volumes e redes**:

  ```bash
  docker-compose down --volumes --remove-orphans
  ```

## Observações

- Certifique-se de que as portas definidas no `docker-compose.yml` estão disponíveis no host.
- Altere as variáveis de ambiente e credenciais do banco de dados conforme necessário.
- Consulte a documentação do SpringBoot para ajustes específicos no projeto.

## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo:

1. Crie um fork do repositório.

2. Crie um branch para sua feature ou correção:

   ```bash
   git checkout -b minha-feature
   ```

3. Envie suas alterações:

   ```bash
   git commit -m "Descrição das alterações"
   git push origin minha-feature
   ```

4. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

