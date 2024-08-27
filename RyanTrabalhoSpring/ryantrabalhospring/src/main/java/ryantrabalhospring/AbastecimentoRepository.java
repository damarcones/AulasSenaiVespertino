package ryantrabalhospring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {

    public List<Abastecimento> findByVeiculoId(Long veiculoId);
    
}
