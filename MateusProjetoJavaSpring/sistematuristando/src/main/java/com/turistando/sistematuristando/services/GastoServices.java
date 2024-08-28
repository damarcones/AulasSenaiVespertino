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


    public GastoModel registrarGasto(GastoModel gasto) throws Exception {

        if(gasto.getData() == null){
            throw new Exception("Campo data não pode ser null");
        }
        if(gasto.getDescricao() == null || gasto.getDescricao().isEmpty()){
            throw new Exception("Campo descrição não pode ser null");
        }
        if(gasto.getTipo() == null){
            throw new Exception("Campo tipo não pode ser null");
        }
        if(gasto.getValor() < 0){
            throw new Exception("Campo valor não pode ser negativo ou null");
        }
        if (gasto.getVeiculo() == null) {
            throw new Exception("Campo veículo não pode ser null ou vazio");
        }

        //save
        return gastoRepository.save(gasto);
    }




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
