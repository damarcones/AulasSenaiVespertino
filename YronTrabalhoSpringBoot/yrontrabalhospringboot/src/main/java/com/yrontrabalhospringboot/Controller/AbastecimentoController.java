package com.yrontrabalhospringboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yrontrabalhospringboot.Repository.AbastecimentoRepository;


@RestController
public class AbastecimentoController {

    @GetMapping("/teste")
    public String getMethodName() {
        return "NÃO FUNCIONA";
    }
    
    
}
