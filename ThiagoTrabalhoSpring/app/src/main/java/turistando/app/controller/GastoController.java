package turistando.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import turistando.app.model.GastoModel;
import turistando.app.repository.GastoRepository;



@RestController
public class GastoController {

        @Autowired
        private GastoRepository gastoRepository;

        @PostMapping("/cadastrargasto")
        public GastoModel cadastrargasto (@RequestBody GastoModel gasto) {
            return gastoRepository.save(gasto);
        }
        // bug que mostra o historico de cadastro de todos os veiculos e não somente do veiculo selecionado pela placa.
        @GetMapping("/Mostrargastoveiculo/{id}")
        public List<GastoModel>listargastoveiculo () {
            return gastoRepository.findAll();
        }
        @GetMapping("/mostrargastogeral")
        public List<GastoModel>gastogeral() {
            return gastoRepository.findAll();
        }
}
