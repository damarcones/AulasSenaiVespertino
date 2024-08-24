package turistando.example.springturistando.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.example.springturistando.exception.VeiculoNaoEncontradoException;
import turistando.example.springturistando.model.VeiculoModel;
import turistando.example.springturistando.repositories.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

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
}
