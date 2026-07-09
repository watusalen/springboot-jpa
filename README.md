# springboot-jpa (course)

API REST desenvolvida como parte da **Seção 22 - Bônus: Projeto web services com Spring Boot e JPA/Hibernate** do curso do **Nélio Alves**.

A ideia aqui foi sair do básico e montar uma aplicação de verdade, com domínio modelado em camadas, persistência com JPA/Hibernate, tratamento de erros e uma estrutura que já dá para entender como base de um backend. O SpringBoot é uma ferramenta muito diferente do que qualquer outra tecnologia que eu já tinha lidado antes (e é poderosa).

## Visão Geral

Este projeto simula um sistema de comércio eletrônico fcitício, com usuários, pedidos, produtos, categorias e itens de pedido. O foco é mostrar como essas peças se conectam e expor os endpoints.

A solução segue uma arquitetura em camadas:

- `resources`: camada de entrada da API, responsável pelos endpoints REST
- `services`: regras de negócio e orquestração das operações
- `repositories`: acesso a dados com Spring Data JPA
- `entities`: modelo de domínio e mapeamento ORM
- `resources.exceptions`: tratamento padronizado de erros da API

Na prática, a aplicação cobre o ciclo completo de uma API REST: recebe a requisição, trata a regra de negócio, conversa com o banco e devolve a resposta no formato correto.

## Conceitos Trabalhados

Este módulo trabalha, de forma aplicada, os seguintes conceitos:

- construção de APIs REST com Spring Boot
- verbos HTTP e status codes
- persistência com JPA e Hibernate
- relacionamentos entre entidades
- associação muitos-para-muitos, um-para-muitos e chave composta
- uso de `@EmbeddedId` em entidade de associação
- inicialização de base de dados com perfil de teste
- injeção de dependência
- tratamento de exceções personalizadas
- serialização JSON e controle de navegação entre objetos
- organização do código em camadas

## Modelo de Domínio

O domínio foi montado para representar o fluxo principal de uma loja online:

- `User`
- `Order`
- `OrderItem`
- `Product`
- `Category`
- `Payment`
- `OrderStatus`

### Relacionamentos principais

- um usuário pode possuir vários pedidos
- um pedido pertence a um usuário
- um pedido possui vários itens
- um item de pedido referencia um pedido e um produto
- um produto pode pertencer a várias categorias
- uma categoria pode possuir vários produtos
- um pedido pode ter um pagamento associado

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- H2 Database
- PostgreSQL
- Maven

## Endpoints Disponíveis

### Usuários

- `GET /users`
- `GET /users/{id}`
- `POST /users`
- `PUT /users/{id}`
- `DELETE /users/{id}`

### Categorias

- `GET /categories`
- `GET /categories/{id}`

### Produtos

- `GET /products`
- `GET /products/{id}`

### Pedidos

- `GET /orders`
- `GET /orders/{id}`

### Itens de pedido

- `GET /orderitems`
- `GET /orderitems/{id}`

## Configuração de Ambiente

O projeto roda localmente com H2 em memória no perfil de teste. Para o ambiente online, o banco está hospedado no Neon e a aplicação foi publicada no Railway.

Arquivo principal de configuração:

- `src/main/resources/application.properties`

Configuração do perfil de teste:

- `src/main/resources/application-test.properties`

### Console H2

Quando a aplicação estiver em execução, o console do H2 fica disponível em:

`http://localhost:8080/h2-console`

Para acesso, utilize:

- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `sa`
- Password: vazio

## Ambiente Online

Também existe uma versão publicada da aplicação, conectada ao banco no Neon e hospedada no Railway. 

ps: Se ela estiver offline é porque passaram muito tempo sem fazer requisições!

Acesso da aplicação:

`https://springboot-jpa-production.up.railway.app/`

Nesse ambiente, a API segue o mesmo contrato da versão local, mas usa a infraestrutura de produção para persistência e deploy.

## Como Executar

### Pré-requisitos

- Java 21 ou superior
- Maven instalado, ou uso do wrapper `mvnw`

### Execução local

```bash
./mvnw spring-boot:run
```

### Acesso aos endpoints

Após subir a aplicação, a API estará disponível em:

`http://localhost:8080`

Exemplo:

```bash
GET http://localhost:8080/users
```

### Versão publicada

Se você quiser testar a versão online, use a URL abaixo:

`https://springboot-jpa-production.up.railway.app/`

## Estrutura do Projeto

```text
src/main/java/com/matusalenalves/course
├── config
├── entities
├── repositories
├── resources
├── resources/exceptions
├── services
└── services/exceptions
```

## Tratamento de Erros

A API utiliza exceções personalizadas para deixar as respostas mais consistentes e previsíveis.

- `ResourceNotFoundException`
- `DataBaseException`

Essas exceções são convertidas em respostas HTTP padronizadas por um handler global, o que ajuda bastante na leitura do erro tanto no navegador quanto no Postman.

## Observações

Este projeto foi feito como estudo guiado, baseado nas aulas do professor Nélio Alves. Ele mostra como organizar uma API backend com Spring, como pensar o domínio e como ligar tudo isso a um banco relacional.

O código acompanha a evolução dos tópicos do curso, então alguns endpoints e detalhes do domínio refletem diretamente a construção didática do material.