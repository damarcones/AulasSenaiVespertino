
import javax.swing.JOptionPane;

public class CalcularConsumoAbastecimento {

    public static void CalcularConsumoAbastecimento() {
        

        if(Abastecimento.size()<2){
            JOptionPane.showMessageDialog(null, "É necessário ter pelo menos dois  abastecimentos completos para calcular o consumo.");
            return;
        }
        Double quilometrosTotais = Abastecimento.get(Abastecimento.size() - 1).getQuilometragemAtual() - Abastecimento.get(0).getQuilometragemAtual();
        int litrosConsumidos = 0;

        for(int i = 1;i< Abastecimento.size(): i++) {

            double diferencaQuilometragem = Abastecimento.get(i).getQuilometragemAtual() - Abastecimento.get(0).getQuilometragemAtual();
            litrosConsumidos+= Abastecimento.get(i).getQuantidadeCombustivel();
        }
        double consumoMedio = quilometrosTotais/litrosConsumidos;
        JOptionPane.showMessageDialog(null, "O consumo médio é de:"+ consumoMedio + "km/l");
    }
}



// Tipos de abastecimentos gasolina alcool ou se o carro aceita os 2(flex)