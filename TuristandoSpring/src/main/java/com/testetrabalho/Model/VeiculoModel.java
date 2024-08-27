package com.testetrabalho.Model;


import java.util.List;

import com.testetrabalho.Enum.CombustiveisEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Veiculo")
public class VeiculoModel {

 @Id
 @Column (name = "placa")
 private String placa;

@OneToMany(fetch= FetchType.LAZY,mappedBy="veiculo",cascade = CascadeType.ALL)
private List<GastoModel> gasto;

@OneToMany(fetch= FetchType.LAZY,mappedBy="veiculo",cascade = CascadeType.ALL)
private List<AbastecimentoModel> abastecimento; 


 @Column(name = "Marca", nullable=false)
 
 private String marca;

 @Column(name = "Modelo", nullable=false)
 private String modelo;
 
 @Column (name = "Ano Modelo",nullable=false)

 private int anoModelo;

 @Column (name = "Ano Fabricacao", nullable=false)
 private int anoFabricacao;

 @Column(name = "Cor",nullable=false)
 private String cor;

 @Column (name = "Renavam",nullable=false)
 private long RENAVAM;

 @Column (name = "Motorizacao",nullable=false)
 
 private double motorizacao;

@Column (name = "Capacidade do tanque ",nullable=false)

 private double capacidadeTanque;

 @Column (name = "Combustiveis ")
  @Enumerated(EnumType.STRING)
 private CombustiveisEnum combustivel;


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

public long getRENAVAM() {
    return RENAVAM;
}

public void setRENAVAM(long rENAVAM) {
    RENAVAM = rENAVAM;
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

public CombustiveisEnum getCombustivel() {
    return combustivel;
}

public void setCombustivel(CombustiveisEnum combustivel) {
    this.combustivel = combustivel;
}



 



}