package Controller;

import Model.Veiculo;
import exception.Excecao;

import java.util.List;

import Model.Abastecimento;
import Model.Gasto;


    @SuppressWarnings({"rawtypes", "unchecked"})
public class VeiculoController {

    private Veiculo veiculo;

    public VeiculoController(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void adicionarAbastecimento(Abastecimento abastecimento) throws Excecao {
        if (abastecimento == null) {
            throw new Excecao("Abastecimento não pode ser nulo.");
        }
        veiculo.getAbastecimentos().add(abastecimento);
    }

    public void adicionarGasto(Gasto gasto) throws Excecao {
        if (gasto == null) {
            throw new Excecao("Gasto não pode ser nulo.");
        }
        veiculo.getGastos().add(gasto);
    }

        // Getter para a lista de abastecimentos
    public List<Abastecimento> getAbastecimentos() {
        return getAbastecimentos();
    }

    // Getter para a lista de gastos
    public List<Gasto> getGastos() {
        return getGastos();
    }

    public double calcularConsumoMedio() throws Excecao {
        double totalQuilometragem = 0;
        double totalCombustivel = 0;

        for (Abastecimento abastecimento : Abastecimento.getAbastecimentos()) {
            totalQuilometragem += abastecimento.getQuilometragem();
            totalCombustivel += abastecimento.getQuantidade();
        }

        if (totalCombustivel == 0) {
            throw new Excecao("Nenhum abastecimento registrado.");
        }

        return totalQuilometragem / totalCombustivel;
    }

    public double calcularGastoTotal() throws Excecao {
        double gastoTotal = 0;

        for (Gasto gasto : Gasto.getGastos()) {
            gastoTotal += gasto.getValor();
        }

        return gastoTotal;
    }
}
