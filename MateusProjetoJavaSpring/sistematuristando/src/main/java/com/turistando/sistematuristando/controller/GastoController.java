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

import com.turistando.sistematuristando.model.GastoModel;
import com.turistando.sistematuristando.services.GastoService;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoService serviceGasto;

   @GetMapping()
    public List<GastoModel> listar() {
        return serviceGasto.listar();
    }

    @PostMapping()
    public ResponseEntity<GastoModel> registrar(@RequestBody GastoModel gasto){
        GastoModel obj = serviceGasto.registrar(gasto);
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping()
    public ResponseEntity<GastoModel> atualizar(@RequestBody GastoModel gasto){
        GastoModel obj = serviceGasto.atualizar(gasto);
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") int id) throws Exception{
        GastoModel obj = serviceGasto.listarPorId(id);
        if (obj == null) {
            throw new Exception("Id não encontrado");
        }
        serviceGasto.deletar(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

    @GetMapping("/{id}")
    public ResponseEntity<GastoModel> listarPorId(@PathVariable("id") int id) throws Exception{
        GastoModel obj = serviceGasto.listarPorId(id);
        if (obj == null) {
            throw new Exception("Id não encontrado");
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
