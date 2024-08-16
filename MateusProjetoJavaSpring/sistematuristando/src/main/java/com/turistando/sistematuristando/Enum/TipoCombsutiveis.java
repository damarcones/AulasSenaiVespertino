package com.turistando.sistematuristando.Enum;

public enum TipoCombsutiveis {

    GASOLINA("Gasolina"),
    ALCOOL("Álcool"),
    DIESEL("diesel"),
    GNV("Gnv");

    private final String tipoCombsutiveis;

    private TipoCombsutiveis(String tipoCombsutiveis) {
        this.tipoCombsutiveis = tipoCombsutiveis;
    }

    public String getTipoCombsutiveis() {
        return tipoCombsutiveis;
    }

    
}
