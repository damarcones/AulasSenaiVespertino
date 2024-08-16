package com.turistando.sistematuristando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistando.sistematuristando.model.AbastecimentoModel;
import com.turistando.sistematuristando.services.AbastecimentoService;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService serviceAbast;

    @GetMapping()
    public ResponseEntity<List<AbastecimentoModel>> listar() {
        List<AbastecimentoModel> obj = serviceAbast.listar();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping("/registrarAbastecimento")
    public ResponseEntity<AbastecimentoModel> registrar(AbastecimentoModel abastecimento){
        AbastecimentoModel obj = serviceAbast.registrar(abastecimento);
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
