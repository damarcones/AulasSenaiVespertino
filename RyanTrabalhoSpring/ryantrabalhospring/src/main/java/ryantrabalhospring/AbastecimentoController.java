package ryantrabalhospring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService abastecimentoService;

    @GetMapping
    public List<Abastecimento> listarTodos() {
        return abastecimentoService.listarTodos();
    }

    @PostMapping
    public Abastecimento salvar(@RequestBody Abastecimento abastecimento) {
        return abastecimentoService.salvar(abastecimento);
    }

    @GetMapping("/{id}") 
    public Abastecimento buscarPorId(@PathVariable Long id) {
        return abastecimentoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}") 
    public void deletar(@PathVariable Long id) throws Exception {
        abastecimentoService.deletar(id);
    }

    @GetMapping("/consumo-medio/{veiculoId}") 
    public double calcularConsumoMedio(@PathVariable Long veiculoId) {
        return abastecimentoService.calcularConsumoMedio(veiculoId);
    }

}
