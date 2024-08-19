package com.turistando.sistematuristando.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistando.sistematuristando.model.AbastecimentoModel;
import com.turistando.sistematuristando.repository.IAbastecimentoRepository;
import com.turistando.sistematuristando.services.AbastecimentoService;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private IAbastecimentoRepository repoAbast;
    
    @Autowired
    private AbastecimentoService abastecimentoService;

    @GetMapping()
    public ResponseEntity<List<AbastecimentoModel>> listar() {
        List<AbastecimentoModel> obj = repoAbast.findAll();
        return ResponseEntity.ok(obj);
    }

    @PostMapping()
    public ResponseEntity<Object> registrarAbastecimento(@RequestBody AbastecimentoModel abastecimento) {
        try {
            AbastecimentoModel novoAbastecimento = abastecimentoService.registrarAbastecimento(abastecimento);
            return ResponseEntity.ok(novoAbastecimento);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<Object> atualizar(@RequestBody AbastecimentoModel abastecimento) {
        try {
            AbastecimentoModel novoAbastecimento = abastecimentoService.registrarAbastecimento(abastecimento);
            return ResponseEntity.ok(novoAbastecimento);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") int id) throws Exception{
        Optional<AbastecimentoModel> obj = repoAbast.findById(id);
        
        if (obj.isPresent()) {
            repoAbast.deleteById(id);
            return ResponseEntity.ok("Abastecimento encontrado e deletado com sucesso!");
        }else {
            return ResponseEntity.notFound().build();
        }
   }

    @GetMapping("/{id}")
    public ResponseEntity<AbastecimentoModel> listarPorId(@PathVariable("id") int id) throws Exception{
        Optional<AbastecimentoModel> obj = repoAbast.findById(id);
        if (obj.isPresent()) {
            return ResponseEntity.ok(obj.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
