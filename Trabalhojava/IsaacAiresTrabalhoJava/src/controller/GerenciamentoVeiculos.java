package controller;

import exception.ExcecaoPersonalizada;
import model.Abastecimento;
import model.Despesa;
import model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoVeiculos {
    private List<Veiculo> veiculos;

    public GerenciamentoVeiculos() {
        this.veiculos = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo veiculo) throws ExcecaoPersonalizada {
        // Verifica se já existe um veículo com a mesma placa
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(veiculo.getPlaca())) {
                throw new ExcecaoPersonalizada("Veículo com essa placa já está cadastrado.");
            }
        }
        veiculos.add(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarAbastecimento(Veiculo veiculo, Abastecimento abastecimento) throws ExcecaoPersonalizada {
        veiculo.adicionarAbastecimento(abastecimento);
    }

    public void adicionarDespesa(Veiculo veiculo, Despesa despesa) throws ExcecaoPersonalizada {
        veiculo.adicionarDespesa(despesa);
    }

    public double calcularConsumoMedio(Veiculo veiculo) throws ExcecaoPersonalizada {
        // Lógica para calcular o consumo médio
        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();
        if (abastecimentos.size() < 2) {
            throw new ExcecaoPersonalizada("Não há abastecimentos suficientes para calcular o consumo médio.");
        }

        double totalCombustivel = 0;
        int totalQuilometragem = 0;

        for (int i = 1; i < abastecimentos.size(); i++) {
            Abastecimento abastecimentoAtual = abastecimentos.get(i);
            Abastecimento abastecimentoAnterior = abastecimentos.get(i - 1);

            totalCombustivel += abastecimentoAtual.getQuantidadeCombustivel();
            totalQuilometragem += abastecimentoAtual.getQuilometragemAtual() - abastecimentoAnterior.getQuilometragemAtual();
        }

        return totalQuilometragem / totalCombustivel;
    }

    public List<Despesa> obterDespesasPorCategoria(Veiculo veiculo, String categoria) {
        
        return veiculo.getDespesasPorCategoria(categoria);
    }

    public List<Despesa> getDespesas(Veiculo veiculo) {

        return veiculo.getDespesas(); 
    }
}
