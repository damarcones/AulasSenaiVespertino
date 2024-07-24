package escola.secretaria.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import escola.secretaria.Model.Resultados;

public interface ResultadosRepository extends JpaRepository<Resultados, Integer> {

    public List<Resultados> findAll();
    
}
