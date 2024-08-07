
import javax.swing.JOptionPane;

public class VizualizarRelatorios {

    private static Iterable<Abastecimento> abastecimentos;
    private static Iterable<Gasto> Gastos;
    private static Object gastos;

    public static void VizualizarRelatorio() {
        if(Veiculo.isEmpty()&& abastecimento.isEmpty()&& gastos.isEmpty()&&){

            JOptionPane.showMessageDialog(null, "Não há dados cadastrados para exibir relatórios");
            return;
        }
        StringBuilder relatorio = new StringBuilder();
        String opcaoRelatorio = JOptionPane.showInputDialog("Selecione o tipo de relatório:\n1 - Relatório de veículos\n2 - Relatório de abastecimento\n3 - Relatório de gastos\n4 - Relatório geral");
        
            switch (opcaoRelatorio) {
                case "1" :
                    for(Veiculo veiculo : veiculos){
                        relatorio.append(veiculo.toString()).append("\n1");
                    }
                    break;

                case "2" :
                    for(Abastecimento abastecimento : abastecimentos){
                        relatorio.append(abastecimento.toString()).append("\n2");
                    }
                    break;

                    case "3":
                    for(Gasto gasto : Gastos){
                        relatorio.append(relatorio.toString()).append("\n");
                    }
                    break;

                    case "4":
                    relatorio.append("Relatório de veículos:\n");
                    for(Veiculo veiculo : Veiculos){
                        relatorio.append(veiculo.toString()).append("\n");
                    }
                    relatorio.append("\nRelatório de abastecimento:\n");
            {
                Iterable<Abastecimento> Abastecimentos = null;
                for(Abastecimento abastecimento : Abastecimentos){
                    relatorio.append(abastecimento.toString()).append("\n");
                }
            }
                    relatorio.append("\nRelatório de gastos:\n");
                    for(Gasto gasto : Gastos){
                        relatorio.append(gastos.toString()).append("\n");
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção de relatório inválida");
            }
            JOptionPane.showMessageDialog(null,relatorio.toString());
    }
}
