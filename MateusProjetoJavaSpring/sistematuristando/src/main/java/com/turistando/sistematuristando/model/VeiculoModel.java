package com.turistando.sistematuristando.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.turistando.sistematuristando.Enum.CombustiveisAceitos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="Veiculos")
public class VeiculoModel {

    @Id
    private String placa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "veiculo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<GastoModel> gasto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<AbastecimentoModel> abastecimento;

    @Column(name="Marca", length=100, nullable=false)
    private String marca;

    @Column(name="Modelo", length=100, nullable=false)
    private String modelo;

    @Column(name="AnoFabricacao", nullable=false)
    @Min(value =1900, message = "O valor de ano de fabricação deve ser maior ou igual a 1900")
    private int anoFabricacao;

    @Column(name="AnoModelo", nullable=false )
    @Min(value = 1900, message = "O valor de ano modelo deve ser maior ou igual a 1900")
    private int anoModelo;

    @Column(name="Motorizacao",  nullable=false)
    private double motorizacao;

    @Column(name="CapacidadeTanque", nullable=false)
    @Min(value = 1, message = "O valor de capacidadeTanque deve ser maior ou igual a 1")
    private double capacidadeTanque;

    @Column(name= "CombustiveisAceitos", nullable=false)
    @Enumerated(EnumType.STRING)
    private CombustiveisAceitos combustiveisAceitos; 

    @Column(name= "Cor", nullable=false)
    private String cor;

    @Column(name= "Renavam", nullable=false)
    @Min(value = 1, message = "O valor de renavam deve ser maior  a 1")
    private long renavam;


   //Metodos Getters and Setters;
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


    
    public double getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(double motorizacao) {
        this.motorizacao = motorizacao;
    }

    public List<GastoModel> getGasto() {
        return gasto;
    }

    public void setGasto(List<GastoModel> gasto) {
        this.gasto = gasto;
    }

    
    

    
    
}
