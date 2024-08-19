package com.turistando.sistematuristando.model;

import java.time.LocalDate;

import com.turistando.sistematuristando.Enum.TipoCombustiveis;

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
import jakarta.validation.constraints.Min;

@Entity
@Table(name="Abastecimentos")
public class AbastecimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAbastecimento;

    @ManyToOne(cascade=CascadeType.PERSIST) 
    @JoinColumn(name="Veiculo", referencedColumnName="placa",nullable=false) 
    private VeiculoModel veiculo;

    @Column(name="Data", nullable=false)
    private LocalDate data;

    @Column(name="Quilometragem", nullable=false)
    @Min(value = 1, message = "O valor deve ser maior ou igual a 1")
    private double quilometragem;
    
    @Column(name="TipoCombustivel", nullable=false)
    @Enumerated(EnumType.STRING)
    private TipoCombustiveis tipoCombustivel; 
    
    @Column(name="QuantidadeCombustivel", nullable=false)
    @Min(value = 1, message = "O valor deve ser maior ou igual a 1")
    private double quantidadeCombustivel;

    @Column(name="ValorTotal", nullable=false)
    @Min(value = 1, message = "O valor deve ser maior ou igual a 1")
    private double valorTotal;



    //get e set;

    public Integer getIdAbastecimento() {
        return idAbastecimento;
    }

    public void setIdAbastecimento(Integer idAbastecimento) {
        this.idAbastecimento = idAbastecimento;
    }

    public VeiculoModel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }

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

    public TipoCombustiveis getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustiveis tipoCombustivel) {
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
