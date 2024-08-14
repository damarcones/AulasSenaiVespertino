package com.turistando.sistematuristando.services;

import java.util.List;

import com.turistando.sistematuristando.model.Abastecimento;


public interface IAbastecimentoServices {

    List<Abastecimento> listar();
    Abastecimento registrar(Abastecimento abastecimento);
    Abastecimento atualizar(Abastecimento abastecimento);
    void deletar(int id);
    Abastecimento listarPorId(int id);

}
