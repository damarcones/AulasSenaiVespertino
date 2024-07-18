package com.controle;

import com.abastecimento.Abastecimento;
import com.gasto.Gasto;
import com.veiculo.Veiculo;
import java.util.ArrayList;

public class SistemaTuristando {

    private ArrayList<Veiculo> listaVeiculos= new ArrayList<>(); // criando a instancia do array
    private ArrayList<Abastecimento> listaAbastecimentos = new ArrayList<>(); // criando a instancia do array

    private ArrayList<Gasto> listaGastos = new ArrayList<>(); // criando a instancia do array

    
    //Metodo que adiociona todos os Veiculos a uma lista
    public void adicionarVeiculoALista(Veiculo veiculo){
        this.listaVeiculos.add(veiculo);
    }


    //Metodo que adiociona todos os Abastecimentos a uma lista
    public void registrarAbastecimento(Abastecimento abastecimento){
        this.listaAbastecimentos.add(abastecimento);

        this.registrarGasto(new Gasto(abastecimento.getVeiculo(), "Abastecimento", "Abastecimento do Veículo", abastecimento.getValorTotal()));

    }

    public Veiculo encontrarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public void calcularConsumoMedio() {
        // percorre os veiculos e os abastecimentos
        for (Veiculo veiculo : listaVeiculos) {
            double totalQuilometros = 0.0;
            double totalLitros = 0.0;
            int cont = 0;
            
            Abastecimento abastecimentoAnterior = null;


            for (Abastecimento abastecimento : listaAbastecimentos) {
                //verifica de o abastecimente é do carro em questão
                if (abastecimento.getVeiculo().equals(veiculo)) {
                    //caso for, vai calcular a distancia percorrida desde o abastecimento anterior e se n tiver, vai armazenar numa variavel auxiliar
                    if (abastecimentoAnterior != null) {
                        double quilometrosPercorridos = abastecimento.getQuilometragem() - abastecimentoAnterior.getQuilometragem();
                        totalQuilometros += quilometrosPercorridos;
                        totalLitros += abastecimento.getQuantidadeCombustivel();
                    }
                    abastecimentoAnterior = abastecimento;
                    cont += 1;
                }
            }

            if (cont >= 2) {
                double consumoMedio = totalQuilometros / totalLitros;
                System.out.printf("Consumo médio de %s %s: %.2f km/L%n",
                        veiculo.getMarca(), veiculo.getModelo(), consumoMedio);
            } else {
                System.out.printf("Não há abastecimentos suficientes para calcular o consumo do veículo %s %s.%n",
                        veiculo.getMarca(), veiculo.getModelo());
            }
        }
    }

    //Metodo usando sobrecarga, onde pode-se calcular o consumo de um unico veiculo atraves da placa como parametro.
    public void calcularConsumoMedio(String placa) {
        Veiculo veiculo = encontrarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            Abastecimento abastecimentoAnterior = null;
            double totalQuilometros = 0.0;
            double totalLitros = 0.0;
            int cont = 0;
            
            for (Abastecimento abastecimento : listaAbastecimentos) {
                //verifica de o abastecimente é do carro em questão
                if (abastecimento.getVeiculo().equals(veiculo)) {
                    //caso for, vai calcular a distancia percorrida desde o abastecimento anterior e se n tiver, vai armazenar numa variavel auxiliar
                    if (abastecimentoAnterior != null) {
                        double quilometrosPercorridos = abastecimento.getQuilometragem() - abastecimentoAnterior.getQuilometragem();
                        totalQuilometros += quilometrosPercorridos;
                        totalLitros += abastecimento.getQuantidadeCombustivel();
                    }
                    abastecimentoAnterior = abastecimento;
                    cont += 1;
                }
            }

            if (cont >= 2) {
                double consumoMedio = totalQuilometros / totalLitros;
                System.out.printf("Consumo médio do veículo %s, placa %s : %.2f km/L%n",
                        veiculo.getModelo() ,veiculo.getPlaca(), consumoMedio);
            } else {
                System.out.printf("Não há abastecimentos suficientes para calcular o consumo do veículo %s",
                        veiculo.getPlaca());
            }
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }


    public void registrarGasto(Gasto gasto){
        this.listaGastos.add(gasto);
    }

    //Metodo que exibe o relatorio geral(não categoria) do sistema
    public void gerarRelatorio() {
        System.out.println("Relatório Geral de Eventos:");

        // Exibir todos os abastecimentos
        System.out.println("\nAbastecimentos:");
        //percorrendo e imprimindo a lista
        for (Abastecimento abastecimento : listaAbastecimentos) {
            System.out.println(abastecimento);
            System.out.println();
        }

        System.out.println();

        System.out.println("\nVeiculos:");
        for (Veiculo veiculo : listaVeiculos) {
            System.out.println(veiculo);
            System.out.println();
        }

    }

    public void exibirListaVeiculos() {
        System.out.println("Lista Veiculos:");

        // Exibir todos os abastecimentos
        System.out.println("\nVeiculos:");
        for (Veiculo veiculo : listaVeiculos) {
            System.out.println(veiculo);
        }
    }

    public void exibirListaGastos() {
        System.out.println("Lista Gastos:");

        // Exibir todos os abastecimentos
        System.out.println("\nGastos:");
        for (Gasto gasto : listaGastos) {
            System.out.println(gasto);
        }
    }
    
}
