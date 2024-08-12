package com.turistando.sistematuristando.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistando.sistematuristando.model.Veiculos;
import com.turistando.sistematuristando.repository.IVeiculoRepository;
import com.turistando.sistematuristando.services.IVeiculoServices;


@Service
public class VeiculoImplement implements IVeiculoServices{

    @Autowired
    IVeiculoRepository repoVeiculo;

    @Override
    public List<Veiculos> listar() {
        return repoVeiculo.findAll();
    }

    @Override
    public Veiculos registrar(Veiculos veiculo) {
       return repoVeiculo.save(veiculo);
    }

    @Override
    public Veiculos atualizar(Veiculos veiculo) {
        return repoVeiculo.save(veiculo);
    }

    @Override
    public void deletar(int id) {
        repoVeiculo.deleteById(id);
    }

    @Override
    public Veiculos listarPorId(int id) {
        return repoVeiculo.findById(id).orElse(null);
    }

}
