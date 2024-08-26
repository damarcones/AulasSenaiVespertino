package com.turistando.sistematuristando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turistando.sistematuristando.Enum.CombustiveisAceitos;
import com.turistando.sistematuristando.Enum.TipoCombustiveis;
import com.turistando.sistematuristando.model.AbastecimentoModel;
import com.turistando.sistematuristando.model.VeiculoModel;
import com.turistando.sistematuristando.repository.AbastecimentoRepository;
import com.turistando.sistematuristando.repository.VeiculoRepository;

@Service
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public AbastecimentoModel registrarAbastecimento(AbastecimentoModel abastecimento) throws Exception {
        
        //campos vazios
        if (abastecimento.getVeiculo() == null || abastecimento.getVeiculo().getPlaca() == null) {
            throw new Exception("Veículo não informado ou inválido.");
        }


        VeiculoModel veiculo = veiculoRepository.findById(abastecimento.getVeiculo().getPlaca())    
        .orElse(null);
         
        if (veiculo == null) {
         throw  new Exception("Veículo não encontrado");
        } 

        //verifica tipo combustivel;
        if (!isCombustivelAceito(veiculo, abastecimento)) {
            throw new Exception("O tipo de combustível selecionado não é aceito neste veículo. Confirme os dados e tente novamente.");
        }

        //seta o veiculo ao abastecimento;
        abastecimento.setVeiculo(veiculo);

        //
        return abastecimentoRepository.save(abastecimento);
    }


    //Esse metodo puxa no banco as informações de CombusvelAceito e o tipo informado pelo usuario e returna um boleano pelo accpets(metodo de controle de compatibilidade)
    private boolean isCombustivelAceito(VeiculoModel veiculo, AbastecimentoModel abastecimento) {
    
        // Obtém o tipo de combustível aceito pelo veículo
    CombustiveisAceitos combustivelVeiculo = veiculo.getCombustiveisAceitos();
    TipoCombustiveis combustivelAbastecimento = abastecimento.getTipoCombustivel();

    // Verifica se o combustível do abastecimento é aceito pelo veículo
    return combustivelVeiculo.accepts(combustivelAbastecimento);
    
    }


    public List<AbastecimentoModel> getAbastecimentoPorPlaca(String placa) throws Exception{
        Optional<VeiculoModel> obj = veiculoRepository.findById(placa);
        if(!(obj.isPresent())){
            throw new Exception("Veículo não localizado no banco de dados."); 
        }
        
        List<AbastecimentoModel> abastecimentos = abastecimentoRepository.findByVeiculoPlaca(placa);

        if (!abastecimentos.isEmpty()) {
            return abastecimentos;
        }else{
            throw new Exception("Nenhum Abastecimento localizado no banco de dados.");
        }

    }




}
