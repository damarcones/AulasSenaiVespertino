package turistando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import turistando.model.DespesaModel;
import turistando.repository.DespesaRepository;
import turistando.services.DespesaServices;

@RestController
public class DespesaController {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private DespesaServices despesaServices;

  
    @PostMapping("/cadastrardespesa")
    public DespesaModel registrarDespesa(@RequestBody DespesaModel despesa) {
        try {
            return despesaServices.registrarDespesa(despesa);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @GetMapping("/mostrardespesa")
    public List<DespesaModel> listaDespesaModel() {
        return despesaRepository.findAll();
    }


}
