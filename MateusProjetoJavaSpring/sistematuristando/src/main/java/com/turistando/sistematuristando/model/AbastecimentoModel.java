package com.turistando.sistematuristando.model;

import java.time.LocalDate;

import com.turistando.sistematuristando.Enum.TipoCombsutiveis;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Abastecimentos")
public class AbastecimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAbastecimento;

    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="Veiculo", referencedColumnName="placa",nullable=false) 
    private VeiculoModel veiculo;

    @Column(name="Data", nullable=false)
    private LocalDate data;

    @Column(name="Quilometragem", nullable=false)
    private double quilometragem;
    
    @Column(name="TipoCombustivel", nullable=false)
    @Enumerated(EnumType.STRING)
    private TipoCombsutiveis tipoCombustivel; 
    
    @Column(name="QuantidadeCombustivel", nullable=false)
    private double quantidadeCombustivel;

    @Column(name="ValorTotal", nullable=false)
    private double valorTotal;



    //get e set;

    public Integer getIdAbastecimento() {
        return idAbastecimento;
    }

    public void setIdAbastecimento(Integer idAbastecimento) {
        this.idAbastecimento = idAbastecimento;
    }

    // public VeiculoModel getVeiculo() {
    //     return veiculo;
    // }

    // public void setVeiculo(VeiculoModel veiculo) {
    //     this.veiculo = veiculo;
    // }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public TipoCombsutiveis getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombsutiveis tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public double getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }

    public void setQuantidadeCombustivel(double quantidadeCombustivel) {
        this.quantidadeCombustivel = quantidadeCombustivel;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    

    

}
