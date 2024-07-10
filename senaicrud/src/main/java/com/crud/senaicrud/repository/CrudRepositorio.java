package com.crud.senaicrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.senaicrud.models.Usuario;

public interface CrudRepositorio extends CrudRepository<Usuario, Long> {
	Usuario findByIdUsuario(long idUsuario);
	Usuario deleteByIdUsuario(long idUsuario);
}