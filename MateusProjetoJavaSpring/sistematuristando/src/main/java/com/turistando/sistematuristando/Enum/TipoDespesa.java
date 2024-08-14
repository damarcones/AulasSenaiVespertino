package com.turistando.sistematuristando.Enum;

public enum TipoDespesa {
    MULTA("MULTA"),
    IMPOSTO("IMPOSTO"),
    MANUTENCAO("MANUTENÇÂO"),
    OUTROS("OUTROS");
    
    public String tipoDespesa;

    TipoDespesa(String tipoDespesa){
        this.tipoDespesa = tipoDespesa;
    }
    
}
