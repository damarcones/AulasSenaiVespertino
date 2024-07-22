package view;

import exception.ExcecaoPersonalizada;
import model.Abastecimento;
import model.Despesa;
import model.Veiculo;
import controller.GerenciamentoVeiculos;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class InterfaceUsuario {
    public static void main(String[] args) {
        
        GerenciamentoVeiculos gerenciamento = new GerenciamentoVeiculos();

        
        while (true) {
           
            String[] options = {"Cadastrar Veículo", "Registrar Abastecimento", "Registrar Despesa", "Calcular Consumo Médio", "Listar Veículos", "Sair"};
            // Exibindo o menu vertical e obtendo a escolha do usuário
            int escolha = mostrarMenuVertical(options);

            switch (escolha) {
                case 0:
                    cadastrarVeiculo(gerenciamento);
                    break;
                case 1:
                    registrarAbastecimento(gerenciamento);
                    break;
                case 2:
                    registrarDespesa(gerenciamento);
                    break;
                case 3:
                    calcularConsumoMedio(gerenciamento);
                    break;
                case 4:
                    listarVeiculos(gerenciamento);
                    break;
                case 5:
                    System.exit(0); 
            }
        }
    }

    // Método para mostrar o menu com opções
    private static int mostrarMenuVertical(String[] options) {
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ButtonGroup buttonGroup = new ButtonGroup(); // Grupo de botões de opção
        JRadioButton[] radioButtons = new JRadioButton[options.length];

        // Adicionando botões de opção ao painel
        for (int i = 0; i < options.length; i++) {
            radioButtons[i] = new JRadioButton(options[i]);
            radioButtons[i].setActionCommand(String.valueOf(i));
            buttonGroup.add(radioButtons[i]);
            panel.add(radioButtons[i]);
        }

        // Exibindo o painel em uma caixa de diálogo
        int result = JOptionPane.showConfirmDialog(null, panel, "Escolha uma opção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Retornando o índice da opção selecionada
        if (result == JOptionPane.OK_OPTION) {
            for (int i = 0; i < radioButtons.length; i++) {
                if (radioButtons[i].isSelected()) {
                    return Integer.parseInt(radioButtons[i].getActionCommand());
                }
            }
        }
        return -1; 
    }

    // Método para cadastrar um veículo
    @SuppressWarnings("rawtypes")
    private static void cadastrarVeiculo(GerenciamentoVeiculos gerenciamento) {
        // Criação do painel com campos de entrada
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos de entrada para os dados do veículo
        JTextField marcaField = new JTextField(20);
        JTextField modeloField = new JTextField(20);
        JTextField anoFabricacaoField = new JTextField(4);
        JTextField anoModeloField = new JTextField(4);
        JTextField motorizacaoField = new JTextField(20);
        JTextField capacidadeTanqueField = new JTextField(10);
        JTextField combustiveisField = new JTextField(20);
        JTextField corField = new JTextField(15);
        JTextField placaField = new JTextField(10);
        JTextField renavamField = new JTextField(20);

        // Adicionando os campos e labels ao painel usando GridBagLayout (gerenciador de layout no Java Swing que permite criar interfaces gráficas de usuário (GUIs) complexas e flexíveis)
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Marca:"), gbc);
        gbc.gridx = 1;
        panel.add(marcaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Modelo:"), gbc);
        gbc.gridx = 1;
        panel.add(modeloField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Ano de Fabricação:"), gbc);
        gbc.gridx = 1;
        panel.add(anoFabricacaoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Ano do Modelo:"), gbc);
        gbc.gridx = 1;
        panel.add(anoModeloField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Motorização:"), gbc);
        gbc.gridx = 1;
        panel.add(motorizacaoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Capacidade do Tanque (litros):"), gbc);
        gbc.gridx = 1;
        panel.add(capacidadeTanqueField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Combustíveis (separados por vírgula):"), gbc);
        gbc.gridx = 1;
        panel.add(combustiveisField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Cor:"), gbc);
        gbc.gridx = 1;
        panel.add(corField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Placa:"), gbc);
        gbc.gridx = 1;
        panel.add(placaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Renavam:"), gbc);
        gbc.gridx = 1;
        panel.add(renavamField, gbc);

        // Exibindo o painel em uma caixa de diálogo
        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Veículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Processando os dados inseridos pelo usuário
        if (result == JOptionPane.OK_OPTION) {
            try {
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                int anoFabricacao = Integer.parseInt(anoFabricacaoField.getText());
                int anoModelo = Integer.parseInt(anoModeloField.getText());
                String motorizacao = motorizacaoField.getText();
                double capacidadeTanque = Double.parseDouble(capacidadeTanqueField.getText());
                String combustiveis = combustiveisField.getText();
                String cor = corField.getText();
                String placa = placaField.getText();
                String renavam = renavamField.getText();

                // Criando e cadastrando o veículo
                Veiculo veiculo = new Veiculo(marca, modelo, anoFabricacao, anoModelo, motorizacao, capacidadeTanque, combustiveis, cor, placa, renavam);
                gerenciamento.cadastrarVeiculo(veiculo);
                JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
            } catch (ExcecaoPersonalizada e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido inserido.");
            }
        }
    }

   
    @SuppressWarnings("rawtypes")
    private static void registrarAbastecimento(GerenciamentoVeiculos gerenciamento) {
        try {
            String placa = JOptionPane.showInputDialog("Digite a placa do veículo:");
            Veiculo veiculo = buscarVeiculoPorPlaca(gerenciamento, placa);

            if (veiculo == null) {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
                return;
            }

            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do abastecimento:"));
            double quantidadeCombustivel = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de combustível (em litros):"));
            int quilometragemAtual = Integer.parseInt(JOptionPane.showInputDialog("Digite a quilometragem atual do veículo:"));

            // Criando e registrando o abastecimento
            Abastecimento abastecimento = new Abastecimento(valor, quantidadeCombustivel, quilometragemAtual);
            gerenciamento.adicionarAbastecimento(veiculo, abastecimento);
            JOptionPane.showMessageDialog(null, "Abastecimento registrado com sucesso!");
        } catch (ExcecaoPersonalizada | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

   
    @SuppressWarnings("rawtypes")
    private static Veiculo buscarVeiculoPorPlaca(GerenciamentoVeiculos gerenciamento, String placa) {
        // Iterando sobre a lista de veículos para encontrar o veículo com a placa fornecida
        for (Veiculo veiculo : gerenciamento.getVeiculos()) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null; 
    }

  
    @SuppressWarnings("rawtypes")
    private static void registrarDespesa(GerenciamentoVeiculos gerenciamento) {
        try {
            String placa = JOptionPane.showInputDialog("Digite a placa do veículo:");
            Veiculo veiculo = buscarVeiculoPorPlaca(gerenciamento, placa);

            if (veiculo == null) {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
                return;
            }

            String tipo = JOptionPane.showInputDialog("Digite o tipo da despesa:");
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da despesa:"));
            String descricao = JOptionPane.showInputDialog("Digite a descrição da despesa:");

            // Criando e registrando a despesa
            Despesa despesa = new Despesa(tipo, valor, descricao, LocalDate.now());
            gerenciamento.adicionarDespesa(veiculo, despesa);
            JOptionPane.showMessageDialog(null, "Despesa registrada com sucesso!");
        } catch (ExcecaoPersonalizada | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    @SuppressWarnings("rawtypes")
    private static void calcularConsumoMedio(GerenciamentoVeiculos gerenciamento) {
        try {
            String placa = JOptionPane.showInputDialog("Digite a placa do veículo:");
            Veiculo veiculo = buscarVeiculoPorPlaca(gerenciamento, placa);

            if (veiculo == null) {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
                return;
            }

            // Calculando o consumo médio
            double consumoMedio = gerenciamento.calcularConsumoMedio(veiculo);
            JOptionPane.showMessageDialog(null, "O consumo médio do veículo é: " + consumoMedio + " km/l");
        } catch (ExcecaoPersonalizada e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    @SuppressWarnings("rawtypes")
    private static void listarVeiculos(GerenciamentoVeiculos gerenciamento) {
        StringBuilder listaVeiculos = new StringBuilder("Veículos cadastrados:\n");
        // Iterando sobre a lista de veículos e construindo a lista de veículos
        for (Veiculo veiculo : gerenciamento.getVeiculos()) {
            listaVeiculos.append("Placa: ").append(veiculo.getPlaca())
                         .append(", Modelo: ").append(veiculo.getModelo())
                         .append(", Marca: ").append(veiculo.getMarca())
                         .append("\n");
        }

        // Criando um JTextArea para exibir a lista de veículos com scroll
        JTextArea textArea = new JTextArea(listaVeiculos.toString());
        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(400, 300)); // Define o tamanho da área de texto

        // Exibindo a lista de veículos em uma caixa de diálogo com rolagem
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Lista de Veículos", JOptionPane.INFORMATION_MESSAGE);
    }
}
