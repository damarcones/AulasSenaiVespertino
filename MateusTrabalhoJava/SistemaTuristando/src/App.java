import com.controle.SistemaTuristando;
import com.veiculo.Veiculo;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
       SistemaTuristando sistema = new SistemaTuristando();

        JFrame frame = new JFrame("Sistema de Gestão de Veículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel view = new JPanel();
        view.setLayout(new GridLayout(0, 1, 10, 10));

        JButton listarVeiculosButton = new JButton("Listar Veículos");
        JButton listarGastosButton = new JButton("Listar Gastos");
        JButton listarAbastecimentosButton = new JButton("Listar Abastecimentos");
        JButton adicionarVeiculoButton = new JButton("Adicionar Veículo");
        
        JButton registrarGastoButton = new JButton("Registrar Gasto");
        String[] gastosOptions = {"Manutenção", "Imposto", "Multa", "Outros"};
        JComboBox<String> registrarGastoComboBox = new JComboBox<>(gastosOptions);

        JButton registrarAbastecimentoButton = new JButton("Registrar Abastecimento");

        JButton calcularConsumoButton = new JButton("Calcular Consumo Médio");
        String[] consumoOptions = {"Todos os Veículos", "Um Único Veículo"};
        JComboBox<String> calcularConsumoComboBox = new JComboBox<>(consumoOptions);

        JButton gerarRelatorioButton = new JButton("Gerar Relatório");
        String[] relatorioOptions = {"Relatório Geral", "Relatório por Categoria"};
        JComboBox<String> gerarRelatorioComboBox = new JComboBox<>(relatorioOptions);
        
        String[] categoriaOptions = {"Veículos", "Abastecimentos", "Gastos"};
        JComboBox<String> categoriaComboBox = new JComboBox<>(categoriaOptions);
        categoriaComboBox.setVisible(false);

        // Add action listeners
        gerarRelatorioComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gerarRelatorioComboBox.getSelectedItem().equals("Relatório por Categoria")) {
                    categoriaComboBox.setVisible(true);
                } else {
                    categoriaComboBox.setVisible(false);
                }
            }
        });

        // Add components to the panel
        view.add(listarVeiculosButton);
        view.add(listarGastosButton);
        view.add(listarAbastecimentosButton);
        view.add(adicionarVeiculoButton);
        view.add(registrarGastoButton);
        view.add(registrarGastoComboBox);
        view.add(registrarAbastecimentoButton);
        view.add(calcularConsumoButton);
        view.add(calcularConsumoComboBox);
        view.add(gerarRelatorioButton);
        view.add(gerarRelatorioComboBox);
        view.add(categoriaComboBox);

        // Add the panel to the frame
        frame.add(view);
        frame.setVisible(true); 

                
       boolean adicionarMais = true;

        while (adicionarMais) {
            // Criação do painel
            JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

            // Criação dos componentes de entrada
            JTextField marcaField = new JTextField(10);
            JTextField modeloField = new JTextField(10);
            JTextField anoFabricacaoField = new JTextField(10);
            JTextField anoModeloField = new JTextField(10);
            JTextField motorizacaoField = new JTextField(10);
            JTextField capacidadeTanqueField = new JTextField(10);
            JComboBox<String> combustiveisBox = new JComboBox<>(new String[] {"Gasolina", "Álcool", "Diesel", "Flex", "GNV"});
            JTextField corField = new JTextField(10);
            JTextField placaField = new JTextField(10);
            JTextField renavamField = new JTextField(10);

            // Adição dos componentes ao painel
            panel.add(new JLabel("Marca:"));
            panel.add(marcaField);
            panel.add(new JLabel("Modelo:"));
            panel.add(modeloField);
            panel.add(new JLabel("Ano de Fabricação:"));
            panel.add(anoFabricacaoField);
            panel.add(new JLabel("Ano do Modelo:"));
            panel.add(anoModeloField);
            panel.add(new JLabel("Motorização:"));
            panel.add(motorizacaoField);
            panel.add(new JLabel("Capacidade do Tanque (litros):"));
            panel.add(capacidadeTanqueField);
            panel.add(new JLabel("Combustíveis Aceitos:"));
            panel.add(combustiveisBox);
            panel.add(new JLabel("Cor:"));
            panel.add(corField);
            panel.add(new JLabel("Placa:"));
            panel.add(placaField);
            panel.add(new JLabel("RENAVAM:"));
            panel.add(renavamField);

            // Exibir o painel em um JOptionPane
            int result = JOptionPane.showConfirmDialog(null, panel, "Informações do Veículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                // Coletar as informações inseridas
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                int anoFabricacao = Integer.parseInt(anoFabricacaoField.getText());
                int anoModelo = Integer.parseInt(anoModeloField.getText());
                String motorizacao = motorizacaoField.getText();
                double capacidadeTanque = Double.parseDouble(capacidadeTanqueField.getText());
                String combustiveisAceitos = (String) combustiveisBox.getSelectedItem();
                String cor = corField.getText();
                String placa = placaField.getText();
                String renavam = renavamField.getText();

                // Montar a informação para exibição
                String info = String.format(
                        "<html>Marca: %s<br>" +
                        "Modelo: %s<br>" +
                        "Ano de Fabricação: %d<br>" +
                        "Ano do Modelo: %d<br>" +
                        "Motorização: %s<br>" +
                        "Capacidade do Tanque: %.2f litros<br>" +
                        "Combustíveis Aceitos: %s<br>" +
                        "Cor: %s<br>" +
                        "Placa: %s<br>" +
                        "RENAVAM: %s</html>",
                        marca, modelo, anoFabricacao, anoModelo, motorizacao, capacidadeTanque, combustiveisAceitos, cor, placa, renavam
                );

                // Exibir a informação
                JOptionPane.showMessageDialog(null, new JLabel(info), "Informações do Veículo", JOptionPane.INFORMATION_MESSAGE);
                
                Veiculo v = new Veiculo(marca, modelo, anoFabricacao, anoModelo, motorizacao, capacidadeTanque, combustiveisAceitos, cor, placa, renavam);

                // Adicionar à lista de veículos
                sistema.adicionarVeiculo(v);


                // Perguntar se o usuário deseja adicionar outro veículo
                int continuar = JOptionPane.showConfirmDialog(null, "Deseja adicionar outro veículo?", "Continuar", JOptionPane.YES_NO_OPTION);
                if (continuar != JOptionPane.YES_OPTION) {
                    adicionarMais = false;
                }
            } else {
                adicionarMais = false;
            }
        }

        sistema.listarVeiculos();

        //sistema.exibirListaVeiculos();

    }
}
