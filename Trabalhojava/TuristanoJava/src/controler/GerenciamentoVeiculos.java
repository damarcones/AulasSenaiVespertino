package controler;

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
        validarCadastroVeiculo(veiculo);
        veiculos.add(veiculo);
    }

    public void adicionarAbastecimento(Veiculo veiculo, Abastecimento abastecimento) throws ExcecaoPersonalizada {
        veiculo.getAbastecimentos().add(abastecimento);
    }

    public void adicionarDespesa(Veiculo veiculo, Despesa despesa) throws ExcecaoPersonalizada {
        veiculo.getDespesas().add(despesa);
    }

    public double calcularConsumoMedio(Veiculo veiculo) throws ExcecaoPersonalizada {
        if (veiculo.getAbastecimentos().size() < 2) {
            throw new ExcecaoPersonalizada("É necessário ter pelo menos dois abastecimentos registrados para calcular o consumo médio.");
        }
        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();
        double totalKm = abastecimentos.get(abastecimentos.size() - 1).getQuilometragemAtual() - abastecimentos.get(0).getQuilometragemAtual();
        double totalCombustivel = abastecimentos.stream().mapToDouble(Abastecimento::getQuantidadeCombustivel).sum();
        return totalKm / totalCombustivel;
    }

    private void validarCadastroVeiculo(Veiculo veiculo) throws ExcecaoPersonalizada {
        if (veiculo.getMarca().isEmpty() || veiculo.getModelo().isEmpty() || veiculo.getPlaca().isEmpty()) {
            throw new ExcecaoPersonalizada("Campos obrigatórios não preenchidos.");
        }
    }

}
