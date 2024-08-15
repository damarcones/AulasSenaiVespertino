package turistando.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import turistando.app.model.VeiculoModel;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, String>{

}
