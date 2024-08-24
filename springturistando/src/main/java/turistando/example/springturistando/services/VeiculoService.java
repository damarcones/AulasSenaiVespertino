package turistando.example.springturistando.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.example.springturistando.exception.VeiculoNaoEncontradoException;
import turistando.example.springturistando.model.AbastecimentoModel;
import turistando.example.springturistando.model.VeiculoModel;
import turistando.example.springturistando.repositories.AbastecimentoRepository;
import turistando.example.springturistando.repositories.VeiculoRepository;

import java.util.List;

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
        List<AbastecimentoModel> abastecimentos = abastecimentoRepository.findByVeiculoPlacaOrderByDataAbastecimento(placa);

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
}
