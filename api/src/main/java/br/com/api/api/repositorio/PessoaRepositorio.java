package br.com.api.api.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.api.modelo.Pessoa;
@Repository
public interface PessoaRepositorio extends CrudRepository<Pessoa, Integer> {

    List<Pessoa> findAll();

    List<Pessoa> findById(int id);
}
