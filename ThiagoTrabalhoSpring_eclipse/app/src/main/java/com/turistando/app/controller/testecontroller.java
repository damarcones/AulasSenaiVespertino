package com.turistando.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class testecontroller {
    
    @GetMapping("/teste")
    public String teste(){
        return "ta rodando";
    }
}
