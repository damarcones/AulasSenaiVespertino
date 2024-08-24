package turistando.example.springturistando.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.example.springturistando.model.AbastecimentoModel;
import turistando.example.springturistando.model.VeiculoModel;
import turistando.example.springturistando.repositories.AbastecimentoRepository;
import turistando.example.springturistando.repositories.VeiculoRepository;

@Service
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public AbastecimentoModel salvarAbastecimento(String placa, AbastecimentoModel abastecimento) {
        VeiculoModel veiculo = veiculoRepository.findById(placa)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        abastecimento.setVeiculo(veiculo);
        return abastecimentoRepository.save(abastecimento);
    }

    public List<AbastecimentoModel> listarAbastecimentosPorVeiculo(String placa) {
        return abastecimentoRepository.findByVeiculoPlacaOrderByDataAbastecimento(placa);
    }
}
