# Projeto - Testes Automatizados I

Este projeto foi desenvolvido com base no projeto criado durante o módulo API REST pelos autores [Bruno Tavares](https://www.linkedin.com/in/brunoviniciusdev/), [Ingrid Maciel](https://www.linkedin.com/in/ingrid-m-maciel/), [Pedro Renan](https://www.linkedin.com/in/pedrorenan/) e [Vitor Tavares](https://www.linkedin.com/in/vitortavares1/). Neste projeto, adicionei testes automatizados para garantir a qualidade e a confiabilidade do código.

### 📜 Enunciado API REST:

Desenvolva uma API REST com tema livre, sendo obrigatório consumir uma API pública.

Nesta API, decidimos utilizar uma API de previsão do tempo, onde passamos o nome da cidade e ela retorna a previsão dos últimos quatro dias.

Construir uma API
 -  Persistência em banco de dados (H2 ou Postgres)
 -  Consumo de uma API externa pública
 -  Frontend opcional

---

### 🛠️ Utilizado:

- Java 17
- Programação Orientada a Objetos (POO)
- Spring Boot
- Spring Security
- Banco H2
- Mapper Struct
- Spring DATA JPA
- HTML
- CSS

---

### ✅ Testes Automatizados:

Para garantir a qualidade e a estabilidade do nosso código, foram implementados testes unitários utilizando as seguintes ferramentas:

- **JUnit**: Framework de testes unitários para Java.
- **Mockito**: Biblioteca para criação de objetos mock em testes.
- **Spring Test**: Suporte para testes de integração com Spring.
  
---

### ⚙️ Funcionalidades:

#### 🏙️ Cidade:

- Buscar Cidade na API
- Salvar Cidade no Banco
- Buscar Todas as Cidades Pesquisadas

#### 🌤️ Clima:

- Buscar o clima pelo ID da Cidade
- Salvar o clima no Banco
