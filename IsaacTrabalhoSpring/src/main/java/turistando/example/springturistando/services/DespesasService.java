package turistando.example.springturistando.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.example.springturistando.model.DespesasModel;
import turistando.example.springturistando.model.VeiculoModel;
import turistando.example.springturistando.repositories.DespesasRepository;

@Service
public class DespesasService {

    @Autowired
    private DespesasRepository despesasRepository;
    @Autowired
    private VeiculoService veiculoService;

    public DespesasModel salvarDespesa(String placa, DespesasModel despesa) {
        VeiculoModel veiculo = veiculoService.buscarVeiculoPorPlaca(placa);
        despesa.setVeiculo(veiculo);
        return despesasRepository.save(despesa);
    }

    public List<DespesasModel> listarDespesasPorVeiculo(String placa) {
        return despesasRepository.findByVeiculoPlacaOrderByDataDespesa(placa);
    }

    public void deletarDespesa(Long id) {
        despesasRepository.deleteById(id);
    }
}
