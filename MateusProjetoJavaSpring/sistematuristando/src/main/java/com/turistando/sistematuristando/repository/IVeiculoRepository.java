package com.turistando.sistematuristando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turistando.sistematuristando.model.Veiculos;

@Repository
public interface IVeiculoRepository extends JpaRepository<Veiculos, Integer>{

}