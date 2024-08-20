package com.autenticacao.appautentic.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autenticacao.appautentic.Model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByEmail(String email);
}
