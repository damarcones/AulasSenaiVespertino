package com.biblioteca.gerenciamento.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.gerenciamento.model.EmprestimoModel;
import com.biblioteca.gerenciamento.repositorio.EmprestimoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @PostMapping("/fazeremprestimo")
    public EmprestimoModel emprestimos(@RequestBody EmprestimoModel emprestimo) {        
        return emprestimoRepository.save(emprestimo);
    }
    
}
