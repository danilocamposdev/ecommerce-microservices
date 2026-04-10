# Ecommerce Microservices - Projeto Final Bootcamp Riachuelo

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk" alt="Java 21">
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=springboot" alt="Spring Boot 3">
  <img src="https://img.shields.io/badge/RabbitMQ-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white" alt="RabbitMQ">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
</p>

## 📌 Sobre o Projeto

Este projeto é o desafio final do **Bootcamp "Riachuelo - Primeiros Passos com Java"** realizado pela **DIO (Digital Innovation One)**.

Trata-se de um sistema de e-commerce baseado em uma **arquitetura de microserviços**, desenvolvida para consolidar o domínio de tecnologias modernas do ecossistema Java.

---

## 🏗️ Arquitetura do Sistema

O projeto é dividido em dois serviços principais que se comunicam de forma desacoplada:

1. **Storefront Service**: Responsável pela interface de venda e interação direta com o cliente.
2. **Warehouse Service**: Gerencia os produtos e estoque do ecommerce.

A comunicação entre eles é realizada através do **RabbitMQ**.

---

## 🛠️ Tecnologias e Ferramentas

- **Linguagem:** Java 21 (LTS)
- **Framework:** Spring Boot 3
- **Mensageria:** RabbitMQ (Broker de mensagens assíncronas)
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** H2 Database (In-memory para um desenvolvimento mais ágil)
- **Gerenciador de Dependências:** Maven
- **Ambiente de Desenvolvimento:** Neovim (Linux)

---

## 🔧 Como Executar o Projeto

1. **Pré-requisitos:** Ter o Java 21 e o Maven instalados. Ter uma instância do RabbitMQ rodando (Docker ou Local).
2. **Clonar o repositório:**

   ```bash
   git clone [https://github.com/danilocamposdev/ecommerce-microservices.git](https://github.com/danilocamposdev/ecommerce-microservices.git)
