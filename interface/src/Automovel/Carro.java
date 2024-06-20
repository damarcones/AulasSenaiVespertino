package src.Automovel;

public class Carro implements Veiculo, Proprietario {

    public String placa(String nome){
        return nome;
    }
    public void ligar(){
        System.out.println("Ligando o carro!");
    }
    public void desligar(){
        System.out.println("Desligando o carro");
    }
   
    public void parar() {
        System.out.println("parando o carro!");
    }
    public double velocidaMax() {
        
        return 0;
    } 
    public String getNome(String nome){
        return nome;
    }

    public String getEndereco(){
        return "Gama";
    }

}
