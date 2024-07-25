package Model;

public class Abastecimento {
    private int quilometragem;
    private double valor;
    private double quantidade;

    public Abastecimento(int quilometragem, double valor, double quantidade) {
        this.quilometragem = quilometragem;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getAbastecimento() {
        return "Quilometragem: " + quilometragem +
               ", Valor: R$ " + valor + ", Quantidade: " + quantidade + " litros";
    }
}
