package com.autenticacao.appautentic.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.autenticacao.appautentic.DTOs.CriarUsuarioDTO;
import com.autenticacao.appautentic.DTOs.RecoveryJwtTokenDTO;
import com.autenticacao.appautentic.DTOs.UsuarioLoginDTO;
import com.autenticacao.appautentic.Services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDTO> autenticarUsuario(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {

        RecoveryJwtTokenDTO token = usuarioService.authenticateUsuario(usuarioLoginDTO);
        
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> criarUsuario(@RequestBody CriarUsuarioDTO criarUsuarioDTO) {
        usuarioService.CriarUsuario(criarUsuarioDTO);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    

}
