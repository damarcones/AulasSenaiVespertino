package com.turistando.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turistando.app.model.VeiculoModel;


public interface VeiculoRepository extends JpaRepository<VeiculoModel, String>{

}
