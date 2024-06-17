package src.controle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pao extends Produto {
    private String tipoPao;

    public String getTipoPao() {
        return tipoPao;
    }

    public void setTipoPao(String tipoPao) {
        this.tipoPao = tipoPao;
    }

    @Override
    @SuppressWarnings("deprecation")
    public String validade(Date fabricacao){
        SimpleDateFormat fs = new SimpleDateFormat("dd/MM/yyyy");
  
        fabricacao.setDate(fabricacao.getDate() + 1);

        return fs.format(fabricacao);

    }
}
