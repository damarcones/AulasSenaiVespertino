package com.gasto;

import java.time.LocalDate;

public class Gasto {

    private static int proximoId = 1;
    private int id;
    private LocalDate data;
    private String placa;
    private String tipoGasto;
    private String descricaoGasto;
    private double  valorGasto;
    
    //Metoodo construtor
    public Gasto(LocalDate data, String placa, String tipoGasto, String descricaoGasto, double valorGasto) {
        this.id = proximoId++; //auto incrementa o id
        this.data = data;
        this.placa = placa;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String veiculo) {
        this.placa = veiculo;
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

    
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return  String.format(
                "<html>ID: %s" + 
                " Data: %s"+    
                " Placa: %s"+ 
                " Tipo Gasto: %s"  +
                " Descrição Gasto: %s"+ 
                " Valor Gasto: R$ %.2f<br></html>",
                id, data, placa, tipoGasto,descricaoGasto,valorGasto
            );
        }  

    
}
