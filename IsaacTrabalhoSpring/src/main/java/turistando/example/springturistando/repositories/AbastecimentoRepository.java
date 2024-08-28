package turistando.example.springturistando.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import turistando.example.springturistando.model.AbastecimentoModel;

public interface AbastecimentoRepository extends JpaRepository<AbastecimentoModel, Long> {

    @Query("SELECT a FROM AbastecimentoModel a WHERE a.veiculo.placa = :placa ORDER BY a.dataAbastecimento")
    List<AbastecimentoModel> findByVeiculoPlacaOrderByDataAbastecimento(@Param("placa") String placa);
}
