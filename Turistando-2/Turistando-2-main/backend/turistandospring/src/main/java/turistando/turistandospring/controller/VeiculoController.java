package turistando.turistandospring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import turistando.turistandospring.Exception.Excecao;
import turistando.turistandospring.model.VeiculoModel;
import turistando.turistandospring.service.AbastecimentoService;
import turistando.turistandospring.service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private AbastecimentoService abastecimentoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<VeiculoModel> cadastrarVeiculo(@RequestBody VeiculoModel veiculo) {
        VeiculoModel savedVeiculo = veiculoService.createVeiculo(veiculo);
        return new ResponseEntity<>(savedVeiculo, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<VeiculoModel>> listarVeiculos() {
        List<VeiculoModel> veiculos = veiculoService.getAllVeiculos();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoModel> obterVeiculo(@PathVariable String placa) {
        try {
            VeiculoModel veiculo = veiculoService.getVeiculoByPlaca(placa);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        } catch (Excecao e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping("/modificar/{placa}")
    public ResponseEntity<VeiculoModel> modificarVeiculo(@PathVariable String placa, @RequestBody VeiculoModel veiculo) {
        try {
            VeiculoModel updatedVeiculo = veiculoService.updateVeiculo(placa, veiculo);
            return new ResponseEntity<>(updatedVeiculo, HttpStatus.OK);
        } catch (Excecao e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @DeleteMapping("/apagar/{placa}")
    public ResponseEntity<Void> apagarVeiculo(@PathVariable String placa) {
        boolean deleted = veiculoService.deleteVeiculo(placa);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/consumo")
    public ResponseEntity<Double> calcularConsumo(@PathVariable String id) {
        double consumoMedio = abastecimentoService.calcularConsumoMedioPorLitro(id);
        return ResponseEntity.ok(consumoMedio);
    }
}
