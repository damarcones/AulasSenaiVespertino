package turistando.turistandospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import turistando.turistandospring.model.GastoModel;
import turistando.turistandospring.Enum.TipoGasto;

import java.util.List;

public interface GastoRepository extends JpaRepository<GastoModel, Long> {

    @Query("SELECT g FROM GastoModel g WHERE g.veiculo.placa = :placa")
    List<GastoModel> findByPlaca(@Param("placa") String placa);

    @Query("SELECT g FROM GastoModel g WHERE g.veiculo.placa = :placa AND g.categoria = :categoria")
    List<GastoModel> findByCategoriaAndPlaca(@Param("categoria") TipoGasto categoria, @Param("placa") String placa);
}
