package com.turistando.sistematuristando.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistando.sistematuristando.model.AbastecimentoModel;
import com.turistando.sistematuristando.repository.IAbastecimentoRepository;

@Service
public class AbastecimentoService{

    @Autowired
    public IAbastecimentoRepository repoAbast;

    
    public List<AbastecimentoModel> listar() {
        return repoAbast.findAll();
    }

    
    public AbastecimentoModel registrar(AbastecimentoModel abastecimento) {
       return repoAbast.save(abastecimento);
    }

    
    public AbastecimentoModel atualizar(AbastecimentoModel abastecimento) {
        return repoAbast.save(abastecimento);
    }

    
    public void deletar(int id) {
        repoAbast.deleteById(id);
    }

    
    public AbastecimentoModel listarPorId(int id) {
        return repoAbast.findById(id).orElse(null);
    }

    
}
