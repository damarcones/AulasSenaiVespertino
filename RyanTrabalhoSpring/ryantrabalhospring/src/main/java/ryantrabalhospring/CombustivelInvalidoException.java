package ryantrabalhospring;

public class CombustivelInvalidoException extends RuntimeException {
    public CombustivelInvalidoException(String mensagem) {
        super("O tipo de combustível informado não é válido.");
    }

}
