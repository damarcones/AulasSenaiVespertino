package Escola;

public class Escola {
    public static void main(String[] args) {
        Aluno damarcones = new Aluno();

        damarcones.setNome("Damarcones Porto");
        damarcones.setIdade(29);

        System.out.println("O nome do aluno é: " + damarcones.getNome());
        System.out.println("A idade do aluno é:" +damarcones.getIdade());
    }
}
