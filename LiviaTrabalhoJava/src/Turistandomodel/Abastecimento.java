package Turistandomodel;

import Enum.tipoAbastecimento;
import java.util.List;

public class Abastecimento  {
    private Double valor;
    private double quantidadeCombustivel;
    private double quilometragem;
    public List <tipoAbastecimento> tipoabastecimento;
    public List <Abastecimento> abastecimentos;
    
    public Abastecimento(Double valor, double quantidadeCombustivel, double quilometragem,
    List<tipoAbastecimento> tipoabastecimento, List<Abastecimento> abastecimentos) {
        this.valor = valor;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.quilometragem = quilometragem;
        this.tipoabastecimento = tipoabastecimento;
        this.abastecimentos = abastecimentos;
    }
    
    public String getAbastecimentos() {
        return "Quilometragem: " + quilometragem +
                ", Valor: R$ " + valor + ", Quantidade: " + quantidadeCombustivel + " litros";
    }

    public void setAbastecimentos(List<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }

    
    
    public Double getValor() {
        return valor;
    }



    public void setValor(Double valor) {
        this.valor = valor;
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



    public List<tipoAbastecimento> getTipoabastecimento() {
        return tipoabastecimento;
    }



    public void setTipoabastecimento(List<tipoAbastecimento> tipoabastecimento) {
        this.tipoabastecimento = tipoabastecimento;
    }






    
}

    
   
    
    
    

    
  

  



