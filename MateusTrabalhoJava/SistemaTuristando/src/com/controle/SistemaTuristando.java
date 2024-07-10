package com.controle;

import com.abastecimento.Abastecimento;
import com.veiculo.Veiculo;
import java.util.ArrayList;

public class SistemaTuristando {

    private ArrayList<Veiculo> listaVeiculos;
    private ArrayList<Abastecimento> listaAbastecimentos;

    public void adicionarVeiculoALista(Veiculo veiculo){
        listaVeiculos.add(veiculo);
    }


    public void registrarAbastecimento(Abastecimento abastecimento){
        listaAbastecimentos.add(abastecimento);
    }


    public void gerarRelatorio() {
        System.out.println("Relatório Geral de Eventos:");

        // Exibir todos os abastecimentos
        System.out.println("\nAbastecimentos:");
        for (Abastecimento abastecimento : listaAbastecimentos) {
            System.out.println(abastecimento);
        }
    }
    
    

}
