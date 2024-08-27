package turistando.turistandospring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class testecontroller {


    @GetMapping("/teste")
    public String teste() {
        return "A aplicação está rodando";
    }

}
