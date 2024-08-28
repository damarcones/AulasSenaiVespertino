package turistando.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.model.DespesaModel;
import turistando.model.VeiculoModel;
import turistando.repository.DespesaRepository;
import turistando.repository.VeiculoRepository;


@Service
public class DespesaServices {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;


    public DespesaModel registrarDespesa(DespesaModel despesa) throws Exception {

        if(despesa.getPlaca() == null){
            throw new Exception("Placa do veiculo invalido");
        }
        if(despesa.getDescricao() == null || despesa.getDescricao().isEmpty()){
            throw new Exception("Campo descrição não pode ser null");
        }
        if(despesa.getCategoria() == null){
            throw new Exception("Campo categoria não pode ser null");
        }
        if(despesa.getValor() < 0){
            throw new Exception("Campo valor não pode ser negativo ou null");
        }
        if (despesa.getValor() <=0 ) {
            throw new Exception("Campo valor precisa ser preenchido");
        }

        List <VeiculoModel> veiculos = veiculoRepository.findAll();

        for (VeiculoModel veiculo : veiculos) {

            if (veiculo.getPlaca().equals(despesa.getPlaca())) {

                veiculo.setDespesas(despesa);
                return despesaRepository.save(despesa);

            }else{
                throw new Exception("Veículo não informado ou inválido.");
            }                 
           
        }
        return despesaRepository.save(despesa);
    }
}
