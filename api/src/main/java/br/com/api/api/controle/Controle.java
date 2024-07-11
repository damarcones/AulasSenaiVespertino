package br.com.api.api.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.api.modelo.Pessoa;


@RestController
public class Controle {
    @GetMapping("")
    public String mensagem(){
        return "Olá Mundo!";
    }

    @GetMapping("/bemvindo")
    public String bemVindo() {
        return "Bem vindo ao Spring";
    }

    @GetMapping("/bemvindo/{nome}")
    public String bemVindo(@PathVariable String nome) {
        return "Bem vindo(a) " +nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa (@RequestBody Pessoa p){
        return p;
    }
    
}
