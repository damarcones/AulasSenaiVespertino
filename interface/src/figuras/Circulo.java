package src.figuras;

public class Circulo implements FigurasGeometricas {
    private double raio;

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public String getNomeFigura() {
        return "Circulo";
    }
    @Override
    public double getArea() {
        return Math.PI * Math.pow(raio, 2);
    }


    @Override
    public double getPerimentro() {
        return 2 * Math.PI * raio;
    }
    
    

}
