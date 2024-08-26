package com.turistando.sistematuristando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.source.doctree.ReturnTree;
import com.turistando.sistematuristando.model.AbastecimentoModel;
import com.turistando.sistematuristando.model.VeiculoModel;
import com.turistando.sistematuristando.repository.AbastecimentoRepository;
import com.turistando.sistematuristando.repository.VeiculoRepository;

@Service
public class VeiculoServices {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    
    public VeiculoModel registrarVeiculo (VeiculoModel veiculo) throws Exception{

        //Tratamento de valores null e invalido;

        // if(veiculo.getAnoFabricacao() < 1){
        //     throw new Exception("Campo ano de fabricação não pode ser null ou negativo");
        // }
        // if(veiculo.getAnoModelo() < 1 ){
        //     throw new Exception("Campo ano de modelo não pode ser null ou negativo");
        // }
        if(veiculo.getMarca() == null){
            throw new Exception("Campo marca não pode ser null ou vazio");
        }
        // if(veiculo.getModelo() == null ){
        //     throw new Exception("Campo marca não pode ser null ou vazio");
        // }
        // if(veiculo.getCapacidadeTanque() < 1){
        //     throw new Exception("Campo capacidade do tanque não pode ser negativa");
        // }
        

        return veiculoRepository.save(veiculo);
    }
    
    
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
