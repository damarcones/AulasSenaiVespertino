package turistando.turistandospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.turistandospring.Exception.Excecao;
import turistando.turistandospring.model.VeiculoModel;
import turistando.turistandospring.repository.VeiculoRepository;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    // Criar um novo veículo
    public VeiculoModel createVeiculo(VeiculoModel veiculoModel) {
        return veiculoRepository.save(veiculoModel);
    }

    // Obter todos os veículos
    public List<VeiculoModel> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    // Obter um veículo por placa
    public VeiculoModel getVeiculoByPlaca(String placa) throws Excecao {
        return veiculoRepository.findById(placa)
                .orElseThrow(() -> new Excecao("Veículo não encontrado com a placa: " + placa));
    }

    // Atualizar um veículo existente
    public VeiculoModel updateVeiculo(String placa, VeiculoModel updatedVeiculo) throws Excecao {
        if (veiculoRepository.existsById(placa)) {
            updatedVeiculo.setPlaca(placa);
            return veiculoRepository.save(updatedVeiculo);
        }
        throw new Excecao("Veículo não encontrado com a placa: " + placa);
    }

    // Deletar um veículo por placa
    public boolean deleteVeiculo(String placa) {
        if (veiculoRepository.existsById(placa)) {
            veiculoRepository.deleteById(placa);
            return true;
        }
        return false;
    }
}

