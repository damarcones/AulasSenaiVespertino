package src.loja;


public class Gerente extends Funcionario {
    private String usuario;
    private String departamento;

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public String realizaReuniao(boolean realizou ){
        if(realizou == true)
            return "Reunião realizada com sucesso!";
        else
            return "Reunião não realizada";
    }

}
