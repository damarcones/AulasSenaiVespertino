package com.turistando.sistematuristando.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistando.sistematuristando.model.Abastecimentos;
import com.turistando.sistematuristando.repository.IAbastecimentoRepository;
import com.turistando.sistematuristando.services.IAbastecimentoServices;

@Service
public class AbastecimentoImplement implements IAbastecimentoServices{

    @Autowired
    IAbastecimentoRepository repoAbast;

    @Override
    public List<Abastecimentos> listar() {
        return repoAbast.findAll();
    }

    @Override
    public Abastecimentos registrar(Abastecimentos abastecimento) {
       return repoAbast.save(abastecimento);
    }

    @Override
    public Abastecimentos atualizar(Abastecimentos abastecimento) {
        return repoAbast.save(abastecimento);
    }

    @Override
    public void deletar(int id) {
        repoAbast.deleteById(id);
    }

    @Override
    public Abastecimentos listarPorId(int id) {
        return repoAbast.findById(id).orElse(null);
    }

    
}
