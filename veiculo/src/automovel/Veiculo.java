package automovel;

public class Veiculo {

    private String nome;
    private String modelo;
    private int qntPneu;
    private boolean status;
    private int velocidade;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getQntPneu() {
        return qntPneu;
    }
    public void setQntPneu(int qntPneu) {
        this.qntPneu = qntPneu;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
   public int acelerar(int novaVelocidade){
    velocidade += novaVelocidade;
    return velocidade;
   }
   public int frear(int novaVelocidade){
    if(velocidade > novaVelocidade)
        return velocidade -= novaVelocidade;
    else
        return velocidade = 0;
    
   }
   public int parar(){
    return velocidade = 0;
   }



}
