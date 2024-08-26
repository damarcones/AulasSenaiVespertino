package com.turistando.sistematuristando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistando.sistematuristando.model.GastoModel;
import com.turistando.sistematuristando.model.VeiculoModel;
import com.turistando.sistematuristando.repository.GastoRepository;
import com.turistando.sistematuristando.repository.VeiculoRepository;

@Service
public class GastoServices {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private GastoRepository gastoRepository;

    public List<GastoModel> getGastosPorPlaca(String placa) throws Exception{
        Optional<VeiculoModel> obj = veiculoRepository.findById(placa);
        if(!(obj.isPresent())){
            throw new Exception("Veículo não localizado no banco de dados."); 
        }
        
        List<GastoModel> gastos = gastoRepository.findByVeiculoPlaca(placa);

        if (!gastos.isEmpty()) {
            return gastos;
        }else{
            throw new Exception("Nenhum Gasto localizado no banco de dados.");
        }

    }
}
