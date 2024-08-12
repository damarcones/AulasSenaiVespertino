package com.turistando.sistematuristando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistando.sistematuristando.model.Abastecimentos;
import com.turistando.sistematuristando.services.IAbastecimentoServices;


@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private IAbastecimentoServices serviceAbast;

    @GetMapping()
    public ResponseEntity<List<Abastecimentos>> listar() {
        List<Abastecimentos> obj = serviceAbast.listar();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping("/registrarAbastecimento")
    public ResponseEntity<Abastecimentos> registrar(Abastecimentos abastecimento){
        Abastecimentos obj = serviceAbast.registrar(abastecimento);
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
