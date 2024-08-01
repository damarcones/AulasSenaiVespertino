package com.biblioteca.gerenciamento.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.gerenciamento.model.LivroModel;
import com.biblioteca.gerenciamento.repositorio.LivroRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class LivroController {
    
    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/teste")
    public String teste(){
        return "Testado novamente!!!";
    }

    @PostMapping("/adicionarlivro")
    public LivroModel addLivro(@RequestBody LivroModel livro) {
        return livroRepository.save(livro);
    }

    @GetMapping("/listarlivros")
    public List<LivroModel>listarLivros() {
        return livroRepository.findAll();
    }
    
    

}
