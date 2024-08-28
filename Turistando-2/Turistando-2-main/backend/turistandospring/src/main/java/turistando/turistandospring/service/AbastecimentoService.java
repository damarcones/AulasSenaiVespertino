package turistando.turistandospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turistando.turistandospring.Enum.CombustivelEnum;
import turistando.turistandospring.Enum.TipoAbastecimento;
import turistando.turistandospring.Exception.Excecao;
import turistando.turistandospring.model.AbastecimentoModel;
import turistando.turistandospring.model.VeiculoModel;
import turistando.turistandospring.repository.AbastecimentoRepository;
import turistando.turistandospring.repository.VeiculoRepository;

import java.util.List;

@Service
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    // Criar um novo abastecimento
    public AbastecimentoModel createAbastecimento(AbastecimentoModel abastecimentoModel) throws Exception {
        VeiculoModel veiculo = veiculoRepository.findById(abastecimentoModel.getVeiculo().getPlaca())
                .orElseThrow(() -> new Excecao("Veículo não encontrado com a placa: " + abastecimentoModel.getVeiculo().getPlaca()));

        // Verifica se o veículo é Flex
        if (veiculo.getCombustivel() == CombustivelEnum.Flex) {
            if (!abastecimentoModel.getTipoAbastecimento().equals(TipoAbastecimento.GASOLINA) &&
                !abastecimentoModel.getTipoAbastecimento().equals(TipoAbastecimento.ALCOOL)) {
                throw new Exception ("Veículo Flex pode ser abastecido apenas com Gasolina ou Álcool.");
            }
        }

        return abastecimentoRepository.save(abastecimentoModel);
    }

    // Obter todos os abastecimentos
    public List<AbastecimentoModel> getAllAbastecimentos() {
        return abastecimentoRepository.findAll();
    }

    // Obter um abastecimento por ID
    public AbastecimentoModel getAbastecimentoById(Long id) throws Excecao {
        return abastecimentoRepository.findById(id)
                .orElseThrow(() -> new Excecao("Abastecimento não encontrado com o ID: " + id));
    }

    // Atualizar um abastecimento existente
    public AbastecimentoModel updateAbastecimento(Long id, AbastecimentoModel updatedAbastecimento) throws Excecao {
        if (abastecimentoRepository.existsById(id)) {
            updatedAbastecimento.setId(id);
            return abastecimentoRepository.save(updatedAbastecimento);
        }
        throw new Excecao("Abastecimento não encontrado com o ID: " + id);
    }

    // Deletar um abastecimento por ID
    public boolean deleteAbastecimento(Long id) {
        if (abastecimentoRepository.existsById(id)) {
            abastecimentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Calcular o consumo médio de combustível por litro
    public double calcularConsumoMedioPorLitro(String placa) {
        List<AbastecimentoModel> abastecimentos = abastecimentoRepository.findByVeiculoPlacaOrderByQuilometragemAsc(placa);
        
        if (abastecimentos.size() < 2) {
            throw new IllegalArgumentException("Não há abastecimentos suficientes para calcular o consumo médio.");
        }
        
        double totalQuilometros = 0;
        double totalLitros = 0;
        
        for (int i = 1; i < abastecimentos.size(); i++) {
            AbastecimentoModel anterior = abastecimentos.get(i - 1);
            AbastecimentoModel atual = abastecimentos.get(i);
            
            int quilometragemAnterior = anterior.getQuilometragem();
            int quilometragemAtual = atual.getQuilometragem();
            double litrosAbastecidos = atual.getQuantidade();
            
            totalQuilometros += quilometragemAtual - quilometragemAnterior;
            totalLitros += litrosAbastecidos;
        }
        
        return totalQuilometros / totalLitros;
    }

    // Obter abastecimentos por placa do veículo
    public List<AbastecimentoModel> getAbastecimentoByPlaca(String placa) {
        return abastecimentoRepository.findByPlaca(placa);
    }
}
