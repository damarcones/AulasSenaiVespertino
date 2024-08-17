
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
import org.springframework.web.bind.annotation.RestController;

import com.turistando.sistematuristando.model.VeiculoModel;
import com.turistando.sistematuristando.repository.IVeiculoRepository;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
   

    @Autowired
    private IVeiculoRepository repoVeiculo;

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
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) throws Exception{
        Optional<VeiculoModel> obj = repoVeiculo.findById(id);

        if (obj.isPresent()) {
            repoVeiculo.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
   }

   @GetMapping("/{id}")public ResponseEntity<VeiculoModel> listarPorId(@PathVariable("id") String id) {
    Optional<VeiculoModel> obj = repoVeiculo.findById(id);

    if (obj.isPresent()) {
        return new ResponseEntity<>(obj.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


}
