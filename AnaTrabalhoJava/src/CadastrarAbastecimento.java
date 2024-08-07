
import javax.swing.JOptionPane;

public class CadastrarAbastecimento {

    private static void CadastrarAbastecimento(){

        Object veiculo = null;{
            JOptionPane.showMessageDialog(null, "Não há veículos cadastrados. Cadastre um veículo primeiro.");
            return;
        }

        Abastecimento abastecimento = new Abastecimento();
        Abastecimento.setvalorAbastecimento(Double.parseDouble(JOptionPane.showInputDialog("Valor do abasecimento:")));

        Abastecimento.setQuantidadeCombustivel(Double.parseDouble(JOptionPane.showInputDialog("Quantidade de combustivel abastecida (em litros):")));
        abastecimento.setQuilometragemAtual(Double.parseDouble(JOptionPane.showInputDialog("Quilometragem atual do veículo")));
        
        abastecimento.add(abastecimento);
        JOptionPane.showMessageDialog(null, "Abastecimento registardo com sucesso!");
    }
}
