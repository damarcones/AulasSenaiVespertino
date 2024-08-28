package turistando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import turistando.model.DespesaModel;

@Repository
public interface DespesaRepository extends JpaRepository<DespesaModel, Integer> {

}

