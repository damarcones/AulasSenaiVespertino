package turistando.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import turistando.app.model.GastoModel;

public interface GastoRepository extends JpaRepository<GastoModel, Integer> {

}
