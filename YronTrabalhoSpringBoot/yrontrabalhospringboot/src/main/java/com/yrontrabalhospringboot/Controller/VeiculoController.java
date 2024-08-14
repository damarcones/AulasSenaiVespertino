package com.yrontrabalhospringboot.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yrontrabalhospringboot.Model.VeiculoModel;
import com.yrontrabalhospringboot.Repository.VeiculoRepository;




@RestController
public class VeiculoController {

    @GetMapping("/teste")
    public String getMethodName() {
        return "OLA";
    }
    
    @Autowired
    private VeiculoRepository veiculoRepository;
    
    @PostMapping("/cadastrarveiculo")
    public VeiculoModel cadastrarVeiculo(@RequestBody VeiculoModel veiculoModel) {
        return veiculoRepository.save(veiculoModel);
    }

    @GetMapping("/listarveiculos")
    public List<VeiculoModel> listarveiculos() {
        return veiculoRepository.findAll();
    }
    
    @PostMapping("modificarveiculo/{id}")
    public VeiculoModel modificarveiculo(@PathVariable String id, @RequestBody VeiculoModel veiculo) {
        return veiculoRepository.save(veiculo);
    }
    
    @DeleteMapping("apagarveiculo/{id}")
    public void apagarVeiculo(@PathVariable String id){
        veiculoRepository.deleteById(id);
    }
}
