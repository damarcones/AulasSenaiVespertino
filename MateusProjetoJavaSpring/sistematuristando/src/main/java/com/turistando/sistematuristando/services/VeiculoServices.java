package com.turistando.sistematuristando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistando.sistematuristando.model.AbastecimentoModel;
import com.turistando.sistematuristando.model.VeiculoModel;
import com.turistando.sistematuristando.repository.IAbastecimentoRepository;
import com.turistando.sistematuristando.repository.IVeiculoRepository;

@Service
public class VeiculoServices {

    @Autowired
    private IAbastecimentoRepository abastecimentoRepository;

    @Autowired
    private IVeiculoRepository veiculoRepository;

    public double calcularConsumoMedio(String placa) throws Exception {
        
        Optional<VeiculoModel> obj = veiculoRepository.findById(placa);
        if(!(obj.isPresent())){
            throw new Exception("Veículo não localizado no banco de dados."); 
        }
        
        List<AbastecimentoModel> abastecimentos = abastecimentoRepository.findByVeiculoPlaca(placa);

        if (abastecimentos.size() < 2) {
            throw new Exception("Não há abastecimentos suficientes para calcular o consumo do veículo.");
        }

        double totalQuilometros = 0.0;
        double totalLitros = 0.0;

        AbastecimentoModel abastecimentoAnterior = null;
        for (AbastecimentoModel abastecimento : abastecimentos) {
            if (abastecimentoAnterior != null) {
                double quilometrosPercorridos = abastecimento.getQuilometragem() - abastecimentoAnterior.getQuilometragem();
                totalQuilometros += quilometrosPercorridos;
                totalLitros += abastecimento.getQuantidadeCombustivel();
            }
            abastecimentoAnterior = abastecimento;
        }

        return totalQuilometros / totalLitros;
    }

}
