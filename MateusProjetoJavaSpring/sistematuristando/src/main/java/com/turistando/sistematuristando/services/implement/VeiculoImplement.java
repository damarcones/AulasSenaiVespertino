package com.turistando.sistematuristando.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistando.sistematuristando.model.Veiculo;
import com.turistando.sistematuristando.repository.IVeiculoRepository;
import com.turistando.sistematuristando.services.IVeiculoServices;


@Service
public class VeiculoImplement implements IVeiculoServices{

    @Autowired
    IVeiculoRepository repoVeiculo;

    @Override
    public List<Veiculo> listar() {
        return repoVeiculo.findAll();
    }

    @Override
    public Veiculo registrar(Veiculo veiculo) {
       return repoVeiculo.save(veiculo);
    }

    @Override
    public Veiculo atualizar(Veiculo veiculo) {
        return repoVeiculo.save(veiculo);
    }

    @Override
    public void deletar(int id) {
        repoVeiculo.deleteById(id);
    }

    @Override
    public Veiculo listarPorId(int id) {
        return repoVeiculo.findById(id).orElse(null);
    }

}
