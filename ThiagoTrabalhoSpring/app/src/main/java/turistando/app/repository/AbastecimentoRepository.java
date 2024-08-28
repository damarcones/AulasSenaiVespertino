package turistando.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import turistando.app.model.AbastecimentoModel;

public interface AbastecimentoRepository extends JpaRepository<AbastecimentoModel, Integer> {

    List<AbastecimentoModel> findByPlacaveiculo(AbastecimentoModel placaveiculo);

}
