package turistando.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.model.AbastecimentoModel;
import turistando.model.VeiculoModel;
import turistando.repository.AbastecimentoRepository;
import turistando.repository.VeiculoRepository;

@Service
public class VeiculoServices {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    public VeiculoModel registrarVeiculo(VeiculoModel veiculo) throws Exception {

      if(veiculo.getPlaca() == null){
        throw new Exception("Placa do veiculo invalido");
      }
      if(veiculo.getMarca() == null){
        throw new Exception("Marca do veiculo Obrigatória");
      }
      if(veiculo.getModelo() == null){
        throw new Exception("Modelo do veiculo Obrigatório");
      }
      if(veiculo.getAnoModelo() <= 0){
        throw new Exception("Ano Modelo Obrigatório");
      }
      if(veiculo.getAnoFabricacao() <= 0){
        throw new Exception("Ano Fabricacao Obrigatório");
      }
      if(veiculo.getRenavam() <= 0){
        throw new Exception("Renavam do veiculo Obrigatório");
      }
      if(veiculo.getMotorizacao() <= 0){
        throw new Exception("Motorização do veiculo Obrigatório");
      }
      if(veiculo.getCapacidadeTanque() <= 0){
        throw new Exception("Capacidade do Tanque do veiculo Obrigatório");
      }
      if(veiculo.getCombustivel() == null){
        throw new Exception("Tipo de combustível do veiculo Obrigatório");
      }
      if(veiculo.getQuantidadeCombustivel() <= 0){
        throw new Exception("Quantidade Combustivel do veiculo Obrigatório");
      }
      
      return veiculoRepository.save(veiculo);      
    }

    public double consumoMedio(VeiculoModel veiculo) throws Exception {

      List<AbastecimentoModel> abastecimentos = abastecimentoRepository.findAll();

      if(abastecimentos.isEmpty() || abastecimentos.size() < 2){
        throw new Exception("Precisa de no mínimo 2 abastecimentos para calcular a média de consumo.");
      }
      if(veiculo.getAbastecimentos() == null){
        throw new Exception("Precisa de no mínimo 2 abastecimentos para calcular a média de consumo.");
      }

      double quilometragemTotal = 0;
      double abastecimentoTotal = 0;
      double mediaConsumo = 0;

      for (AbastecimentoModel abastecimento : abastecimentos) {
  
          if (veiculo.getPlaca().equals(abastecimento.getPlaca())) {
            quilometragemTotal += abastecimento.getQuilometragem();
            abastecimentoTotal += abastecimento.getQuantidadeCombustivel();
            mediaConsumo = abastecimentoTotal/quilometragemTotal;
          }

          }

        return mediaConsumo;


    }



}
