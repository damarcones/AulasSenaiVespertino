package com.turistando.sistematuristando.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turistando.sistematuristando.model.VeiculoModel;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, String>{


    Optional<VeiculoModel> findByPlaca(String placa);

    Optional<VeiculoModel> findByRenavam(Long renavam);
}
