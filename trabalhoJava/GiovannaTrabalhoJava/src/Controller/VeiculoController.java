package Controller;

import Model.Veiculo;
import exception.Excecao;
import java.time.LocalDate;
import java.util.List;
import Model.Abastecimento;
import Model.Gasto;


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

    public List<Abastecimento> getAbastecimentos() {
        return getAbastecimentos();
    }

    public List<Gasto> getGastos() {
        return getGastos();
    }

    public double calcularConsumoMedio() {
        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();
        if (abastecimentos.size() < 2) {
            return 0.0;
        }

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
        Gasto gasto = new Gasto(null, descricao, valor, data);
        veiculo.adicionarGasto(gasto);
    }

    public double calcularGastoTotal() {
        List<Gasto> gastos = veiculo.getGastos();
        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();
        double gastoTotal = 0.0;

        for (Gasto gasto : gastos) {
            gastoTotal += gasto.getValor();
        }

        for (Abastecimento abastecimento : abastecimentos) {
            gastoTotal += abastecimento.getValor();
    }
        return gastoTotal;
} 
}
