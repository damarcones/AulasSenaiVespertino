package com.yrontrabalhospringboot.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yrontrabalhospringboot.model.VeiculoModel;
import com.yrontrabalhospringboot.repository.VeiculoRepository;



@RestController
public class VeiculoController {

    @GetMapping("/teste")
    public String getMethodName() {
        return "OLA";
    }
    

    @Autowired
    private VeiculoRepository veiculoRepository;
    
    @PostMapping("/cadastrarveiculo")
    public VeiculoModel cadastrarVeiculo(@RequestBody VeiculoModel veiculoModel) {
        return veiculoRepository.save(veiculoModel);
    }
    
    

}
