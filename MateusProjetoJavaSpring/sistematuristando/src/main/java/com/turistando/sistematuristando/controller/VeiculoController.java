
package com.turistando.sistematuristando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistando.sistematuristando.model.Veiculos;
import com.turistando.sistematuristando.services.IVeiculoServices;


@RestController
public class VeiculoController {

    @Autowired
    private IVeiculoServices veiculoService;

   @GetMapping()
    public List<Veiculos> listar() {
        return veiculoService.listar();
    }

    
    // public Veiculos registrar(Veiculos veiculo) {
    //    return veiculoService.registrar(veiculo);
    // }

    
    // public Veiculos atualizar(Veiculos veiculo) {
    //     return veiculoService.atualizar(veiculo);
    // }

    
    // public void deletar(Integer id) {
    //     veiculoService.deletar(id);
    // }

    
    // public Veiculos listarPorId(Integer id) {
    //     return veiculoService.listarPorId(id);
    // }


}
