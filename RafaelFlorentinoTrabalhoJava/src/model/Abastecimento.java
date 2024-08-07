package model;

public class Abastecimento {
    double valorAbastecido;
    double quantidadeCombustivel;
    double quilometragem;

    public Abastecimento(double valorAbastecido, double quantidadeCombustivel, double quilometragem) {
       setValorAbastecido(valorAbastecido);
       setQuantidadeCombustivel(quantidadeCombustivel);
       setQuilometragem(quilometragem);
    }

    public double getValorAbastecido() {
        return valorAbastecido;
    }
    public void setValorAbastecido(double valorAbastecido) {
        this.valorAbastecido = valorAbastecido;
    }
    public double getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }
    public void setQuantidadeCombustivel(double quantidadeCombustivel) {
        this.quantidadeCombustivel = quantidadeCombustivel;
    }
    public double getQuilometragem() {
        return quilometragem;
    }
    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }    
}
