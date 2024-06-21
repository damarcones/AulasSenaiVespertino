package src.populacao;

public class Filho implements Pai, Mae {
    
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public double altura(double altura) {
        return altura *Math.PI / 3 ;
    }

    @Override
    public boolean barba(boolean tem) {
        return tem;
    }

    @Override
    public boolean calvice(double alt) {
        if(alt > 1.5)
            return true;
        else
            return false;
    }

    @Override
    public String corOlhos(String corA, String corB) {
        if(corA.equals(corB))
            return corA;
        else if(corA.equals("Castanho") && corB.equals("Azul"))
            return corA;
        else if(corA.equals("Azul") && corB.equals("Verde"))
            return corB;
        else
            return corB;
        
    }

    @Override
    public String corPele(String cor) {
        return cor;
    }

    @Override
    public String tipoCabelo(String tipo) {
        // TODO Auto-generated method stub
        return tipo;
    }

}

// if(corA.contains("a"))
