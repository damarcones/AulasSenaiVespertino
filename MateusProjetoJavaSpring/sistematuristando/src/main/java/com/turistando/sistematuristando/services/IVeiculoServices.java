package com.turistando.sistematuristando.services;

import java.util.List;

import com.turistando.sistematuristando.model.Veiculo;


public interface IVeiculoServices {

    List<Veiculo> listar();
    Veiculo registrar(Veiculo veiculo);
    Veiculo atualizar(Veiculo veiculo);
    void deletar(int id);
    Veiculo listarPorId(int id);
}
