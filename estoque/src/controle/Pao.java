package src.controle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Pao extends Produto {
    private String tipoPao;

    public String getTipoPao() {
        return tipoPao;
    }

    public void setTipoPao(String tipoPao) {
        this.tipoPao = tipoPao;
    }

    public LocalDate validade(LocalDate fabricacao){
        // LSimpleDateFormat fs = new SimpleDateFormat("dd/MM/yyyy");
  
        fabricacao.plusDays(10);
        
        return fabricacao;

    }

    public String validade(LocalDate fabricacao, LocalDate validade){
        // LSimpleDateFormat fs = new SimpleDateFormat("dd/MM/yyyy");
            LocalDate dataAtual = LocalDate.now(); 
        if(validade.isBefore(dataAtual))
            return "Produto Vencido";
        else if( fabricacao.isBefore(dataAtual))
            return "Dentro da validade";
        
            else 
                return "Datas Inválidas";
                
            }

    
    public long compara(LocalDate fabricacao, LocalDate validade){
        long valor = ChronoUnit.DAYS.between(fabricacao, validade);

        // Period diferenca = Period.between(fabricacao, validade);
        // int valor = Math.abs(diferenca.getDays());

        return valor;
    }
}

