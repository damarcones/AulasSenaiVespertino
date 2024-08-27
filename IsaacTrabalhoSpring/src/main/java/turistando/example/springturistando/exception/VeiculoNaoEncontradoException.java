package turistando.example.springturistando.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VeiculoNaoEncontradoException extends RuntimeException {
    public VeiculoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
