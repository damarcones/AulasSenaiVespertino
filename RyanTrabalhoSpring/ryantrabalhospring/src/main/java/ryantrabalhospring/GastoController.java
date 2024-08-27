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

import ryantrabalhospring.ryantrabalhospring.GastoService;


@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @GetMapping
    public List<Gasto> listarTodos() {
        return gastoService.listarTodos(); 
    }

    @PostMapping
    public Gasto salvar(@RequestBody Gasto gasto) {
        return gastoService.salvar(gasto); 
    }

    @GetMapping("/{id}") 
    public Gasto buscarPorId(@PathVariable Long id) {
        return gastoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}") 
    public void deletar(@PathVariable Long id) {
        gastoService.deletar(id);
    }

}
