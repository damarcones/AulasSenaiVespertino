package com.yrontrabalhospringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yrontrabalhospringboot.Model.VeiculoModel;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, String>{
    
}
