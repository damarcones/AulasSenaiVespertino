package com.turistando.sistematuristando.controller;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

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
import com.turistando.sistematuristando.model.VeiculoModel;
import com.turistando.sistematuristando.repository.GastoRepository;
import com.turistando.sistematuristando.repository.VeiculoRepository;
import com.turistando.sistematuristando.services.GastoServices;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoRepository repoGasto;

    @Autowired
    private GastoServices gastoService;
    

    @Autowired
    private VeiculoRepository repoVeiculo;

   @GetMapping()
    public ResponseEntity<List<GastoModel>> listar() {
        List<GastoModel> obj = repoGasto.findAll();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> registrar(@RequestBody GastoModel gasto){
        
        Optional<VeiculoModel> veiculoOpt = repoVeiculo.findById(gasto.getVeiculo().getPlaca());
        try {
            if (veiculoOpt.isPresent()) {
            gasto.setVeiculo(veiculoOpt.get());
            GastoModel obj = gastoService.registrarGasto(gasto);
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
        
    }
    
    @PutMapping()
    public ResponseEntity<GastoModel> atualizar(@RequestBody GastoModel gasto){
        GastoModel obj = repoGasto.save(gasto);
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") int id) throws Exception{
        Optional<GastoModel> obj = repoGasto.findById(id);
        if (obj.isPresent()) {
            repoGasto.deleteById(id);
            return ResponseEntity.ok("Gasto encontrado e deletado com sucesso!");
        }else {
            return ResponseEntity.notFound().build();
        }
   }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") String id) throws Exception{
        
        // mesmo id sendo do tipo int, setei o paramentro para string a fim de filtrar o valor passado, e lança uma excessão mais consisa;
        //usei regex para ter certeza de que somente há valores de int;
        if (!Pattern.matches("\\d+", id)) {
           return ResponseEntity.badRequest().body("O ID fornecido não é um número inteiro válido.");
       }
   
       int parsedId = Integer.parseInt(id);
       
       Optional<GastoModel> obj = repoGasto.findById(parsedId);
       if (obj.isPresent()) {
           return ResponseEntity.ok(obj.get());
       } else {
           return ResponseEntity.notFound().build();
       }
    }

    @GetMapping("veiculo/{placa}")
    public ResponseEntity<List<GastoModel>> listarPorPlaca(@PathVariable("placa") String placa) throws Exception{
        List<GastoModel> obj = gastoService.getGastosPorPlaca(placa);
        if (!obj.isEmpty()) {
            return ResponseEntity.ok(obj);
        } else {
            return ResponseEntity.notFound().build();
        }
    }    
}
