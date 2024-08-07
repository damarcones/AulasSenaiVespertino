package model;

import java.time.LocalDate;

public class Despesa {
    private String tipo;
    private double valor;
    private String descricao;
    private LocalDate data;

    public Despesa(String tipo, double valor, String descricao, LocalDate data, String descricao2) {
        this.tipo = tipo.trim().toLowerCase();
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }
}
