## API REST Spring Boot - E-commerce ##

Este projeto é uma API RESTful desenvolvida com Java 17 e Spring Boot 3, focada na gestão de um sistema simples de e-commerce. A aplicação gere utilizadores, produtos, categorias, encomendas e cupões de desconto, utilizando autenticação via JWT (JSON Web Token).

**🛠️ Tecnologias Utilizadas:**

- Java 17
- Spring Boot 3.5.6
- Spring Security (Autenticação e Autorização)
- JWT (JSON Web Token) (Segurança stateless)
- Spring Data JPA (Persistência de dados)
- H2 Database (Base de dados em memória para desenvolvimento/testes)

## 🚀 Como Executar ##

**Pré-requisitos:**

- Java JDK 17+ instalado
- Maven instalado (ou utilize o wrapper ./mvnw incluído)

**Passos:**

1. Clone o repositório e inicie a pasta do projeto.
2. Compile o projeto e descarregue as dependências:

```
Bash:

./mvnw clean install
```

3. Execute a aplicação:

```
Bash:

./mvnw spring-boot:run
```
A API estará disponível em http://localhost:8080.

**📚 Documentação da API (Swagger):**

A documentação interativa dos endpoints está disponível através do Swagger UI. Após iniciar a aplicação, aceda a:

*👉 http://localhost:8080/swagger-ui/index.html*

JSON da especificação: /v3/api-docs

**🔐 Acesso e Autenticação:**

A API é protegida por JWT. Para aceder à maioria dos endpoints, é necessário autenticar-se e obter um token.

Utilizador Administrador Padrão
O sistema cria automaticamente um utilizador administrador na inicialização se este não existir:

- E-mail: admin@example.com
- Senha: 123456

Utilize este utilizador no endpoint /api/login para obter o token Bearer inicial.

Fluxo de Autenticação: 
Faça um pedido POST para /api/login com as credenciais.
Receba o token na resposta.

Permissões: ADMIN gere todos, utilizadores comuns gerem os seus próprios dados.

**🏷️ Categorias (/api/categorias):**

- Organização de produtos.
- Apenas administradores podem criar, editar ou excluir categorias.

**📦 Produtos (/api/produtos):**

- Gestão de catálogo e stock.
- Vinculados a uma categoria obrigatória.

**🛒 Encomendas (/api/pedidos):**

- Criação e acompanhamento de compras.
- Vincula cliente, lista de produtos e cupão opcional.

**🎟️ Cupões (/api/cupons):**

- Sistema de descontos com validação de data, valor mínimo e estado ativo.

**🧪 Testes:**

- O projeto inclui testes unitários e de integração para Controllers e Services. Para executá-los:

```
Bash:

./mvnw test
```

**🗄️ Base de Dados (H2 Console):**

Para aceder à base de dados em memória durante o desenvolvimento:

Aceda a http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb (configuração padrão do Spring Boot com H2)

*As credenciais padrão do H2 é: User: 'sa' e senha vazia / empty.*
