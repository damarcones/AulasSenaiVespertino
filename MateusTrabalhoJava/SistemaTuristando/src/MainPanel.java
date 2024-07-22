import com.controle.SistemaTuristando;
import com.veiculo.Veiculo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainPanel {
    public static void main(String[] args) {
        SistemaTuristando sistema = new SistemaTuristando();
        
        JFrame frame = new JFrame("Sistema de Gestão de Veículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));

        JButton listarVeiculosButton = new JButton("Listar Veículos");
        JButton listarGastosButton = new JButton("Listar Gastos");
        JButton listarAbastecimentosButton = new JButton("Listar Abastecimentos");
        JButton adicionarVeiculoButton = new JButton("Adicionar Veículo");
        JButton registrarGastoButton = new JButton("Registrar Gasto");
        JButton registrarAbastecimentoButton = new JButton("Registrar Abastecimento");
        JButton calcularConsumoButton = new JButton("Calcular Consumo Médio");
        JButton gerarRelatorioButton = new JButton("Gerar Relatório");

        // Add action listeners
        adicionarVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Veiculo veiculo = coletarInformacoesDoVeiculo();
                if (veiculo != null) {
                    JOptionPane.showMessageDialog(null, new JLabel(veiculo.toString()), "Informações do Veículo", JOptionPane.INFORMATION_MESSAGE);
                }
                
                sistema.adicionarVeiculo(veiculo);
            }
        });

        listarVeiculosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               sistema.listarVeiculos();
            }
        });


        // Adiciona os botões ao painel
        panel.add(listarVeiculosButton);
        panel.add(listarGastosButton);
        panel.add(listarAbastecimentosButton);
        panel.add(adicionarVeiculoButton);
        panel.add(registrarGastoButton);
        panel.add(registrarAbastecimentoButton);
        panel.add(calcularConsumoButton);
        panel.add(gerarRelatorioButton);

        // Adiciona o painel ao frame
        frame.add(panel);
        frame.setVisible(true);
    }

    private static Veiculo coletarInformacoesDoVeiculo() {
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

            // Retornar um novo objeto Veiculo com os dados inseridos
            return new Veiculo(marca, modelo, anoFabricacao, anoModelo, motorizacao, capacidadeTanque, combustiveisAceitos, cor, placa, renavam);
        } else {
            return null;
        }
    }
}
