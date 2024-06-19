import Automovel.Carro;
import Automovel.Veiculo;
import figuras.Circulo;
import figuras.Quadrado;
import figuras.Triangulo;

class App {

    // public static void ligarMoto(Veiculo veiculo) {
    //     veiculo.ligar();
    // }

    public static void main(String[] args) {
        // Veiculo corsa = new Carro();

        // App.ligarMoto(corsa);

        Quadrado quadrado = new Quadrado();
        quadrado.setLado(14.7);

        System.out.println("Nome da Figura: " + quadrado.getNomeFigura());
        System.out.println("Perimetro da Figura: " +  quadrado.getPerimentro());
        System.out.println("Area da Figura: " + quadrado.getArea());

        Triangulo triangulo = new Triangulo();

        triangulo.setAltura(13);
        triangulo.setBase(16);
        triangulo.setLadoA(6);
        triangulo.setLadoB(4);
        triangulo.setLadoC(8);

        System.out.println("\n\nNome da Figura: " + triangulo.getNomeFigura());
        System.out.println("Perimetro da Figura: " +  triangulo.getPerimentro());
        System.out.println("Area da Figura: " + triangulo.getArea());

        Circulo circulo = new Circulo();
        circulo.setRaio(6.4);

        System.out.println("\n\nNome da Figura: " + circulo.getNomeFigura());
        System.out.println("Perimetro da Figura: " +  circulo.getPerimentro());
        System.out.println("Area da Figura: " + circulo.getArea());




    }

}
