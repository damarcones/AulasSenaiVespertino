
import javax.swing.JOptionPane;

public class CadastrarVeiculo {

    private static Object veiculoset;

    public static void CadastrarVeiculo(){
        Veiculo veiculo =  new Veiculo();

        veiculoset.Marca(JOptionPane.showInputDialog("Marca do veículo:"));
        veiculoset.Modelo(JOptionPane.showInputDialog("Modelo do veículo:"));
        veiculoset.AnoFabricacao(JOptionPane.showInputDialog("Ano de fabricação:"));
        veiculoset.AnoModelo(JOptionPane.showInputDialog("Ano do modelo do veículo:"));
        veiculoset.Motorizado(JOptionPane.showInputDialog("Motorizaçaõ do veículo:"));
        veiculoset.CapacidadeTanque(JOptionPane.showInputDialog("Capacidade do tanque (em litros):"));
        veiculoset.Combustivel(JOptionPane.showInputDialog("Tipo de combustivel do veículo:"));
        veiculoset.Cor(JOptionPane.showInputDialog("Cor do veículo:"));
        veiculoset.Placa(JOptionPane.showInputDialog("Placa do veículo:"));
        veiculoset.Renavam(JOptionPane.showInputDialog("Renavam do veículo:"));

        veiculo.add(veiculo);
        JOptionPane.showInputDialog("Veículo cadastrado com sucesso!");
        
    }

    private static class Veiculo {

        public Veiculo() {
        }

        private void add(Veiculo veiculo) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
