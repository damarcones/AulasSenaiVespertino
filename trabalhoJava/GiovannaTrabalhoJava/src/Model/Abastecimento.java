package Model;

public class Abastecimento {

    private int quilometragem;
    private double quantidade;
    private double valor;

    public Abastecimento(int quilometragem, double valor, double quantidade){

        this.quantidade = quantidade;
        this.quilometragem = quilometragem;
        this.valor = valor;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    

}
