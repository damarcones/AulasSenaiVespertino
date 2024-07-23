package Model;

import java.time.LocalDate;

public class Gasto {
    private String categoria;
    private String descricao;
    private double valor;
    private LocalDate data;


    public Gasto(String categoria, String descricao, double valor, LocalDate data) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    
}

