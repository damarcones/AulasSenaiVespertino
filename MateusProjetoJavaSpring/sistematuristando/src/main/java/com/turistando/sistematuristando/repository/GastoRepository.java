package com.turistando.sistematuristando.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turistando.sistematuristando.model.GastoModel;

@Repository
public interface GastoRepository extends JpaRepository<GastoModel, Integer>{

    List<GastoModel> findByVeiculoPlaca(String placa);
}
