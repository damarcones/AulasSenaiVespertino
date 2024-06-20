package src.figuras;

public class Quadrado implements FigurasGeometricas {

    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double getArea() {    
        return lado * lado;
    }

    @Override
    public String getNomeFigura() {
        return "Quadrado";
    }

    @Override
    public double getPerimentro() {
        return lado * 4;
    } 

}
