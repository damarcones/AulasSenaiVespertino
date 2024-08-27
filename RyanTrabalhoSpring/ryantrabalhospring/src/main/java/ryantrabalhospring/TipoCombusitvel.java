package ryantrabalhospring;

public enum TipoCombusitvel {
    GASOLINA("Gasolina"),
    ETANOL("Etanol"),
    DIESEL("Diesel"),
    GNV("GNV"),
    ELETRICO("Eletrico");

    private final String descricao;

    TipoCombusitvel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public static boolean isCombustivelValido(String combustivel) {
        for (TipoCombusitvel tipo : TipoCombusitvel.values()) {
            return true;
        }
        return false;
    }
}
