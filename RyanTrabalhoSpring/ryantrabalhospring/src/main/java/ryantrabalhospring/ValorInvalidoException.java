package ryantrabalhospring;

public class ValorInvalidoException extends RuntimeException {
    public ValorInvalidoException(String mensagem) {
        super("O valor informado é inválido. Valores negativos não são permitidos.");
    }

}
