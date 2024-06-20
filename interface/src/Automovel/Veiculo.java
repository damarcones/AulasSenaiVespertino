package src.Automovel;

public interface Veiculo {
    public String placa(String nome);
    public double velocidaMax();
    public void ligar();
    public void desligar();
    public void parar();
    default void buzinar(){
        System.out.println("Buzina");
    }
}
