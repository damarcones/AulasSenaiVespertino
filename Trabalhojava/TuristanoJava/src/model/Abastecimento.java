package model;

public class Abastecimento {

    private double valor;
    private double quantidadeCombustivel;
    private int quilometragemAtual;

    public Abastecimento(double valor, double quantidadeCombustivel, int quilometragemAtual) {
        this.valor = valor;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.quilometragemAtual = quilometragemAtual;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }

    public void setQuantidadeCombustivel(double quantidadeCombustivel) {
        this.quantidadeCombustivel = quantidadeCombustivel;
    }

    public int getQuilometragemAtual() {
        return quilometragemAtual;
    }

    public void setQuilometragemAtual(int quilometragemAtual) {
        this.quilometragemAtual = quilometragemAtual;
    }
}
