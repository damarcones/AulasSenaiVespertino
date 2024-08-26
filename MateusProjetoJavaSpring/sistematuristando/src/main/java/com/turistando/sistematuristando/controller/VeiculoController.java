
package com.turistando.sistematuristando.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turistando.sistematuristando.model.VeiculoModel;
import com.turistando.sistematuristando.repository.VeiculoRepository;
import com.turistando.sistematuristando.services.VeiculoServices;



@RestController
@RequestMapping("api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repoVeiculo;

    @Autowired
    private VeiculoServices veiculoService;

    @GetMapping("/consumo-medio")
    public ResponseEntity<String> calcularConsumoMedio(@RequestParam String placa) {
        try {
            double consumoMedio = veiculoService.calcularConsumoMedio(placa);
            return ResponseEntity.ok("O consumo médio do veículo é: " + String.format("%.2f", consumoMedio) + " km/l");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

   @GetMapping()
    public List<VeiculoModel> listar() {
        return repoVeiculo.findAll();
    }

    @PostMapping()
    public ResponseEntity<VeiculoModel>registrarVeiculo(@RequestBody  VeiculoModel veiculo){
        VeiculoModel obj = repoVeiculo.save(veiculo);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
    
    @PutMapping()
    public ResponseEntity<VeiculoModel> atualizar(@RequestBody VeiculoModel veiculos){
        VeiculoModel obj = repoVeiculo.save(veiculos);
        return  ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") String id) throws Exception{
        Optional<VeiculoModel> obj = repoVeiculo.findById(id);

        if (obj.isPresent()) {
            repoVeiculo.deleteById(id);
            return ResponseEntity.ok("Veículo encontrado e deletado com sucesso!");
        }else {
            return ResponseEntity.notFound().build();
        }
        
   }

   @GetMapping("/{id}")public ResponseEntity<VeiculoModel> listarPorId(@PathVariable("id") String id) {
    Optional<VeiculoModel> obj = repoVeiculo.findById(id);

        if (obj.isPresent()) {
            return ResponseEntity.ok(obj.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
