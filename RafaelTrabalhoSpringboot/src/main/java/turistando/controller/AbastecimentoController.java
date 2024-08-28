package turistando.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import turistando.model.AbastecimentoModel;
import turistando.repository.AbastecimentoRepository;
import turistando.services.AbastecimentoServices;

@RestController
public class AbastecimentoController {
    
    @Autowired
    private AbastecimentoServices abastecimentoServices;

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    
    @PostMapping("/cadastrarabastecimento")
    public AbastecimentoModel cadastrarAbastecimento(@RequestBody AbastecimentoModel abastecimento) {
        try {
            return abastecimentoServices.registrarAbastecimento(abastecimento);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    
    @GetMapping("/listarabastecimento")
    public List<AbastecimentoModel> listaAbastecimentoModel() {
        return abastecimentoRepository.findAll();
        
    }

}
