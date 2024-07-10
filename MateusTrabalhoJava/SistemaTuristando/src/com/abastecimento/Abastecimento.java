package com.abastecimento;

import com.veiculo.Veiculo;

public class Abastecimento {
    private static int proximoId = 1;
    private int id;
    private  Veiculo veiculo;
    private double quilometragem;
    private String tipoCombustivel;
    private double quantidadeCombustivel;
    private double valorTotal;
    
    //Método Construtor
    public Abastecimento(int id, Veiculo veiculo, double quilometragem, String tipoCombustivel,
            double quantidadeCombustivel, double valorTotal) 
        {
            this.id = proximoId++; //auto incrementa o id
            this.veiculo = veiculo;
            this.quilometragem = quilometragem;
            this.tipoCombustivel = tipoCombustivel;
            this.quantidadeCombustivel = quantidadeCombustivel;
            this.valorTotal = valorTotal;
        }
      
        //Métodos Getters e Setters
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

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
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
