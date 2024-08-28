package com.turistando.sistematuristando.controller;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

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
import com.turistando.sistematuristando.repository.AbastecimentoRepository;
import com.turistando.sistematuristando.services.AbastecimentoService;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoRepository repoAbast;
    
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
   public ResponseEntity<?> listarPorId(@PathVariable("id") String id) {
        
        // mesmo id sendo do tipo int, setei o paramentro para string a fim de filtrar o valor passado, e lança uma excessão mais consisa;
        //usei regex para ter certeza de que somente há valores de int;
        if (!Pattern.matches("\\d+", id)) {
           return ResponseEntity.badRequest().body("O ID fornecido não é um número inteiro válido.");
       }
   
       int parsedId = Integer.parseInt(id);
       
       Optional<AbastecimentoModel> obj = repoAbast.findById(parsedId);
       if (obj.isPresent()) {
           return ResponseEntity.ok(obj.get());
       } else {
           return ResponseEntity.notFound().build();
       }
   }

    @GetMapping("veiculo/{placa}")
    public ResponseEntity< List<AbastecimentoModel> > listarPorPlaca(@PathVariable("placa") String placa) throws Exception{
        List <AbastecimentoModel> obj = abastecimentoService.getAbastecimentoPorPlaca(placa);
        if (!obj.isEmpty()) {
            return ResponseEntity.ok(obj);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
