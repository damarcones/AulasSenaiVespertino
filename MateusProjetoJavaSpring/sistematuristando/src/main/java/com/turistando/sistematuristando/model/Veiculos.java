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
    private long idVeiculo;

    @Column(name= "Marca", length=100, nullable=false)
    private String marca;

    @Column(name= "Modelo", length=100, nullable=false)
    private String modelo;

    @Column(name= "AnoFabricacao", nullable=false)
    private int anoFabricacao;

    @Column(name= "AnoModelo", nullable=false)
    private int anoModelo;

    @Column(name= "Motorizacao",  nullable=false)
    private int motorizacao;

    @Column(name= "CapacidadeTanque", nullable=false)
    private double capacidadeTanque;

    @Column(name= "CombustiveisAceitos", nullable=false)
    @Enumerated(EnumType.STRING)
    private CombustiveisAceitos combustiveisAceitos; 

    @Column(name= "Cor", nullable=false)
    private String cor;

    @Column(name= "Placa", nullable=false)
    private String placa;

    @Column(name= "Renavam", nullable=false)
    private long renavam;

    public long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(int motorizacao) {
        this.motorizacao = motorizacao;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public CombustiveisAceitos getCombustiveisAceitos() {
        return combustiveisAceitos;
    }

    public void setCombustiveisAceitos(CombustiveisAceitos combustiveisAceitos) {
        this.combustiveisAceitos = combustiveisAceitos;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public long getRenavam() {
        return renavam;
    }

    public void setRenavam(long renavam) {
        this.renavam = renavam;
    } 

    
    
}
