package com.testetrabalho.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testetrabalho.Model.AbastecimentoModel;
import com.testetrabalho.Repository.AbastecimentosRepository;



@RestController
@RequestMapping("abs")
public class AbastecimentosController {

@Autowired
    private AbastecimentosRepository abastecimentosrepository;

    @PostMapping()
    public AbastecimentoModel cadastrarabastecimento(@RequestBody AbastecimentoModel abastecimento) {
        return abastecimentosrepository.save(abastecimento);
    }
    

    @GetMapping("/listarabastecimentos")
    public List<AbastecimentoModel> listarabastecimentos () {
        return abastecimentosrepository.findAll();
    }
    

}
