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

import turistando.example.springturistando.model.DespesasModel;
import turistando.example.springturistando.services.DespesasService;

@RestController
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    private DespesasService despesasService;

    @PostMapping("/registrardespesa/{placa}")
    public ResponseEntity<DespesasModel> registrarDespesa(@PathVariable String placa, @RequestBody DespesasModel despesa) {
        DespesasModel novaDespesa = despesasService.salvarDespesa(placa, despesa);
        return new ResponseEntity<>(novaDespesa, HttpStatus.CREATED);
    }

    @GetMapping("/listardespesaplaca/{placa}")
    public ResponseEntity<List<DespesasModel>> listarDespesasPorVeiculo(@PathVariable String placa) {
        return ResponseEntity.ok(despesasService.listarDespesasPorVeiculo(placa));
    }
}
