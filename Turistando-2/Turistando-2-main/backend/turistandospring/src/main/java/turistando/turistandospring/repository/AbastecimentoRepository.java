package turistando.turistandospring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import turistando.turistandospring.model.AbastecimentoModel;


public interface AbastecimentoRepository extends JpaRepository<AbastecimentoModel, Long> {

    List<AbastecimentoModel> findByVeiculoPlacaOrderByQuilometragemAsc(String veiculoId);

        @Query("SELECT a FROM AbastecimentoModel a WHERE a.veiculo.placa = :placa")
    List<AbastecimentoModel> findByPlaca(@Param("placa") String placa);
}

