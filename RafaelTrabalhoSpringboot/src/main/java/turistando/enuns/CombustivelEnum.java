package turistando.enuns;

public enum CombustivelEnum {
    Gasolina,
    Alcool,
    Diesel,
    GNV,
    Flex;
}

/*
 *    
    public boolean accepts(TipoCombustiveis tipoCombustivel) {
        if (this == Flex) {
            return tipoCombustivel == TipoCombustiveis.Alcool; || tipoCombustivel == TipoCombustiveis.Gasolina 
        }
        return this.name().equals(tipoCombustivel.name());
    }
 */
