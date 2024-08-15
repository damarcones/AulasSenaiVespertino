package com.yrontrabalhospringboot.Model;

import com.yrontrabalhospringboot.Enums.CombustivelEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VeiculoModel {

    @Id
    @Column( nullable = false )
    private String placa;
    
    @Column( nullable = false )
    private String marca;

    @Column( nullable = false)
    private String modelo;

    @Column( nullable = false)
    private int anoModelo;

    @Column ( nullable =  false)
    private int anoFabricacao;

    @Column ( nullable = false)
    private String cor;

    @GeneratedValue ( strategy = GenerationType.AUTO)
    private long renavam;

    @Column ( nullable = false)
    private double motorizacao; 

    @Column ( nullable = false)
    private double capacidadeTanque;
    //@Enumerated(EnumType.STRING)

    
    private CombustivelEnum combustivel;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() { 
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public long getRenavam() {
        return renavam;
    }

    public void setRenavam(long renavam) {
        this.renavam = renavam;
    }

    public double getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(double motorizacao) {
        this.motorizacao = motorizacao;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public CombustivelEnum getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(CombustivelEnum combustivel) {
        this.combustivel = combustivel;
    }

    
}
