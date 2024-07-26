package Model;

public class Motorista {

    private String nome;
    private String cnh;
    private String telefone;

    public Motorista(String nome, String cnh, String telefone) {

        this.telefone = telefone;
        this.cnh = cnh;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}