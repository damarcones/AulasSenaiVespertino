package model;

public class Despesa {
    private String nome;
    private float valor;
    private String placa;
    private String categoria;
    private String descricao;

    public Despesa(String nome, float valor, String placa, String categoria, String descricao) {
        setNome(nome);
        setValor(valor);
        setPlaca(placa);
        setCategoria(categoria);
        setDescricao(descricao);
    }

    @Override
    public String toString() {
        return "Despesa [\nNome = " + getNome() + ",\nValor = " + getValor() + ",\nPlaca = " + getPlaca()
                +  ",\nCategoria = " + getCategoria() + ",\nDescrição = " + getDescricao() + " ]";
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
