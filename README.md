# Ecommerce Microservices - Projeto Final Bootcamp Riachuelo

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk" alt="Java 21">
  <img src="https://img.shields.io/badge/Spring_Boot-green?style=for-the-badge&logo=springboot" alt="Spring Boot">
  <img src="https://img.shields.io/badge/RabbitMQ-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white" alt="RabbitMQ">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/NeoVim-%2357A143.svg?&style=for-the-badge&logo=neovim&logoColor=white" alt="NeoVim">
</p>

## 📌 Sobre o Projeto

Este projeto é o desafio final do **Bootcamp "Riachuelo - Primeiros Passos com Java"** da **DIO (Digital Innovation One)**.

Trata-se de um sistema de e-commerce baseado em uma **arquitetura de microserviços**, desenvolvida para consolidar o aprendizado de tecnologias modernas do ecossistema Java.

---

## 🏗️ Arquitetura do Sistema

O projeto é dividido em dois serviços principais que se comunicam de forma desacoplada:

1. **Storefront**: Responsável pela interface de venda e interação direta com o cliente.
2. **Warehouse**: Gerenciamento dos produtos e estoque.

---

## 🛠️ Tecnologias e Ferramentas

- **Linguagem:** Java 21 (LTS)
- **Framework:** Spring Boot
- **Mensageria:** RabbitMQ (Broker de mensagens assíncronas)
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** H2 Database (In-memory)
- **Gerenciador de Dependências:** Maven
- **Ambiente de Desenvolvimento:** Neovim (Linux)

---

## 🔧 Como Executar o Projeto

1. **Pré-requisitos:** Ter o Java 21 e o Maven instalados. Ter uma instância do RabbitMQ rodando (Docker ou Local).
2. **Clonar o repositório:**

```bash
   git clone https://github.com/danilocamposdev/ecommerce-microservices.git
```

1. **Executar o Warehouse:**

```bash
  cd warehouse
  mvn spring-boot:run
```

1. **Executar o Storefront:**

```bash
  cd storefront
  mvn spring-boot:run
```
