package turistando.example.springturistando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;



import turistando.example.springturistando.model.VeiculoModel;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, String> {

}
