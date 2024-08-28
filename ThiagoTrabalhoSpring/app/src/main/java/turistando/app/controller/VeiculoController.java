package turistando.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import turistando.app.model.VeiculoModel;
import turistando.app.repository.VeiculoRepository;

@RestController
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping("/cadastrarveiculo")
    public VeiculoModel cadastrarveiculo(@RequestBody VeiculoModel veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @GetMapping("/mostrarveiculos")
    public List<VeiculoModel> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    @PutMapping("/modificarveiculo/{id}")
    public VeiculoModel modificaveiculo(@PathVariable String id, @RequestBody VeiculoModel veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @DeleteMapping("/apagarveiculo/{id}")
    public void apagarveiculo(@PathVariable String id) {
        veiculoRepository.deleteById(id);
    }

}
