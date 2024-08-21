package com.autenticacao.appautentic.Security.Autentic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

import com.autenticacao.appautentic.Security.Config.SegurancaConfig;
import com.autenticacao.appautentic.Security.Details.UsuarioDetailsImpl;
import com.autenticacao.appautentic.Model.UsuarioModel;
import com.autenticacao.appautentic.Repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class UsuarioAutenticFiltro extends OncePerRequestFilter{

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
        if(checkIfEndpointIsNotPublic(request)){
            String token = RecuperaToken(request);
            if(token != null){
                String objeto = jwtTokenService.getSubjectFromToken(token);
                UsuarioModel usuario = usuarioRepository.findByEmail(objeto).get();
                UsuarioDetailsImpl usuarioDetailsImpl = new UsuarioDetailsImpl(usuario);

                Authentication authentic = new UsernamePasswordAuthenticationToken(usuarioDetailsImpl.getUsername(), null, usuarioDetailsImpl.getAuthorities()); 

                SecurityContextHolder.getContext().setAuthentication(authentic);
            }
            else{
                throw new RuntimeException("Faltando Token!");
            }
        }

        filterChain.doFilter(request, response);
    }

    private String RecuperaToken(HttpServletRequest request){
        String autoriza = request.getHeader("Authorization"); 
        
        if(autoriza != null){
            return autoriza.replace("Bearer ","");
        }

        return null;
    }

    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request){
        String uri = request.getRequestURI();
        return !Arrays.asList(SegurancaConfig.ENDPOINTS_AUTHENTICATION_NOT_REQUIRED).contains(uri);
    }
}
