package ryantrabalhospring.ryantrabalhospring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ryantrabalhospring.Gasto;
import ryantrabalhospring.GastoRepository;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    public List<Gasto> listarTodos() {
        return gastoRepository.findAll();
    }

    public Gasto salvar(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public Gasto buscarPorId(Long id) {
        return gastoRepository.findById(id).orElse(null);
    }

    public void deletar (Long id) {
        gastoRepository.deleteById(id);
    }
}
