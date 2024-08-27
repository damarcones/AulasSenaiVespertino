package turistando.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.model.AbastecimentoModel;
import turistando.model.VeiculoModel;
import turistando.repository.AbastecimentoRepository;
import turistando.repository.VeiculoRepository;

@Service
public class AbastecimentoServices {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    // @Autowired
    //private DespesaRepository despesaRepository;
    
    public AbastecimentoModel registrarAbastecimento(AbastecimentoModel abastecimento) throws Exception {

        // Recupera todos os abastecimentos do mesmo veículo
        List<AbastecimentoModel> abastecimentos = abastecimentoRepository.findAll();

        // Verifica se existem abastecimentos anteriores
        if (!abastecimentos.isEmpty()) {
            // Encontra o abastecimento com a maior quilometragem
            AbastecimentoModel ultimoAbastecimento = abastecimentos.stream()
                .max(Comparator.comparingDouble(AbastecimentoModel::getQuilometragem))
                .orElse(null);

            if (ultimoAbastecimento != null && abastecimento.getQuilometragem() <= ultimoAbastecimento.getQuilometragem()) {
                throw new Exception("A quilometragem do abastecimento atual deve ser maior do que a quilometragem do abastecimento anterior.");
            }
        }
  
    if (abastecimento.getPlaca() == null) {
        throw new Exception("Veículo não informado ou inválido.");
    }
    if (abastecimento.getData() == null) {
        throw new Exception("Campo data Obrigatório.");
    }
    if (abastecimento.getQuantidadeCombustivel() <= 0){
        throw new Exception("Campo Quantidade de combustivel obrigatória Obrigatório.");
    }   
    if (abastecimento.getValorAbastecido() <= 0){
        throw new Exception("Campo Valor precisa ser maior que zero.");
    }   
    if (abastecimento.getQuilometragem() <= 0){ // corrigir
        throw new Exception("Campo Quilometragem precisa ser maior que a quilometragem anterior.");
    }       
    
    List <VeiculoModel> veiculos = veiculoRepository.findAll();

    for (VeiculoModel veiculo : veiculos) {

        if (veiculo.getPlaca().equals(abastecimento.getPlaca())) {

            if (!veiculo.getCombustivel().equals(abastecimento.getTipoCombustivel())) {
                throw new Exception("Tipo de combustivel incopativel, abasteça: "+veiculo.getCombustivel());
            }

            if (veiculo.getCapacidadeTanque() < abastecimento.getQuantidadeCombustivel()) {
                throw new Exception("litros abastecidos Não podem utrapassar a capacidade máxima do veiculo");
            }
            if (abastecimento.getQuantidadeCombustivel() > (veiculo.getCapacidadeTanque() - veiculo.getQuantidadeCombustivel())) {
                throw new Exception("litros utrapassam a capacidade atual do tanque em: "+ (veiculo.getCapacidadeTanque() - veiculo.getQuantidadeCombustivel())+" litros");
            }
            veiculo.setQuantidadeCombustivel(veiculo.getQuantidadeCombustivel()+ abastecimento.getQuantidadeCombustivel());
            veiculo.setAbastecimentos(abastecimento);

            // Inserir nova despesa em todo novo abastecimento
            // try {
            //     // Cria uma nova despesa
            //     DespesaModel despesa = new DespesaModel();
            //     despesa.setNome("Abastecimento");
            //     despesa.setValor(abastecimento.getValorAbastecido()); // Supondo que já seja um double
            //     despesa.setPlaca(abastecimento.getPlaca());
            //     despesa.setCategoria("Abastecimento");
            //     despesa.setDescricao("Abasteceu " + abastecimento.getQuantidadeCombustivel() + " Litros");

            //     // Salva a nova despesa
            //     despesaRepository.save(despesa);
            // } catch (Exception e) {
            //     // Opcionalmente, você pode re-lançar a exceção se quiser que ela seja tratada em um nível superior
            //     throw new RuntimeException("Erro ao processar o abastecimento e salvar a despesa.", e);                
            // }
            
            return abastecimentoRepository.save(abastecimento);
        }
        else{
            throw new Exception("Veículo não informado ou inválido.");
        }
    }

    return abastecimentoRepository.save(abastecimento);

    }

}
