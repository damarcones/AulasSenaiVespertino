package com.turistando.sistematuristando.Enum;

public enum TipoCombsutiveis {

    GASOLINA("Gasolina"),
    ALCOOL("Álcool"),
    FLEX("Flex"),
    DIESEL("diesel"),
    GNV("Gnv");

    private String tipoCombsutiveis;

    private TipoCombsutiveis(String tipoCombsutiveis) {
        this.tipoCombsutiveis = tipoCombsutiveis;
    }
}
