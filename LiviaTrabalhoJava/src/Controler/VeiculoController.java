package Controler;

import Exception.AbastecimentosInsuficientesException;
import Exception.ValorInvalidoException;
import Exception.VeiculoNaoCadastradoException;
import Turistandomodel.Abastecimento;
import Turistandomodel.Gasto;
import Turistandomodel.Veiculo;
import java.time.LocalDate;
import java.util.*;

public class VeiculoController {
    
       private Veiculo veiculo;
    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }




    public void registrarGasto(Gasto gasto,String categoria, String descricao, double valor, LocalDate data,String placa ) throws VeiculoNaoCadastradoException, ValorInvalidoException {
        if (veiculo == null) {
            throw new VeiculoNaoCadastradoException("Veículo não cadastrado.");
        }

        if (valor < 0) {
            throw new ValorInvalidoException("O valor do gasto não pode ser negativo.");
        }
        veiculo.getGastos().add(gasto
);
    }


     public double calcularConsumoMedio() throws AbastecimentosInsuficientesException {

        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();
        int numAbastecimentos = abastecimentos.size();
    
        if (numAbastecimentos < 2) {
            throw new AbastecimentosInsuficientesException("A média só pode ser calculada depois de dois abastecimentos.");
        }
    
        Abastecimento primeiroAbastecimento = abastecimentos.get(0);
        Abastecimento ultimoAbastecimento = abastecimentos.get(numAbastecimentos - 1);
    
        double totalKm = ultimoAbastecimento.getQuilometragem() - primeiroAbastecimento.getQuilometragem();
        double totalLitros = 0;
    
        for (Abastecimento abastecimento : abastecimentos) {
            totalLitros += abastecimento.getQuantidadeCombustivel();
        }
    
        return totalKm / totalLitros;
    }

    public void adicionarGasto(Gasto gasto,String categoria, String descricao, double valor, LocalDate data) throws ValorInvalidoException {
        if (gasto == null) {
            throw new ValorInvalidoException("Gasto não pode ser nulo.");
        }
        veiculo.getGastos().add(gasto);
    }

    public List<Abastecimento> getAbastecimentos() {
        return veiculo.getAbastecimentos();
    }



    public double calcularGastoTotal() {
        List<Gasto> gastos = veiculo.getGastos();
        double[] gastoTotal = {0.0};
    
        gastos.forEach(gasto -> gastoTotal[0] += gasto.getValor());
    
        return gastoTotal[0];
    }
}

    
    

  
     
           
            
        



