package com.autenticacao.appautentic.DTOs;

import com.autenticacao.appautentic.Enums.RulesEnum;

public record CriarUsuarioDTO( 
    
    String email,
    String password,
    RulesEnum rules
    
){
    
}