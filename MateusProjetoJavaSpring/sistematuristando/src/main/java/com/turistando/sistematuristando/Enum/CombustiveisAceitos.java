package com.turistando.sistematuristando.Enum;

public enum CombustiveisAceitos {

    GASOLINA("Gasolina"),
    ALCOOL("Álcool"),
    FLEX("Flex"),
    DIESEL("Diesel"),
    GNV("GNV");

    private final String combustiveisAceitos;

    CombustiveisAceitos(String combustiveisAceitos) {
        this.combustiveisAceitos = combustiveisAceitos;
    }

    public String getCombustiveisAceitos() {
        return combustiveisAceitos;
    }
}

