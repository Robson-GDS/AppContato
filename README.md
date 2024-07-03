# AppContato é uma alternativa para administrar os contatos de uma pessoa,  O objetivo deste projeto é proporcionar uma interface simples e intuitiva para adicionar, visualizar, editar e excluir contatos, armazenando as informações de forma eficiente e segura..

# Ferramentas

* Java 21
* Spring Boot (Versão 3.2.7)
* Swagger
* PostgreSQL
* H2 database
* JWT - JSON Web Token

# Instalação e uso

### Clone Repository
```
$ git clone https://github.com/Robson-GDS/AppContato.git

```
### Navegue até resources/application-dev.properties e altere a url, username e senha do seu banco de dados postgres
```
spring.datasource.url=jdbc:postgresql://localhost:5432/nomeDoBanco
spring.datasource.username=postgres
spring.datasource.password=******
```

# Documentação da API

### Após iniciar a aplicação, a documentação do Swagger estará disponível no seguinte endereço:
```
http://localhost:8080/swagger-ui/index.html
```
