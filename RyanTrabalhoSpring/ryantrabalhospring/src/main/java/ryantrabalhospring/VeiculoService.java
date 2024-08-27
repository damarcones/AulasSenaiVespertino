package ryantrabalhospring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public  List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }

}
