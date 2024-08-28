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


        //Tratamento de valores null e invalido

        if (abastecimento.getData() == null) {
            throw new Exception("Campo data não pode ser null");
        }

        if (abastecimento.getTipoCombustivel() == null) {
            throw new Exception("Campo tipo combustivel não pode ser null");
        }

        if (abastecimento.getValorTotal() < 1) {
            throw new Exception("Valor do abastecimento não pode ser negativo");
        }
        
        // veiculo null ou invalido;
        if (abastecimento.getVeiculo() == null || abastecimento.getVeiculo().getPlaca() == null) {
            throw new Exception("Veículo não informado ou inválido.");
        }
        
        VeiculoModel veiculo = veiculoRepository.findById(abastecimento.getVeiculo().getPlaca())
        .orElse(null);
        // veiculo existe;
        if (veiculo == null) {
            throw new Exception("Veículo não encontrado");
        }
        // seta o veiculo ao abastecimento;
        abastecimento.setVeiculo(veiculo);

        
        // limite da capacidade do tanque;
        if (abastecimento.getQuantidadeCombustivel() > veiculo.getCapacidadeTanque()) {
            throw new Exception("Quantidade de combustível maior que q a suportada");
        }

        // quilometragem menor q anterior;
        List<AbastecimentoModel> abastecimentosAnteriores = abastecimentoRepository
                .findByVeiculoPlaca(veiculo.getPlaca());
        double maiorQuilometragemAnterior = 0;
        for (AbastecimentoModel abastecimentoAnterior : abastecimentosAnteriores) {
            if (abastecimentoAnterior.getQuilometragem() > maiorQuilometragemAnterior) {
                maiorQuilometragemAnterior = abastecimentoAnterior.getQuilometragem();
            }
        }
        if (abastecimento.getQuilometragem() <= maiorQuilometragemAnterior) {
            throw new Exception(
                    "A quilometragem informada deve ser maior do que a quilometragem registrada anteriormente.");
        }

        // verifica tipo combustivel;
        if (!isCombustivelAceito(veiculo, abastecimento)) {
            throw new Exception(
                    "O tipo de combustível selecionado não é aceito neste veículo. Confirme os dados e tente novamente.");
        }


        //save
        return abastecimentoRepository.save(abastecimento);
    }

    // Esse metodo puxa no banco as informações de CombusvelAceito e o tipo
    // informado pelo usuario e returna um boleano pelo accpets(metodo de controle
    // de compatibilidade)
    private boolean isCombustivelAceito(VeiculoModel veiculo, AbastecimentoModel abastecimento) {

        // Obtém o tipo de combustível aceito pelo veículo
        CombustiveisAceitos combustivelVeiculo = veiculo.getCombustiveisAceitos();
        TipoCombustiveis combustivelAbastecimento = abastecimento.getTipoCombustivel();

        // Verifica se o combustível do abastecimento é aceito pelo veículo
        return combustivelVeiculo.accepts(combustivelAbastecimento);

    }

    
    public List<AbastecimentoModel> getAbastecimentoPorPlaca(String placa) throws Exception {
        Optional<VeiculoModel> obj = veiculoRepository.findById(placa);
        if (!(obj.isPresent())) {
            throw new Exception("Veículo não localizado no banco de dados.");
        }

        List<AbastecimentoModel> abastecimentos = abastecimentoRepository.findByVeiculoPlaca(placa);

        if (!abastecimentos.isEmpty()) {
            return abastecimentos;
        } else {
            throw new Exception("Nenhum Abastecimento localizado no banco de dados.");
        }

    }

}
