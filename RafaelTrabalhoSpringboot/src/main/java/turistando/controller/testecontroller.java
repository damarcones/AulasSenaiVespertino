package turistando.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class testecontroller {

    @GetMapping("/teste")
    public String teste() {
        return "Aplicação está rodando";
    }
    
}