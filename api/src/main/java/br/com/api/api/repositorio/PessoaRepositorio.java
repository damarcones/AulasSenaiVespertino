package br.com.api.api.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.api.api.modelo.Pessoa;

public interface PessoaRepositorio extends CrudRepository<Pessoa, Integer> {

}
