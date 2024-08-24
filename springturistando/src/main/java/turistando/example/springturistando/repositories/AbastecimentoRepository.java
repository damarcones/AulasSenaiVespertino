package turistando.example.springturistando.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import turistando.example.springturistando.model.AbastecimentoModel;

public interface AbastecimentoRepository extends JpaRepository<AbastecimentoModel, Long> {
    List<AbastecimentoModel> findByVeiculoPlacaOrderByDataAbastecimento(String placa);
}

