package escola.secretaria.Repository;

import java.util.List;

import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import escola.secretaria.Model.Resultados;
import jakarta.transaction.Transactional;

public interface ResultadosRepository extends JpaRepository<Resultados, Integer> {

    @Modifying
    @Transactional
    @Query("update Resultados r set r.status = 'Aprovado' where r.media > 6")
    public int qualquernomeai();
    
    public List<Resultados> findAll();
    
}
