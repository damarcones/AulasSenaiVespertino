package turistando.example.springturistando.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import turistando.example.springturistando.model.DespesasModel;

public interface DespesasRepository extends JpaRepository<DespesasModel, Long> {
    List<DespesasModel> findByVeiculoPlacaOrderByDataDespesa(String placa);
}
