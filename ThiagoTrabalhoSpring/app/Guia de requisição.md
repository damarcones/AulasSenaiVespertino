## Guia de Endpoints

 *VEÍCULO*

**Cadastrar veículo:**

json:
~~~json
{
   "placa": "abc1234",
   "marca": "RAM",
   "modelo": "TRX",
   "anoModelo": 2023,
   "anoFabricacao": 2023,
   "cor": "laranja",
   "renavam": 123456789,
   "motorizacao": 6,
   "capacidadeTanque": 85,
   "combustivel": "Diesel"
}
~~~

Mostrar Veiculos cadastrados: POST - http://localhost:8080/mostrarveiculos

Modificar Veiculo: PUT - http://localhost:8080/modificarveiculo/abc1234

Deletar Veiculo: DELETE - http://localhost:8080/apagarveiculo/abc12345

###

*ABASTECIMENTO*
Cadastrar abastecimento: POST - localhost:8080/abastecerveiculo
JSON
~~~ json
{
	"litroabastecido":25.0,
	"quilometragem":38.8,
	"tipoabastecido":"Diesel",
	"Veiculo":{"placaveiculo":"abc1234"}
}
~~~
mostrar historico de abastecimentos gerais: GET - http://localhost:8080/mostrarabastecimentosgeral

###

*DESPESAS*
Cadastrar despesa: POST - http://localhost:8080/cadastrargasto
JSON
~~~ json
{
	"tipogasto":"Manutencao",
	"Descrição":"Troca de oleo",
	"valor":86.20,
	"Veiculo":{"placaveiculo":"abc1234"}
}
~~~

mostrar despesas: GET - http://localhost:8080/Mostrargastoveiculo/abc1234

modificar despesas: PUT - 

deletar despesa: DELETE - 
