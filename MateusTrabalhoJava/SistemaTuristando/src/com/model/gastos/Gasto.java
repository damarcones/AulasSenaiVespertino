package com.model.gastos;

import java.time.LocalDate;

public class Gasto {

    private static int proximoId = 1;
    private int id;
    private String placa;
    private String tipo;
    private LocalDate data;
    private double  valor;
    
    public Gasto(String placa, String tipo, LocalDate data, double valor) {
        this.id = proximoId++; //auto incrementa o id
        this.placa = placa;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    public static int getProximoId() {
        return proximoId;
    }

    public static void setProximoId(int proximoId) {
        Gasto.proximoId = proximoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
