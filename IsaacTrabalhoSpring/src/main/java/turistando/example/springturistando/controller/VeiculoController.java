package turistando.example.springturistando.controller;

import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import turistando.example.springturistando.model.VeiculoModel;
import turistando.example.springturistando.services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/cadastrarveiculo")
    public ResponseEntity<VeiculoModel> cadastrarVeiculo(@RequestBody VeiculoModel veiculo) {
        VeiculoModel novoVeiculo = veiculoService.salvarVeiculo(veiculo);
        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    @GetMapping("/listarveiculos")
    public ResponseEntity<List<VeiculoModel>> listarVeiculos() {
        return ResponseEntity.ok(veiculoService.listarVeiculos());
    }

    @GetMapping("/buscarveiculo/{placa}")
    public ResponseEntity<VeiculoModel> buscarVeiculo(@PathVariable String placa) {
        return ResponseEntity.ok(veiculoService.buscarVeiculoPorPlaca(placa));
    }

    @DeleteMapping("/excluirveiculo/{placa}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable String placa) {
        veiculoService.excluirVeiculo(placa);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consumo-medio/{placa}")
    public ResponseEntity<Double> calcularConsumoMedio(@PathVariable String placa) {
        double consumoMedio = veiculoService.calcularConsumoMedio(placa);
        return ResponseEntity.ok(consumoMedio);
    }

    @GetMapping("/relatorio/{placa}")
    public ResponseEntity<Map<String, Double>> gerarRelatorio(@PathVariable String placa) {
        Map<String, Double> relatorio = veiculoService.gerarRelatorioGeralPorCategoria(placa);
        return ResponseEntity.ok(relatorio);
    }

}
