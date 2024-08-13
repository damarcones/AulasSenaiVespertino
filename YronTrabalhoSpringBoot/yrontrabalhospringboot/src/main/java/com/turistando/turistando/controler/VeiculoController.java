package com.turistando.turistando.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turistando.turistando.model.VeiculoModel;
import com.turistando.turistando.repository.VeiculoRepository;


@RestController
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;
    
    @PostMapping("/cadastrarveiculo")
    public VeiculoModel cadastrarVeiculo(@RequestBody VeiculoModel veiculoModel) {
        return veiculoRepository.save(veiculoModel);
    }
    
    

}
