package com.abastecimento;

import java.time.LocalDate;

public class Abastecimento {
    private static int proximoId = 1;
    private int id;
    private LocalDate data;
    private String placa;
    private double quilometragem;
    private String tipoCombustivel;
    private double quantidadeCombustivel;
    private double valorTotal;
    
    //Método Construtor
    public Abastecimento(LocalDate data, String placa, double quilometragem, String tipoCombustivel, double quantidadeCombustivel, double valorTotal) 
        {
            this.id = proximoId++; //auto incrementa o id
            this.data = data;
            this.placa = placa;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String veiculo) {
        this.placa = veiculo;
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
                " Quilometragem: %.1f" + 
                " TipoCombustivel: %s" + 
                " Quantidade Combustivel(litros): %.2f" + 
                " Valor Total: R$ %.2f<br></html>",
                id, data, placa, quilometragem, tipoCombustivel, quantidadeCombustivel, valorTotal
            );
        }      
}
