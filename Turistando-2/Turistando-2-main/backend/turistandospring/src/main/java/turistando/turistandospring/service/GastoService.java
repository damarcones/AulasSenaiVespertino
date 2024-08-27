package turistando.turistandospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.turistandospring.Enum.TipoGasto;
import turistando.turistandospring.Exception.Excecao;
import turistando.turistandospring.model.GastoModel;

import turistando.turistandospring.repository.GastoRepository;


import java.util.List;


@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    // Criar um novo gasto
    public GastoModel createGasto(GastoModel gastoModel) {
        return gastoRepository.save(gastoModel);
    }

    // Obter todos os gastos
    public List<GastoModel> getAllGastos() {
        return gastoRepository.findAll();
    }

    // Obter um gasto por ID
    public GastoModel getGastoById(Long id) throws Excecao {
        return gastoRepository.findById(id)
                .orElseThrow(() -> new Excecao("Gasto não encontrado com o ID: " + id));
    }

    // Atualizar um gasto existente
    public GastoModel updateGasto(Long id, GastoModel updatedGasto) throws Excecao {
        if (gastoRepository.existsById(id)) {
            updatedGasto.setId(id);
            return gastoRepository.save(updatedGasto);
        }
        throw new Excecao("Gasto não encontrado com o ID: " + id);
    }

    // Deletar um gasto por ID
    public boolean deleteGasto(Long id) {
        if (gastoRepository.existsById(id)) {
            gastoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<GastoModel> getGastosPorPlaca(String placa) {
        return gastoRepository.findByPlaca(placa);
    }

    public List<GastoModel> getGastosPorCategoriaEPlaca(String placa, TipoGasto categoria) {
        return gastoRepository.findByCategoriaAndPlaca(categoria, placa);
    }
}
