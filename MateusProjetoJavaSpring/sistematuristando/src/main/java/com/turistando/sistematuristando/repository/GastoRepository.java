package com.turistando.sistematuristando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turistando.sistematuristando.model.GastoModel;

@Repository
public interface GastoRepository extends JpaRepository<GastoModel, Integer>{

}