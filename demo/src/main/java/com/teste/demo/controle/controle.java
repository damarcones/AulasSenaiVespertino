package com.teste.demo.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controle {
    @GetMapping("")
    public String ola(){
        return "Olá Mundo";
    }

    @GetMapping("/bemvindo")
    public String bem(){
        return "Seja bem vindo";
    }

    @GetMapping("/bemvindo/{nome}")
    public String bem(@PathVariable String nome){
        return "Bem vindo " + nome;
    }
}
