package src.loja;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Secretario extends Funcionario {
    private int ramal;
    private String turno;

    public int getRamal() {
        return ramal;
    }
    public void setRamal(int ramal) {
        this.ramal = ramal;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public String marcaReuniao( Date dataReuniao, String nome){
        SimpleDateFormat fs = new SimpleDateFormat("dd/MM/yyyy");

        return "Reunião marcada dia " + fs.format(dataReuniao) + " com o gerente " + nome +".";
    }

}
