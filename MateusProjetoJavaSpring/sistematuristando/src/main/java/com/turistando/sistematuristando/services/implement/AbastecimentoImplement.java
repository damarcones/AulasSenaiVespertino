package com.turistando.sistematuristando.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistando.sistematuristando.model.Abastecimento;
import com.turistando.sistematuristando.repository.IAbastecimentoRepository;
import com.turistando.sistematuristando.services.IAbastecimentoServices;

@Service
public class AbastecimentoImplement implements IAbastecimentoServices{

    @Autowired
    IAbastecimentoRepository repoAbast;

    @Override
    public List<Abastecimento> listar() {
        return repoAbast.findAll();
    }

    @Override
    public Abastecimento registrar(Abastecimento abastecimento) {
       return repoAbast.save(abastecimento);
    }

    @Override
    public Abastecimento atualizar(Abastecimento abastecimento) {
        return repoAbast.save(abastecimento);
    }

    @Override
    public void deletar(int id) {
        repoAbast.deleteById(id);
    }

    @Override
    public Abastecimento listarPorId(int id) {
        return repoAbast.findById(id).orElse(null);
    }

    
}
