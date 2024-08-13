package com.yrontrabalhospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yrontrabalhospringboot.model.VeiculoModel;



public interface VeiculoRepository extends JpaRepository<VeiculoModel, String>{
    
}
