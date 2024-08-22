package com.autenticacao.appautentic.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.autenticacao.appautentic.DTOs.CriarUsuarioDTO;
import com.autenticacao.appautentic.DTOs.RecoveryJwtTokenDTO;
import com.autenticacao.appautentic.DTOs.UsuarioLoginDTO;
import com.autenticacao.appautentic.Model.RuleModel;
import com.autenticacao.appautentic.Model.UsuarioModel;
import com.autenticacao.appautentic.Repository.UsuarioRepository;
import com.autenticacao.appautentic.Security.Autentic.JwtTokenService;
import com.autenticacao.appautentic.Security.Config.SegurancaConfig;
import com.autenticacao.appautentic.Security.Details.UsuarioDetailsImpl;

@Service
public class UsuarioService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SegurancaConfig segurancaConfig;

    public RecoveryJwtTokenDTO authenticateUsuario(UsuarioLoginDTO usuarioLoginDTO){

        UsernamePasswordAuthenticationToken usuarioPassword = new UsernamePasswordAuthenticationToken(usuarioLoginDTO.email(), usuarioLoginDTO.password());

        Authentication authentication = authenticationManager.authenticate(usuarioPassword);

        UsuarioDetailsImpl usuarioDetailsImpl = (UsuarioDetailsImpl) authentication.getPrincipal();

        return new RecoveryJwtTokenDTO(jwtTokenService.generateToken(usuarioDetailsImpl));

    }

    public void CriarUsuario(CriarUsuarioDTO criarUsuarioDTO){
        UsuarioModel usuarioModel = UsuarioModel.builder()
            .email(criarUsuarioDTO.email())
            .password(segurancaConfig.passwordEncoder().encode(criarUsuarioDTO.password()))
            .rules(List.of(RuleModel.builder().tipo(criarUsuarioDTO.rules()).build()))
            .build();

            usuarioRepository.save(usuarioModel);

    }
}
