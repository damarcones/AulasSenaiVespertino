package src.loja;

public class Funcionario {
    private String nome;
    private long cpf;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    public double bonificacao(double salario, double bonus){
        return salario += (salario * bonus);
    }
}
