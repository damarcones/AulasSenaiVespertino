# Guia de endpoints da aplicação

### Endpoints Veículo


Listar veículos / Método GET ->
http://localhost:8080/veiculos

---

Listar um veículo pela placa(pk) / Método GET -> http://localhost:8080/veiculos/ABC1265

---

Registrar um veículo / Método POST ->
http://localhost:8080/veiculos

json:
~~~json
    {	
        "placa":"TRC1265",
        "marca":"Honda",
        "modelo":"Fit",
        "anoFabricacao":2020,
        "anoModelo":2021,
        "motorizacao":1.8,
        "capacidadeTanque":50.0,
        "combustiveisAceitos":"FLEX",
        "cor":"Prata",
        "renavam":6534561290
    }
~~~

---

Atualizar um veículo / Método PUT -> http://localhost:8080/veiculos
json:
~~~json
    {
        "placa":"TRC1265",
        "marca":"Honda",
        "modelo":"CITY",
        "anoFabricacao":2022,
        "anoModelo":2022,
        "motorizacao":1.8,
        "capacidadeTanque":50.0,
        "combustiveisAceitos":"FLEX",
        "cor":"Prata",
        "renavam":6534561290
    }
~~~~

---

Deletar veiculo através da placa / Método  DELETE -> http://localhost:8080/veiculos/TRC1265

---

Calcular consumo médio de um veículo através da placa / Método GET -> http://localhost:8080/veiculos/consumo-medio?placa=TRC1265
__(OBS: será necessário DOIS registros de abastecimentos para o veículo solicitado)__

---

### Endpoints Abastecimento

Listar todos os Abastecimentos / Método GET -> http://localhost:8080/abastecimentos

---

Listar todos os Abastecimentos de um veículo através da placa / Método GET -> http://localhost:8080/abastecimentos/veiculo/TRC1265

---

Listar um Abastecimento através do id / Método GET -> http://localhost:8080/abastecimentos/1

---

Registrar um abastecimento / Método POST -> http://localhost:8080/abastecimentos

json:
~~~~json
    {
        "veiculo":{"placa":"TRC1265"},
        "data":"2024-08-17",
        "quilometragem": 1000.0,
        "tipoCombustivel":"GASOLINA",
        "quantidadeCombustivel":"45.0",
        "valorTotal": 225.0
    }
~~~~

---


Atualizar um abastecimento / Método PUT -> http://localhost:8080/abastecimentos

json:

~~~json
    {
        "idAbastecimento": 1,
        "veiculo":{"placa":"TRC1265"},
        "data":"2024-08-17",
        "quilometragem": 1000.0,
        "tipoCombustivel":"GASOLINA",
        "quantidadeCombustivel":"45.0",
        "valorTotal": 230.0
    }
~~~
---

Deletar um abastecimento através do id / Método DELETE -> http://localhost:8080/abastecimentos/1 

---

Listar todos os gastos / Método GET -> http://localhost:8080/gastos

---

Listar um gasto através do id / Método GET -> http://localhost:8080/gastos/1

---

Listar todos os gastos de um veículo através da placa / Método GET -> http://localhost:8080/gastos/veiculo/TRC1265

---

Registrar um gasto / Método POST -> http://localhost:8080/gastos

json:

~~~json
    {
        "data":"2024-08-17",
        "descricao":"Ipva ano 2024",
        "tipo":"IMPOSTO",
        "valor":15650.0,
        "veiculo":{"placa":"TRC1265"}
    }
~~~

---

Atualizar gasto / Método PUT -> http://localhost:8080/gastos

json:

~~~json
    {
        "id": 10,
        "data":"2024-08-17",
        "descricao":"Ipva ano 2023",
        "tipo":"IMPOSTO",
        "valor":15650.0,
        "veiculo":{"placa":"TRC1265"}
    }
~~~

---

Deletar um gasto 
DELETE
http://localhost:8080/gastos/1

------------------------------------------------------------
