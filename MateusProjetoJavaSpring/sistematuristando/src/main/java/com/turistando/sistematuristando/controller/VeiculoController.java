
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

import com.turistando.sistematuristando.model.VeiculoModel;

import com.turistando.sistematuristando.services.VeiculoService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
   

    @Autowired
    private VeiculoService serviceVeiculo;

   @GetMapping()
    public List<VeiculoModel> listar() {
        return serviceVeiculo.listar();
    }

    @PostMapping()
    public ResponseEntity<VeiculoModel>registrarVeiculo(@RequestBody VeiculoModel veiculo){
        VeiculoModel obj = serviceVeiculo.registrar(veiculo);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping()
    public ResponseEntity<VeiculoModel> atualizar(@RequestBody VeiculoModel veiculos){
        VeiculoModel obj = serviceVeiculo.atualizar(veiculos);
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) throws Exception{
        VeiculoModel obj = serviceVeiculo.listarPorId(id);
        if (obj == null) {
            throw new Exception("Id não encontrado");
        }
        serviceVeiculo.deletar(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoModel> listarPorId(@PathVariable("id") String id) throws Exception{
        VeiculoModel obj = serviceVeiculo.listarPorId(id);
        if (obj == null) {
            throw new Exception("Id não encontrado");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }


}
