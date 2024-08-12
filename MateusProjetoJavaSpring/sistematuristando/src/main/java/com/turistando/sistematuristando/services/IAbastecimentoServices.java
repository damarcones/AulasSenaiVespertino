package com.turistando.sistematuristando.services;

import java.util.List;

import com.turistando.sistematuristando.model.Abastecimentos;


public interface IAbastecimentoServices {

    List<Abastecimentos> listar();
    Abastecimentos registrar(Abastecimentos abastecimento);
    Abastecimentos atualizar(Abastecimentos abastecimento);
    void deletar(int id);
    Abastecimentos listarPorId(int id);

}
