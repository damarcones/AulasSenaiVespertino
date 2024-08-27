<<<<<<< Updated upstream
package com.testetrabalho.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testetrabalho.Model.VeiculoModel;
import com.testetrabalho.Repository.VeiculoRepository;

@RestController
public class VeiculoController {

   @Autowired
    private VeiculoRepository veiculorepository;


    @PostMapping("/cadastrarveiculo")
    public VeiculoModel cadastrarveiculo(@RequestBody VeiculoModel veiculo) {
     return veiculorepository.save(veiculo);
 
 }
        

    @GetMapping("/listarVeiculos")
    public List<VeiculoModel> listarVeiculos () {
        return veiculorepository.findAll();
    }
    
    
    @PutMapping("/modificarVeiculo/{id}")
    public VeiculoModel modificarVeiculo(@PathVariable String id,@RequestBody VeiculoModel veiculo) {
       return veiculorepository.save(veiculo);
        
        
    }

    @DeleteMapping("/deletarVeiculo/{id}")
    public void deletarVeiculo(@PathVariable String id ){
      veiculorepository.deleteById(id);

    }
}
=======
package com.testetrabalho.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testetrabalho.Model.VeiculoModel;
import com.testetrabalho.Repository.VeiculoRepository;

@RestController
public class VeiculoController {

   @Autowired
    private VeiculoRepository veiculorepository;


    @PostMapping("/cadastrarveiculo")
    public VeiculoModel cadastrarveiculo(@RequestBody VeiculoModel veiculo) {
     return veiculorepository.save(veiculo);
 
 }
        

    @GetMapping("/listarVeiculos")
    public List<VeiculoModel> listarVeiculos () {
        return veiculorepository.findAll();
    }
    
    
    @PutMapping("/modificarVeiculo/{id}")
    public VeiculoModel modificarVeiculo(@PathVariable String id,@RequestBody VeiculoModel veiculo) {
       return veiculorepository.save(veiculo);
        
        
    }

    @DeleteMapping("/deletarVeiculo/{id}")
    public void deletarVeiculo(@PathVariable String id ){
      veiculorepository.deleteById(id);

    }
}
>>>>>>> Stashed changes
