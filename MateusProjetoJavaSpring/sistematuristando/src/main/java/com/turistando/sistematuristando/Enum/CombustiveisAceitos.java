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

    // método accepts dentro da enum faz a verificação de compatibilidade de combustível;
    public boolean accepts(TipoCombustiveis tipoCombustivel) {
        if (this == FLEX) {
            return tipoCombustivel == TipoCombustiveis.GASOLINA || tipoCombustivel == TipoCombustiveis.ALCOOL;
        }
        return this.name().equals(tipoCombustivel.name());
    }
}

