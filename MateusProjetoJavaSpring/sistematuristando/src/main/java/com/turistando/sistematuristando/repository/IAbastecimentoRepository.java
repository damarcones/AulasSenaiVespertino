package com.turistando.sistematuristando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turistando.sistematuristando.model.Abastecimentos;

@Repository
public interface IAbastecimentoRepository extends JpaRepository<Abastecimentos, Integer>{
    
}
