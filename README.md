#  App Studio de Cílios

Sistema web para gerenciamento de um estúdio de cílios, permitindo o cadastro de clientes e agendamentos realizados pela dona do estúdio.

---

##  Sobre o projeto

Este projeto está em fase inicial e tem como objetivo facilitar o controle de atendimentos em um estúdio de cílios.

A ideia é:

* Cadastro de clientes
* Agendamentos de serviços
* Organização da rotina do estúdio

---

##  Funcionalidades atuais

*  CRUD de clientes
*  Agendamento de clientes
*  CRUD de agendamentos

---

## Tecnologias utilizadas

* Java
* Quarkus
* MySQL

---

## Estrutura do projeto

```
src/main/java/br/com/vivistudio
│
├── entity      → classes que representam as tabelas do banco (Cliente, Agendamento, etc.)
├── repository  → comunicação com o banco de dados (JPA/Hibernate)
├── service     → regras de negócio da aplicação
├── resource    → endpoints da API (controllers)
│
└── config      → (opcional) configurações adicionais do sistema
```

 Organização em camadas:

* **Resource** → recebe as requisições
* **Service** → processa a lógica
* **Repository** → acessa o banco
* **Entity** → representa os dados

Essa estrutura segue um padrão de arquitetura em camadas, facilitando manutenção e crescimento do sistema.

---

##  Como rodar o projeto

1. Clonar o repositório:

```
git clone <URL_DO_SEU_REPOSITORIO>
```

2. Acessar a pasta:

```
cd appquarkus
```

3. Configurar o banco de dados no `application.properties`

4. Rodar o projeto:

```
./mvnw quarkus:dev
```

---

##  Status do projeto

 Em desenvolvimento — novas funcionalidades serão adicionadas em breve:

* Sistema completo de agendamento
* Interface para o usuário (frontend)
* Autenticação de usuários
* Dashboard do estúdio

---

##  Objetivo futuro

Transformar o sistema em uma solução completa para gestão de estúdios de beleza.

---

##  Autor

Desenvolvido por você 
