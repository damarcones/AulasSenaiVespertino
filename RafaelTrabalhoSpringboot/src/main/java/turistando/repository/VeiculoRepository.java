package turistando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import turistando.model.VeiculoModel;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, String> {

}
