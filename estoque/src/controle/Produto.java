package src.controle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {
    private String nome;
    private int quantidade;
    private double valor;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

     
    @SuppressWarnings("deprecation")
    public String validade(Date fabricacao){
        SimpleDateFormat fs = new SimpleDateFormat("dd/MM/yyyy");
  
        fabricacao.setDate(fabricacao.getDate() + 180);

        return fs.format(fabricacao);

    }

    

}
