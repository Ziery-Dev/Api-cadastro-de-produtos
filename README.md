# API RESTful para Cadastro de Produtos

API RESTful para cadastro de produtos, construída com **Spring Boot**, **JPA** e **MySQL**. A API inclui operações básicas de CRUD e segue uma arquitetura em camadas. Cada camada desempenha um papel específico:

## Estrutura do Projeto

- **Modelo (ProductModel)**: Mapeia a entidade `Product` no banco de dados.
- **Repositório (ProductRepository)**: Gerencia operações CRUD com o banco de dados.
- **Serviço (ProductService)**: Contém a lógica de negócios e gerencia o fluxo de dados.
- **Controlador (ProductController)**: Exponibiliza a API REST e define as rotas HTTP.
- **DTO (ProductRecordDto)**: Realiza validações de entrada para dados de produto.

## Principais Funcionalidades

- **UUID**: Utilizado como ID para garantir unicidade dos registros de produtos.
- **Validações**: Validação aplicada nos campos do DTO para manter a consistência dos dados.
- **Conversão entre DTO e Model**: Uso do `BeanUtils` para facilitar a conversão de `ProductRecordDto` para `ProductModel`.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para simplificar o desenvolvimento de APIs RESTful.
- **JPA/Hibernate**: Facilita o mapeamento de objetos Java para o banco de dados.
- **MySQL**: Banco de dados relacional utilizado para armazenamento persistente dos dados.

## Endpoints da API

| Método | Endpoint         | Descrição                         |
|--------|-------------------|-----------------------------------|
| POST   | `/products`      | Criação de um novo produto       |
| GET    | `/products`      | Listagem de todos os produtos    |
| GET    | `/products/{id}` | Consulta de um produto específico|
| PUT    | `/products/{id}` | Atualização de um produto        |
| DELETE | `/products/{id}` | Exclusão de um produto           |

A API REST permite operações CRUD completas para o gerenciamento de produtos, com respostas personalizadas e status HTTP adequados para cada situação.

---
