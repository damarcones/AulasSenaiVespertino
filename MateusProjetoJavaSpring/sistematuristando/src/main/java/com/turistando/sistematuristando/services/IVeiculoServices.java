package com.turistando.sistematuristando.services;

import java.util.List;

import com.turistando.sistematuristando.model.Veiculos;


public interface IVeiculoServices {

    List<Veiculos> listar();
    Veiculos registrar(Veiculos veiculo);
    Veiculos atualizar(Veiculos veiculo);
    void deletar(int id);
    Veiculos listarPorId(int id);
}
