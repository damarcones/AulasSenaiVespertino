package com.turistando.turistando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turistando.turistando.model.VeiculoModel;



public interface VeiculoRepository extends JpaRepository<VeiculoModel, String>{
    
}
