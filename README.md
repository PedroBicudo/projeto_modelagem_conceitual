<div align="center">
    <h2>Sistema de pagamento</h2>
    <p>Projeto desenvolvido no curso de modelagem UML.</p>
</div>

### Gerando o jar
```shell
mvn clean package
```
### Executando o projeto
```shell
cd target
java -jar projeto_modelagem_conceitual-0.0.1-SNAPSHOT.jar 
```

### Executando o projeto com Docker
```shell
docker build -t projeto .

# O PROFILE=dev inicia a API com dados pré populados
docker run --rm -d -p 8080:8080 -e PROFILE=dev --name projeto projeto
```

### Documentação
[Postman](https://www.postman.com/pedrobicudo/workspace/estudo-de-caso-uml)

### Desafio pessoal
- Desenvolver o projeto aplicando TDD.

### Tecnologias usadas
- Java
- Spring Boot, Spring Web, Spring Data JPA, Spring Validation
- Spring Test, JUnit5 e Mockito
- Postman
- H2
- lombok
