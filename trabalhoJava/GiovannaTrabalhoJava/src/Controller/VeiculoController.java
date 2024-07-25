package Controller;

import Model.Veiculo;
import exception.Excecao;
import java.time.LocalDate;
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

    public double calcularConsumoMedio() {
        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();
        if (abastecimentos.size() < 2) {
            return 0.0; // Não há dados suficientes para calcular o consumo
        }

        // Calculando consumo médio (km/l)
        double totalKm = 0.0;
        double totalLitros = 0.0;

        for (int i = 1; i < abastecimentos.size(); i++) {
            Abastecimento atual = abastecimentos.get(i);
            Abastecimento anterior = abastecimentos.get(i - 1);

            totalKm += atual.getQuilometragem() - anterior.getQuilometragem();
            totalLitros += atual.getQuantidade();
        }

        return totalKm / totalLitros;
    }

    public void adicionarGasto(String categoria, String descricao, double valor, LocalDate data) {
        Gasto gasto = new Gasto(categoria, descricao, valor, data);
        veiculo.adicionarGasto(gasto);
    }

    public double calcularGastoTotal() {
        List<Gasto> gastos = veiculo.getGastos();
        double gastoTotal = 0.0;

        for (Gasto gasto : gastos) {
            gastoTotal += gasto.getValor();
        }

        return gastoTotal;
    }
}
