package Controller;

import exception.Excecao;
import java.time.LocalDate;
import Model.Abastecimento;
import Model.Gasto;
import Model.Veiculo;


    @SuppressWarnings("rawtypes")
public class VeiculoController {
    private Veiculo veiculo;

    public VeiculoController(Veiculo veiculo) {
        this.veiculo = veiculo;
    }


    public void adicionarAbastecimento(int quilometragem, double valor, double quantidade) throws Excecao{
        if (valor <= 0 || quantidade <= 0) {
            throw new Excecao("Valor ou quantidade de combustível não podem ser negativos ou zero.");
        }
        if (quilometragem < 0) {
            throw new Excecao("A quilometragem não pode ser negativa.");
        }
        veiculo.adicionarAbastecimento(new Abastecimento(quilometragem, valor, quantidade));
    }

    public void adicionarGasto(String categoria, String descricao, double valor, LocalDate data) throws Excecao {
        if (categoria == null || categoria.isBlank()) {
            throw new Excecao("A categoria não pode ser vazia.");
        }
        if (descricao == null || descricao.isBlank()) {
            throw new Excecao("A descrição não pode ser vazia.");
        }
        if (valor <= 0) {
            throw new Excecao("O valor do gasto não pode ser negativo ou zero.");
        }
        veiculo.adicionarGasto(new Gasto(categoria, descricao, valor, data));
    }

    public double calcularConsumoMedio() {
        return veiculo.calcularConsumoMedio();
    }

    public double calcularGastoTotal() {
        return veiculo.calcularGastosTotais();
    }
}
