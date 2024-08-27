package ryantrabalhospring;

public class InformacaoEmBrancoException extends RuntimeException {
    public InformacaoEmBrancoException(String mensagem) {
        super("Todos os campos obrigatórios devem ser preenchidos.");
    }

}
