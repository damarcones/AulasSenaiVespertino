package turistando.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import turistando.app.model.AbastecimentoModel;
import turistando.app.repository.AbastecimentoRepository;

@RestController
public class AbastecimentoController {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @PostMapping("/abastecerveiculo")
    public AbastecimentoModel abastecerveiculo(@RequestBody AbastecimentoModel abastecimento) {
        return abastecimentoRepository.save(abastecimento);
    }

    @GetMapping("/mostrarabastecimentosgeral")
    public List<AbastecimentoModel> mostrarabastecimentos() {
        return abastecimentoRepository.findAll();
    }

    // @DeleteMapping("/apagarabastecimento/{id}")
    // public void apagarabastecimento(@PathVariable String id) {
    //     abastecimentoRepository.deleteById(id);
    // }

    @GetMapping("/abastecimentoveiculo/{id}")
    public List<AbastecimentoModel> veiculoabastecimento(@PathVariable String id, @RequestBody AbastecimentoModel placaveiculo) {
        return abastecimentoRepository.findByPlacaveiculo(placaveiculo);
    }
}