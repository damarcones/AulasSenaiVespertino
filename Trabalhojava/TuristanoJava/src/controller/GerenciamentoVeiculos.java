package controller;

import model.Abastecimento;
import model.Despesa;
import model.Veiculo;
import exception.ExcecaoPersonalizada;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoVeiculos {
    @SuppressWarnings("rawtypes")
    private List<Veiculo> veiculos;

    public GerenciamentoVeiculos() {
        this.veiculos = new ArrayList<>();
    }

    @SuppressWarnings("rawtypes")
    public void cadastrarVeiculo(Veiculo veiculo) throws ExcecaoPersonalizada {
        if (veiculo == null) {
            throw new ExcecaoPersonalizada("Veículo não pode ser nulo.");
        }
        veiculos.add(veiculo);
    }

    @SuppressWarnings("rawtypes")
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void adicionarAbastecimento(Veiculo veiculo, Abastecimento abastecimento) throws ExcecaoPersonalizada {
        if (veiculo == null) {
            throw new ExcecaoPersonalizada("Veículo não pode ser nulo.");
        }
        if (abastecimento == null) {
            throw new ExcecaoPersonalizada("Abastecimento não pode ser nulo.");
        }
        veiculo.getAbastecimentos().add(abastecimento);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void adicionarDespesa(Veiculo veiculo, Despesa despesa) throws ExcecaoPersonalizada {
        if (veiculo == null) {
            throw new ExcecaoPersonalizada("Veículo não pode ser nulo.");
        }
        if (despesa == null) {
            throw new ExcecaoPersonalizada("Despesa não pode ser nula.");
        }
        veiculo.getDespesas().add(despesa);
    }

    @SuppressWarnings("unchecked")
    public double calcularConsumoMedio(@SuppressWarnings("rawtypes") Veiculo veiculo) throws ExcecaoPersonalizada {
        if (veiculo == null) {
            throw new ExcecaoPersonalizada("Veículo não pode ser nulo.");
        }
        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();
        if (abastecimentos.size() < 2) {
            throw new ExcecaoPersonalizada("É necessário no mínimo dois abastecimentos para calcular o consumo médio.");
        }

        double totalKm = 0;
        double totalCombustivel = 0;

        for (int i = 1; i < abastecimentos.size(); i++) {
            totalKm += abastecimentos.get(i).getQuilometragemAtual() - abastecimentos.get(i - 1).getQuilometragemAtual();
            totalCombustivel += abastecimentos.get(i).getQuantidadeCombustivel();
        }

        return totalKm / totalCombustivel;
    }
}
