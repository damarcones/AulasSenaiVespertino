package com.turistando.sistematuristando.model;

import java.time.LocalDate;

import com.turistando.sistematuristando.Enum.TipoDespesa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Despesa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name= "TipoDespesa", nullable=false)
    private TipoDespesa tipo;

    @Column(name= "DataDespesa", nullable=false)
    private LocalDate data;

    @Column(name= "ValorDespesa", nullable=false)
    private double  valor;

    public Despesa(int id, TipoDespesa tipo, LocalDate data, double valor) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

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


    
}
