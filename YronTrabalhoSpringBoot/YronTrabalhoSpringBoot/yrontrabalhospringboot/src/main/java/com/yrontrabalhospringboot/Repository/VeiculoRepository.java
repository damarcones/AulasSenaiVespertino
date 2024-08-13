package com.yrontrabalhospringboot.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yrontrabalhospringboot.Model.VeiculoModel;

public class VeiculoRepository {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping("/cadastrarveiculo")
    public VeiculoModel cadastrarveiculo(@RequestBody VeiculoModel veiculo){
        return veiculoRepository.save(veiculo);
    }

    private VeiculoModel save(VeiculoModel veiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
