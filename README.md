Aqui está o README atualizado com o exemplo de JSON para registrar abastecimento:

---

# Projeto Turistando

O **Turistando** é um sistema para gerenciar e controlar os gastos com veículos de uma empresa de transporte de turistas. O sistema permite registrar abastecimentos, despesas e visualizar relatórios detalhados por veículo.

## Índice

- [Descrição do Projeto](#descrição-do-projeto)
- [Dependências](#dependências)
- [Instalação e Configuração](#instalação-e-configuração)
- [Casos de Uso](#casos-de-uso)
- [Endpoints da API](#endpoints-da-api)
- [Exemplo de Cadastro de Veículo](#exemplo-de-cadastro-de-veículo)
- [Exemplo de Registro de Despesa](#exemplo-de-registro-de-despesa)
- [Exemplo de Registro de Abastecimento](#exemplo-de-registro-de-abastecimento)
- [Como Contribuir](#como-contribuir)

## Descrição do Projeto

Este projeto foi desenvolvido utilizando Java com o framework Spring Boot e um banco de dados MySQL. O sistema inclui funcionalidades para:

- Registrar e gerenciar veículos.
- Registrar abastecimentos e despesas dos veículos.
- Calcular consumo médio de combustível.
- Gerar relatórios de despesas e abastecimentos por veículo.

## Dependências

O projeto utiliza as seguintes dependências:

- **Spring Boot**: Framework para construção da aplicação.
- **Spring Data JPA**: Para acesso ao banco de dados.
- **MySQL**: Banco de dados relacional.
- **Lombok**: Biblioteca para reduzir a verbosidade do código Java.
- **Gson** ou **org.json** (opcional): Para serialização/deserialização JSON.

**Exemplo de dependências Maven:**

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.24</version>
        <scope>provided</scope>
    </dependency>
```

## Instalação e Configuração

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/Isaac-code-maker/AulasSenaiVespertino/TrabalhoSpringBoot
    ```

2. **Navegue até o diretório do projeto:**

    ```bash
    cd turistando
    ```

3. **Configure o banco de dados MySQL:**

    Crie um banco de dados chamado `turistando` no MySQL e configure as credenciais no arquivo `application.properties`:

    ```properties
    spring.application.name=springturistando

    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/BancoTuristando?createDatabaseIfNotExist=true
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=

    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    spring.jpa.show-sql=true
    ```

## Casos de Uso

### 1. Registro de Veículo

- **Descrição:** Adiciona um novo veículo ao sistema.
- **Requisitos:** Informações como placa, marca, modelo, ano, motorização e capacidade do tanque.

### 2. Registro de Abastecimento

- **Descrição:** Registra um abastecimento realizado em um veículo.
- **Requisitos:** Placa do veículo, quilometragem, quantidade de combustível e valor.

### 3. Registro de Despesa

- **Descrição:** Registra uma despesa associada a um veículo.
- **Requisitos:** Placa do veículo, valor, tipo de despesa e descrição.


### 5. Geração de Relatórios

- **Descrição:** Gera relatórios detalhados de despesas e abastecimentos por veículo.
- **Requisitos:** Placa do veículo.

## Endpoints da API

### 1. Veículos

- **Cadastrar Veículo**
  - **Método:** POST
  - **URL:** `http://localhost:8080/veiculos/cadastrarveiculo`
  - **Descrição:** Cadastra um novo veículo.
  - **Corpo da Requisição (JSON):**
    ```json
    {
        "placa": "DEF-5678",
        "marca": "Honda",
        "modelo": "Civic",
        "anoFabricacao": 2019,
        "anoModelo": 2020,
        "motorizacao": "2.0L",
        "capacidadeTanque": 45.0,
        "combustiveis": "Gasolina",
        "cor": "Preto",
        "renavam": "23456789012"
    }
    ```

- **Listar Veículos**
  - **Método:** GET
  - **URL:** `http://localhost:8080/veiculos/listarveiculos`
  - **Descrição:** Retorna a lista de todos os veículos.

- **Excluir Veículo**
  - **Método:** DELETE
  - **URL:** `http://localhost:8080/veiculos/excluirveiculo/{placa}`
  - **Descrição:** Remove um veículo do sistema.

### 2. Abastecimentos

- **Registrar Abastecimento**
  - **Método:** POST
  - **URL:** `http://localhost:8080/abastecimentos/registrarabastecimento/{placa}`
  - **Descrição:** Registra um abastecimento para um veículo específico.
  - **Corpo da Requisição (JSON):**
    ```json
    {
        "valor": 200.00,
        "quantidadeCombustivel": 60.0,
        "quilometragem": 12500.0,
        "dataAbastecimento": "2024-08-25"
    }
    ```

- **Listar Abastecimentos por Placa**
  - **Método:** GET
  - **URL:** `http://localhost:8080/abastecimentos/listarabastecimento/{placa}`
  - **Descrição:** Retorna a lista de abastecimentos de um veículo específico.

### 3. Despesas

- **Registrar Despesa**
  - **Método:** POST
  - **URL:** `http://localhost:8080/despesas/registrardespesa/{placa}`
  - **Descrição:** Registra uma despesa para um veículo específico.
  - **Corpo da Requisição (JSON):**
    ```json
    {
        "valor": 150.0,
        "tipo": "Manutenção",
        "descricao": "Troca de óleo e revisão do sistema de freios",
        "dataDespesa": "2024-08-25"
    }
    ```

- **Listar Despesas por Placa**
  - **Método:** GET
  - **URL:** `http://localhost:8080/despesas/listardespesaplaca/{placa}`
  - **Descrição:** Retorna a lista de despesas de um veículo específico.

### 4. Relatórios

- **Gerar Relatório Geral por Categoria**
  - **Método:** GET
  - **URL:** `http://localhost:8080/veiculos/relatorio/{placa}`
  - **Descrição:** Gera um relatório geral de despesas e abastecimentos por categoria para um veículo específico.

### 5. Cálculo de Consumo Médio

- **Descrição:** Calcula o consumo médio de combustível de um veículo com base nos abastecimentos registrados.
- **Requisitos:** Placa do veículo, variação de abastecimento.
- - **Método:** GET
  - **URL:** `http://localhost:8080/veiculos/consumo-medio/{placa}`
    
