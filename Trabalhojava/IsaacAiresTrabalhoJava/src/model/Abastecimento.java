package model;

import java.time.LocalDate;

public class Abastecimento {
    private double valor;
    private double quantidadeCombustivel;
    private int quilometragemAtual;
    private String tipoCombustivel;
    private LocalDate data; 

    public Abastecimento(double valor, double quantidadeCombustivel, int quilometragemAtual, String tipoCombustivel, LocalDate data) {
        this.valor = valor;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.quilometragemAtual = quilometragemAtual;
        this.tipoCombustivel = tipoCombustivel;
        this.data = data;  
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }

    public void setQuantidadeCombustivel(double quantidadeCombustivel) {
        this.quantidadeCombustivel = quantidadeCombustivel;
    }

    public int getQuilometragemAtual() {
        return quilometragemAtual;
    }

    public void setQuilometragemAtual(int quilometragemAtual) {
        this.quilometragemAtual = quilometragemAtual;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
