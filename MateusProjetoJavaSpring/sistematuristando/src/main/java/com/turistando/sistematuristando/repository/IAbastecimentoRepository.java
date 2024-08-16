package com.turistando.sistematuristando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turistando.sistematuristando.model.AbastecimentoModel;

@Repository
public interface IAbastecimentoRepository extends JpaRepository<AbastecimentoModel, Integer>{
    
}
