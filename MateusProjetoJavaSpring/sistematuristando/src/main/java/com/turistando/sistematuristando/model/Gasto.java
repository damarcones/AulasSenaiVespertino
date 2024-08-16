package com.turistando.sistematuristando.model;

import java.time.LocalDate;

import com.turistando.sistematuristando.Enum.TipoDespesa;

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
import jakarta.validation.constraints.Min;


@Entity
public class Gasto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Veiculo")
    private Veiculo veiculo;

    @Enumerated(EnumType.STRING)
    @Column(name= "Tipo", nullable=false)
    private TipoDespesa tipo;

    @Column(name= "Data", nullable=false)
    private LocalDate data;

    @Column(name= "Valor", nullable=false)
    @Min(value = 1, message = "O valor deve ser maior ou igual a 1")
    private double  valor;

    @Column(name= "Descricao", nullable=false)
    private String  descricao;

    //Metodos Getters and Setters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoDespesa getTipo() {
        return tipo;
    }

    public void setTipo(TipoDespesa tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    
}
