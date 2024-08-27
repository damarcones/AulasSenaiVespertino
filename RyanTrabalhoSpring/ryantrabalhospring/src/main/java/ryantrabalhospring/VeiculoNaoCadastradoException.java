package ryantrabalhospring;

public class VeiculoNaoCadastradoException extends RuntimeException {
    public VeiculoNaoCadastradoException(String mensagem ) {
        super("O veículo informado não está cadastrado no sistema.");
    }

}
