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
        return veiculo.getAbastecimentos();
    }

    public double calcularConsumoMedio() throws Excecao {
        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();
        int numAbastecimentos = abastecimentos.size();

        if (numAbastecimentos < 2) {
            throw new Excecao("A média só pode ser calculada depois de dois abastecimentos.");
        }

        Abastecimento primeiroAbastecimento = abastecimentos.get(0);
        Abastecimento ultimoAbastecimento = abastecimentos.get(numAbastecimentos - 1);

        double totalKm = ultimoAbastecimento.getQuilometragem() - primeiroAbastecimento.getQuilometragem();
        double totalLitros = abastecimentos.stream()
                .mapToDouble(Abastecimento::getQuantidade)
                .sum();

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

    public List<Gasto> getListaDeGastos() {
        return veiculo.getGastos();
    }
}
