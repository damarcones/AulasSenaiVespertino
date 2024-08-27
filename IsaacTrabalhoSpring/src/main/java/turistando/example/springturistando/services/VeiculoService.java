package turistando.example.springturistando.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.example.springturistando.exception.VeiculoNaoEncontradoException;
import turistando.example.springturistando.model.AbastecimentoModel;
import turistando.example.springturistando.model.DespesasModel;
import turistando.example.springturistando.model.VeiculoModel;
import turistando.example.springturistando.repositories.AbastecimentoRepository;
import turistando.example.springturistando.repositories.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    public VeiculoModel salvarVeiculo(VeiculoModel veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<VeiculoModel> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    public VeiculoModel buscarVeiculoPorPlaca(String placa) {
        return veiculoRepository.findById(placa)
                .orElseThrow(() -> new VeiculoNaoEncontradoException("Veículo não encontrado"));
    }

    public void excluirVeiculo(String placa) {
        veiculoRepository.deleteById(placa);
    }

    public double calcularConsumoMedio(String placa) {
        @SuppressWarnings("unused")
        VeiculoModel veiculo = buscarVeiculoPorPlaca(placa);
        List<AbastecimentoModel> abastecimentos = abastecimentoRepository
                .findByVeiculoPlacaOrderByDataAbastecimento(placa);

        if (abastecimentos.isEmpty()) {
            throw new IllegalArgumentException("Nenhum abastecimento encontrado para o veículo com a placa " + placa);
        }

        double totalCombustivel = 0;
        double totalDistancia = 0;

        double ultimaQuilometragem = 0;

        for (AbastecimentoModel abastecimento : abastecimentos) {
            if (ultimaQuilometragem != 0) {
                double distancia = abastecimento.getQuilometragem() - ultimaQuilometragem;
                totalDistancia += distancia;
                totalCombustivel += abastecimento.getQuantidadeCombustivel();
            }
            ultimaQuilometragem = abastecimento.getQuilometragem();
        }

        if (totalDistancia == 0) {
            throw new IllegalStateException("Não é possível calcular o consumo médio sem variação na quilometragem.");
        }

        return totalDistancia / totalCombustivel;
    }

    public Map<String, Double> gerarRelatorioGeralPorCategoria(String placa) {
        VeiculoModel veiculo = veiculoRepository.findById(placa)
                .orElseThrow(() -> new VeiculoNaoEncontradoException("Veículo não encontrado com a placa: " + placa));

        Map<String, Double> relatorio = new HashMap<>();

        // Calcula o total de despesas por categoria
        List<DespesasModel> despesas = veiculo.getDespesas();
        for (DespesasModel despesa : despesas) {
            String categoria = despesa.getTipo();
            if (categoria != null) {
                double valor = despesa.getValor();
                relatorio.put(categoria, relatorio.getOrDefault(categoria, 0.0) + valor);
            }
        }

        // Calcula o total de abastecimentos
        List<AbastecimentoModel> abastecimentos = veiculo.getAbastecimentos();
        double totalAbastecimentos = 0;
        for (AbastecimentoModel abastecimento : abastecimentos) {
            totalAbastecimentos += abastecimento.getValor();
        }
        relatorio.put("Abastecimentos", totalAbastecimentos);

        return relatorio;
    }

}
