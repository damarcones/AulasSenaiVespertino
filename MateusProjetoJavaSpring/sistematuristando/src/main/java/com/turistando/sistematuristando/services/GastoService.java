package com.turistando.sistematuristando.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistando.sistematuristando.model.GastoModel;
import com.turistando.sistematuristando.model.VeiculoModel;
import com.turistando.sistematuristando.repository.IGastoRepository;

@Service
public class GastoService {

    @Autowired
    public IGastoRepository repoGasto;

    public List<GastoModel> listar() {
        return repoGasto.findAll();
    }

    
    public GastoModel registrar(GastoModel veiculo) {
       return repoGasto.save(veiculo);
    }
    
    
    public GastoModel atualizar(GastoModel veiculo) {
        return repoGasto.save(veiculo);
    }

    
    public void deletar(int id) {
        repoGasto.deleteById(id);
    }

   
    public GastoModel listarPorId(int id) {
        return repoGasto.findById(id).orElse(null);
    }

}
