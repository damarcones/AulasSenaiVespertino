package com.yrontrabalhospringboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VeiculoController {

    @GetMapping()
    public String getMethodName() {
        return "ola";
    }
    
}
