package com.turistando.sistematuristando.Enum;

public enum TipoCombustiveis {

    GASOLINA("Gasolina"),
    ALCOOL("Álcool"),
    DIESEL("Diesel"),
    GNV("Gnv");

    private final String tipoCombsutiveis;

    private TipoCombustiveis(String tipoCombsutiveis) {
        this.tipoCombsutiveis = tipoCombsutiveis;
    }

    public String getTipoCombsutiveis() {
        return tipoCombsutiveis;
    }

}
