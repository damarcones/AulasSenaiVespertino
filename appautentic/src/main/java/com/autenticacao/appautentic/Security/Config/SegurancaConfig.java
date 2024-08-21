package com.autenticacao.appautentic.Security.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SegurancaConfig {
    public static final String [] ENDPOINTS_AUTHENTICATION_NOT_REQUIRED ={
        "/usuario/login",
        "/usuario/creat"
    };

    public static final String [] ENDPOINTS_AUTHENTICATION_REQUIRED ={
        "/usuario/teste"    
    };
    

}
