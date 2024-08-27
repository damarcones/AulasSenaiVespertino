package ryantrabalhospring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Abastecimento> listarTodos() {
        return abastecimentoRepository.findAll();
    }

    public Abastecimento salvar(Abastecimento abastecimento) {
        // Verificar  se o veículo está cadastrado
        if (!veiculoRepository.existsById(abastecimento.getVeiculo().getId())) {
            throw new VeiculoNaoCadastradoException("O veículo informado  não está cadstrado  no sistema.");
        }

        // Verificar se o tipo de combustível é válido
         if (!TipoCombusitvel.isCombustivelValido(abastecimento.getVeiculo().getCombustivel().name())) {
            throw new CombustivelInvalidoException("O tipo de combustível informado não é válido.");
        }
        
        // Verificar se há informações em branco
        if (abastecimento.getValor() <= 0 || abastecimento.getQuantidadeCombustivel() <= 0 || abastecimento.getQuilometragemAtual() <= 0) {
            throw new InformacaoEmBrancoException("Todos os campos obrigatórios devem ser preenchidos.");
        }

        // Verificar se o valor é válido 
        if (abastecimento.getValor() < 0 || abastecimento.getQuantidadeCombustivel() < 0) {
            throw new ValorInvalidoException("O valor informado é inválido. Valores negativos não são permitidos.");
        }

        return abastecimentoRepository.save(abastecimento);
    }

    public Abastecimento buscarPorId(long id) {
        return abastecimentoRepository.findById(id).orElse(null);
    }

    public double calcularConsumoMedio(Long veiculoId) {
        List<Abastecimento> abastecimentos = abastecimentoRepository.findByVeiculoId(veiculoId);
        if (abastecimentos.size() < 2) {
            throw new IllegalArgumentException("É necessário pelo menos dois abastecimentos completos para calcular o consumo médio.");
        }

        double totalQuilometragem = 0;
        double totalCombustivel = 0;

        for (int i = 1; i < abastecimentos.size(); i++) {
            Abastecimento anterior = abastecimentos.get( i - 1);
            Abastecimento atual = abastecimentos.get(i); 
            
            totalQuilometragem += atual.getQuilometragemAtual() - anterior .getQuilometragemAtual();
            totalCombustivel += atual.getQuantidadeCombustivel();
        }

        return totalQuilometragem / totalCombustivel;
    }

    public void deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

}

