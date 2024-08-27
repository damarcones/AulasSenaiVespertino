package turistando.turistandospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import turistando.turistandospring.Enum.TipoGasto;
import turistando.turistandospring.Exception.Excecao;
import turistando.turistandospring.model.GastoModel;

import turistando.turistandospring.service.GastoService;

import java.util.List;


@RestController
@RequestMapping("/gasto")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<GastoModel> cadastrarGasto(@RequestBody GastoModel gasto) {
        GastoModel savedGasto = gastoService.createGasto(gasto);
        return new ResponseEntity<>(savedGasto, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<GastoModel>> listarGastos() {
        List<GastoModel> gastos = gastoService.getAllGastos();
        return new ResponseEntity<>(gastos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastoModel> obterGasto(@PathVariable Long id) {
        try {
            GastoModel gasto = gastoService.getGastoById(id);
            return new ResponseEntity<>(gasto, HttpStatus.OK);
        } catch (Excecao e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<GastoModel> modificarGasto(@PathVariable Long id, @RequestBody GastoModel gasto) {
        try {
            GastoModel updatedGasto = gastoService.updateGasto(id, gasto);
            return new ResponseEntity<>(updatedGasto, HttpStatus.OK);
        } catch (Excecao e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> apagarGasto(@PathVariable Long id) {
        boolean deleted = gastoService.deleteGasto(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categoria/{placa}/{categoria}")
    public ResponseEntity<List<GastoModel>> relatorioPorCategoria(
            @PathVariable String placa, 
            @PathVariable TipoGasto categoria) {
        List<GastoModel> gastos = gastoService.getGastosPorCategoriaEPlaca(placa, categoria);
        return new ResponseEntity<>(gastos, HttpStatus.OK);
    }

    @GetMapping("/geral/{placa}")
    public ResponseEntity<List<GastoModel>> relatorioGeral(@PathVariable String placa) {
        List<GastoModel> gastos = gastoService.getGastosPorPlaca(placa);
        return new ResponseEntity<>(gastos, HttpStatus.OK);
    }
}
