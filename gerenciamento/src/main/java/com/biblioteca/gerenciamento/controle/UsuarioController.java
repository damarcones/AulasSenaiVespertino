package com.biblioteca.gerenciamento.controle;

import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.gerenciamento.model.UsuarioModel;
import com.biblioteca.gerenciamento.repositorio.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping("/adicionarusuario")
    public UsuarioModel addUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }
    @GetMapping("/listarusuarios")
    public List<UsuarioModel> listausuarioa() {
        return usuarioRepository.findAll();
    }
    
    
}
