package Model;


// ultimoAbastecimento - abastecimentoAnterior / quantidadeLitrosaAbastecimento

//ultimoAbastecimento - primeiroAbastecimento / totalQntLitrosAbs

public class Abastecimento {
    private int quilometragem;
    private double valor;
    private double quantidade;
    private TipoCombustivelAbastecimento tipoCombustivelAbastecimento;


    public Abastecimento(int quilometragem, double valor, double quantidade, TipoCombustivelAbastecimento tipoCombustivelAbastecimento) {
        this.quilometragem = quilometragem;
        this.valor = valor;
        this.quantidade = quantidade;
        this.tipoCombustivelAbastecimento = tipoCombustivelAbastecimento;
    }

    public enum TipoCombustivelAbastecimento {
        GASOLINA,
        DIESEL,
        ALCOOL,
        GNV
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

    public TipoCombustivelAbastecimento getTipoCombustivelAbastecimento() {
        return tipoCombustivelAbastecimento;
    }

    public void setTipoCombustivelAbastecimento(TipoCombustivelAbastecimento tipoCombustivelAbastecimento) {
        this.tipoCombustivelAbastecimento = tipoCombustivelAbastecimento;
    }


}
