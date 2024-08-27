package turistando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import turistando.model.AbastecimentoModel;

@Repository
public interface AbastecimentoRepository extends JpaRepository<AbastecimentoModel, Integer> {
    

}



