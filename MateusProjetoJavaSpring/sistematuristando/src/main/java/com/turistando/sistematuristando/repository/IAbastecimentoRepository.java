package com.turistando.sistematuristando.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turistando.sistematuristando.model.AbastecimentoModel;

@Repository
public interface IAbastecimentoRepository extends JpaRepository<AbastecimentoModel, Integer>{

    List<AbastecimentoModel> findByVeiculoPlaca(String placa);
    
}
