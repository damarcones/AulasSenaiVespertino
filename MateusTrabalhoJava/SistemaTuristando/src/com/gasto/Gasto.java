package com.gasto;

import com.veiculo.Veiculo;

public class Gasto {

    private static int proximoId = 1;
    private int id;
    private  Veiculo veiculo;
    private  String tipoGasto;
    private String descricaoGasto;
    private double  valorGasto;
    
    
    //Metoodo construtor
    public Gasto( Veiculo veiculo, String tipoGasto, String descricaoGasto, double valorGasto) {
        this.id = proximoId++; //auto incrementa o id
        this.veiculo = veiculo;
        this.tipoGasto = tipoGasto;
        this.descricaoGasto = descricaoGasto;
        this.valorGasto = valorGasto;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Veiculo getVeiculo() {
        return veiculo;
    }


    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }


    public String getTipoGasto() {
        return tipoGasto;
    }


    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }


    public String getDescricaoGasto() {
        return descricaoGasto;
    }


    public void setDescricaoGasto(String descricaoGasto) {
        this.descricaoGasto = descricaoGasto;
    }


    public double getValorGasto() {
        return valorGasto;
    }


    public void setValorGasto(double  valorGasto) {
        this.valorGasto = valorGasto;
    }


    @Override
    public String toString() {
        return "Id: " + getId() + 
               "\nVeiculo: " + getVeiculo().getModelo() +
               "\nPlaca: " +getVeiculo().getPlaca() + 
               "\nTipo de Gasto: " + getTipoGasto() + 
               "\nDescrição Gasto: " + getDescricaoGasto() + 
               "\nValor Gasto R$" + getValorGasto();
    }

    
}
