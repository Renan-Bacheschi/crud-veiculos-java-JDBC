# CRUD de Veículos – Java

Este projeto foi desenvolvido como parte de um desafio técnico para uma vaga de estágio.
O objetivo foi demonstrar conhecimentos em Java puro,
manipulação de banco de dados via JDBC
e organização de arquitetura sem o uso de frameworks complexos.

## Funcionalidades
- Cadastro de veículos
- Listagem de veículos
- Busca por marca
- Atualização de dados
- Remoção de registros

## Tecnologias
- Java 17+
- JDBC (SQL manual)
- MySQL
- Maven
- Git e GitHub

## Arquitetura
- Model
- DAO
- ConnectionFactory

Sem uso de JPA, Hibernate ou frameworks de persistência.

## Banco de Dados

```sql
CREATE TABLE veiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(100),
    modelo VARCHAR(100),
    ano INT,
    preco DECIMAL(10,2)
);
```

