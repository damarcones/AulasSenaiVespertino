# Trabalho Prático de Java

Essa branch é destinada para o trabalho prático de ``` Java ``` da turma ```  QUA.209.071 - Desenvolvedor JAVA ``` Vespertina do Senai Taguatinga de 2024. 

## Enunciado

Você foi contratado(a) pela Turistando, uma empresa que possui uma frota de veículos que transporta turistas em Porto Seguro - BA, para desenvolver um programa cujo objetivo é contabilizar os gastos (abastecimento, manutenção, impostos, multas e outros) gerados com os carros da empresa.

Uma das exigências da Turistando é que o programa faça o cálculo do consumo de combustível de seus veículos, ou seja, calcule quantos quilometros o veículo faz por litro de combustível. Para isso, foi informado a você que todo abastecimento do veículo é do tipo "completar o tanque" até o automático da bomba; e para registrar o abastecimento é preciso inserir o valor e a quantidade de combustível abastecido, e a quilometragem atual do veículo (exemplo: 168,00, 27.42 e 112,352). Assim, você deverá utilizar todos os abastecimentos registrados no sistema e apresentar quantos quilometros o veículo faz, em média, por litro de combustível.

As outras funcionalidades que o sistema que você irá deselvolver deve possuir são cálculos de outros gastos do veículo. Estes gastos devem ser sinalizados conforme sua categoria:  manutenção (Troca de óleo, alinhamento e balanceamento, etc); imposto (IPVA, licenciamento, etc); multa (Estacionamento proibido, etc ) e outros(pedágios, balsas, etc); e, sempre que solicitado, o programa exibirá um relatório com todos os eventos lançados no programa, sendo possível selecionar um relatório por categoria de despesa ou um relatório geral.

## Requisitos Mínimos

Como você é um(a) desenvolvedor(a) atencioso(a), desenvolverá o programa que permita o cadastro de mais de um veículo da Turistando, contendo as seguintes informações: Marca, modelo, ano de fabricação, ano do modelo, motorização, capacidade do tanque, combustíveis, cor, placa, renavam.

Com o veículo cadastrado, será possível inserir os dados sobre os gastos do veículo em questão.

O dono da empresa é um grande fã de tecnologia e fez um pedido especial a você: que o programa seja desenvolvido utilizando <i>somente</i> Java e suas bibliotecas nativas.

Para garantir que as informações sejam salvas de maneira correta, você criará exceções personalizadas para tratar os seguintes casos:
- O tipo de combustível que será abastecido não é válido;
- Ao cadastrar algo no sistema, o usuário deixa alguma informação em branco;
- O usuário tente cadastrar um valor inválido (ex.: colocar um custo negativo);
- O usuário tente inserir informações em carros que não foram cadastrados;
- O cálculo de consumo só poderá ser feito quando houver, no mínimo, dois abastecimentos completos cadastrados.


**Observação**: Certamente haverá classes e atributos que não estão descritos no problema, mas que são necessários para o desenvolvimento do projeto e é obrigatório a utilização de pacotes e da classe `JOptionPane`.

## Forma de Entrega

- Deverá ser realizado um `Fork` dessa branch em seu repositório pessoal;
- A raiz do projeto deve ser nomeada com seu nome + "TrabalhoJava" (Ex: DamarconesTrabalhoJava);
- O trabalho deve ser entregue até o dia ~29/07/2024~ 05/08/2024, com o último commit podendo ser realizado até às 13:50h do dia limite para entrega;
- A entrega será realizada com a criação de um  `Pull Request` para a branch `TrabalhoJava`, que deverá ser realizado até dia ~29/07/2024~ 05/08/2024;
- É recomendável que o trabalho seja adicionado ao seu GitHub periodicamente, não havendo apenas 1 commit para todo o seu trabalho.