package src;

import src.figuras.Circulo;
import src.figuras.Quadrado;
import src.figuras.Triangulo;
import src.populacao.Filho;

class App {

    // public static void ligarMoto(Veiculo veiculo) {
    //     veiculo.ligar();
    // }

    public static void main(String[] args) {
        // Veiculo corsa = new Carro();

        // App.ligarMoto(corsa);

        // Quadrado quadrado = new Quadrado();
        // quadrado.setLado(14.7);

        // System.out.println("Nome da Figura: " + quadrado.getNomeFigura());
        // System.out.println("Perimetro da Figura: " +  quadrado.getPerimentro());
        // System.out.println("Area da Figura: " + quadrado.getArea());

        // Triangulo triangulo = new Triangulo();

        // triangulo.setAltura(13);
        // triangulo.setBase(16);
        // triangulo.setLadoA(6);
        // triangulo.setLadoB(4);
        // triangulo.setLadoC(8);

        // System.out.println("\n\nNome da Figura: " + triangulo.getNomeFigura());
        // System.out.println("Perimetro da Figura: " +  triangulo.getPerimentro());
        // System.out.println("Area da Figura: " + triangulo.getArea());

        // Circulo circulo = new Circulo();
        // circulo.setRaio(6.4);

        // System.out.println("\n\nNome da Figura: " + circulo.getNomeFigura());
        // System.out.println("Perimetro da Figura: " +  circulo.getPerimentro());
        // System.out.println("Area da Figura: " + circulo.getArea());
        
        Filho filho = new Filho();

        filho.setNome("Damarcones");
        filho.setIdade(29);

        System.out.println("Nome: " + filho.getNome());
        System.out.println("Idade: " + filho.getIdade());

        System.out.println("Altura: " + filho.altura(1.56));
        System.out.println("Tem barba: " + filho.barba(true));
        System.out.println("Calvice: " + filho.calvice(filho.altura(1.56)));
        System.out.println("Cor dos olhos: " + filho.corOlhos("Castanho", "Verde"));
        System.out.println("Cor da pele: " + filho.corPele("Pardo"));
        System.out.println("Tipo do cabelo: " + filho.tipoCabelo("Ondulado"));


    }

}
