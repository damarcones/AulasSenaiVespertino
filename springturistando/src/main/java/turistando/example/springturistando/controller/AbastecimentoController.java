package turistando.example.springturistando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import turistando.example.springturistando.model.AbastecimentoModel;
import turistando.example.springturistando.services.AbastecimentoService;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService abastecimentoService;

    @PostMapping("/registrarabastecimento/{placa}")
    public ResponseEntity<AbastecimentoModel> registrarAbastecimento(@PathVariable String placa, @RequestBody AbastecimentoModel abastecimento) {
        AbastecimentoModel novoAbastecimento = abastecimentoService.salvarAbastecimento(placa, abastecimento);
        return new ResponseEntity<>(novoAbastecimento, HttpStatus.CREATED);
    }

    @GetMapping("/listarabastecimentoplaca/{placa}")
    public ResponseEntity<List<AbastecimentoModel>> listarAbastecimentosPorVeiculo(@PathVariable String placa) {
        return ResponseEntity.ok(abastecimentoService.listarAbastecimentosPorVeiculo(placa));
    }
}
