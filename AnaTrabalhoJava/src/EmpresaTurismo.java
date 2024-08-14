import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpresaTurismo {
    public static void main(String[] args) {
        
        List<Veiculos> veiculo = new ArrayList<>();
        List<Abastecimento> Abastecimento = new ArrayList<>();
        List<Gasto> gastos = new ArrayList<>();

        while(true) {

            String opcao = JOptionPane.showInputDialog("Selecione uma opção:\n1 - Cadastrar veículo\n2 - Cadastrar gasto\n3 - Calcular consumo de combustivel\n4 - Vizualizar relatorios\n5 - Sair\n6 ");
            switch (opcao) {
                case "1":
                 CadastrarVeiculo();
                break;

                case "2":
                CadastrarAbastecimento();
                break;

                case "3":
                CadastrarGasto();
                break;

                case "4":
                CalcularConsumoCombustivel();
                break;

                case "5":
                VizualizarRelatorio();
                break;

                case "6":
                System.exit(0);

                default:
                JOptionPane.showMessageDialog(null, "Opção Invalida");
               
            }
        }
    }

    private static void CalcularConsumoCombustivel() {
        
        throw new UnsupportedOperationException("Unimplemented method 'CalcularConsumoCombustivel'");
    }

    private static void VizualizarRelatorio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'VizualizarRelatorio'");
    }

    private static void CadastrarGasto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void CadastrarAbastecimento() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void CadastrarVeiculo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
