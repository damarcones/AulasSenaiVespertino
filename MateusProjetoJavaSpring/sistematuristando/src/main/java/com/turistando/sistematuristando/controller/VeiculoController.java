
package com.turistando.sistematuristando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistando.sistematuristando.model.Veiculo;
import com.turistando.sistematuristando.services.IVeiculoServices;



@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private IVeiculoServices serviceVeiculo;

   @GetMapping()
    public List<Veiculo> listar() {
        return serviceVeiculo.listar();
    }

    @PostMapping()
    public ResponseEntity<Veiculo> registrar(@RequestBody Veiculo veiculos){
        Veiculo obj = serviceVeiculo.registrar(veiculos);
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping()
    public ResponseEntity<Veiculo> atualizar(@RequestBody Veiculo veiculos){
        Veiculo obj = serviceVeiculo.atualizar(veiculos);
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") int id) throws Exception{
        Veiculo obj = serviceVeiculo.listarPorId(id);
        if (obj == null) {
            throw new Exception("Id não encontrado");
        }
        serviceVeiculo.deletar(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> listarPorId(@PathVariable("id") int id) throws Exception{
        Veiculo obj = serviceVeiculo.listarPorId(id);
        if (obj == null) {
            throw new Exception("Id não encontrado");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }


}
