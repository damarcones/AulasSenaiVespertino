package com.turistando.sistematuristando.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistando.sistematuristando.model.VeiculoModel;
import com.turistando.sistematuristando.repository.IVeiculoRepository;


@Service
public class VeiculoService{

    @Autowired
    public IVeiculoRepository repoVeiculo;

    
    public List<VeiculoModel> listar() {
        return repoVeiculo.findAll();
    }

    
    public VeiculoModel registrar(VeiculoModel veiculo) {
       return repoVeiculo.save(veiculo);
    }

    
    public VeiculoModel atualizar(VeiculoModel veiculo) {
        return repoVeiculo.save(veiculo);
    }

    
    public void deletar(String id) {
        repoVeiculo.deleteById(id);
    }

   
    public VeiculoModel listarPorId(String id) {
        return repoVeiculo.findById(id).orElse(null);
    }

}
