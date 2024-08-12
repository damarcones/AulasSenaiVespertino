package com.turistando.sistematuristando.model;

import com.turistando.sistematuristando.Enum.CombustiveisAceitos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Veiculos")
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVeiculo;

    @Column(name= "Marca", length=100, nullable=false)
    private String marca;

    @Column(name= "Modelo", length=100, nullable=false)
    private String modelo;

    @Column(name= "AnoFabricacao", nullable=false)
    private Integer anoFabricacao;

    @Column(name= "AnoModelo", nullable=false)
    private Integer anoModelo;

    @Column(name= "Motorizacao",  nullable=false)
    private Integer motorizacao;

    @Column(name= "CapacidadeTanque", nullable=false)
    private double capacidadeTanque;

    @Column(name= "CombustiveisAceitos", nullable=false)
    @Enumerated(EnumType.STRING)
    private CombustiveisAceitos combustiveisAceitos; 

    @Column(name= "Cor", nullable=false)
    private String cor;

    @Column(name= "Placa", length=7, nullable=false)
    private String placa;

    @Column(name= "Renavam", length=11, nullable=false)
    private int renavam;


    
}
