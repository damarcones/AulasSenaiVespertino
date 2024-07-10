
package com.senai.primeirospassos.controller;

import com.senai.primeirospassos.model.Usuario;
import com.senai.primeirospassos.view.UsuarioView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UsuarioController {

    

    @Autowired
    private UsuarioView view;

    @GetMapping("/usuarios")
    public List<Usuario> getAll() {
        return view.listAll();
    }
    
    //    localhost:8080/

}
