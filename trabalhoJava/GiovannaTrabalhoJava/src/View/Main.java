package View;

import Controller.VeiculoController;
import Model.Abastecimento;
import Model.Gasto;
import Model.Gasto.TipoGasto;
import Model.Veiculo;
import exception.Excecao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::mostrarMenu);
    }

    private static void mostrarMenu() {
        JFrame frame = new JFrame("Gerenciamento de Veículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));

        String[] options = {
                "Registrar Novo Veículo",
                "Mostrar Veículos Registrados",
                "Registrar Abastecimento",
                "Registrar Gasto",
                "Calcular Consumo Médio",
                "Calcular Gasto Total",
                "Sair"
        };

        for (int i = 0; i < options.length; i++) {
            JButton button = new JButton(options[i]);
            int choice = i;
            button.addActionListener(e -> {
                try {
                    executarOpcao(choice);
                } catch (Excecao ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entrada numérica inválida: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data inválida: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            });
            frame.add(button);
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void executarOpcao(int choice) throws Excecao {
        switch (choice) {
            case 0:
                registrarNovoVeiculo();
                break;
            case 1:
                mostrarVeiculosRegistrados();
                break;
            case 2:
                registrarAbastecimento();
                break;
            case 3:
                registrarGasto();
                break;
            case 4:
                calcularConsumoMedio();
                break;
            case 5:
                calcularGastoTotal();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                throw new Excecao("Opção inválida selecionada.");
        }
    }

    private static void registrarNovoVeiculo() throws Excecao {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

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
        panel.add(new JLabel("Combustíveis:"), gbc);
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

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Veículo", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

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

                Veiculo veiculo = new Veiculo(marca, modelo, anoFabricacao, anoModelo, motorizacao, capacidadeTanque,
                        combustiveis, cor, placa, renavam);
                veiculos.add(veiculo);
                JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                throw new Excecao("Valor inválido inserido: " + e.getMessage());
            }
        }
    }

    private static void mostrarVeiculosRegistrados() {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado.", "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] colunas = { "Marca", "Modelo", "Ano de Fabricação", "Ano do Modelo", "Motorização",
                "Capacidade do Tanque", "Combustível", "Cor", "Placa", "RENAVAM" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Veiculo veiculo : veiculos) {
            Object[] linha = {
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getAnoFabricacao(),
                    veiculo.getAnoModelo(),
                    veiculo.getMotorizacao(),
                    veiculo.getCapacidadeTanque(),
                    veiculo.getCombustivel(),
                    veiculo.getCor(),
                    veiculo.getPlaca(),
                    veiculo.getRenavam()
            };
            model.addRow(linha);
        }

        JTable tabela = new JTable(model);
        tabela.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tabela);

        JPanel painel = new JPanel(new BorderLayout());
        painel.add(scrollPane, BorderLayout.CENTER);

        JFrame frame = new JFrame("Veículos Registrados");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(painel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void registrarAbastecimento() throws Excecao {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoSelecionado = escolherVeiculo();
        if (veiculoSelecionado == null) {
            return;
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField quilometragemField = new JTextField(10);
        JTextField valorField = new JTextField(10);
        JTextField quantidadeField = new JTextField(10);

        panel.add(new JLabel("Quilometragem:"));
        panel.add(quilometragemField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Valor (R$):"));
        panel.add(valorField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Quantidade de combustível (litros):"));
        panel.add(quantidadeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Abastecimento", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int quilometragem = Integer.parseInt(quilometragemField.getText());
                double valor = Double.parseDouble(valorField.getText());
                double quantidade = Double.parseDouble(quantidadeField.getText());

                if (quantidade > veiculoSelecionado.getCapacidadeTanque()) {
                    throw new Excecao("A quantidade de combustível excede a capacidade do tanque do veículo.");
                }

                VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
                veiculoController.adicionarAbastecimento(new Abastecimento(quilometragem, valor, quantidade));

                JOptionPane.showMessageDialog(null, "Abastecimento registrado com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                throw new Excecao("Erro ao converter valores numéricos: " + e.getMessage());
            }
        }
    }

    private static void registrarGasto() throws Excecao {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoSelecionado = escolherVeiculo();
        if (veiculoSelecionado == null) {
            return;
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField descricaoField = new JTextField(20);
        JTextField valorField = new JTextField(10);
        JTextField dataField = new JTextField(10);

        JComboBox<TipoGasto> tipoGastoComboBox = new JComboBox<>(TipoGasto.values());

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Tipo de Gasto:"), gbc);
        gbc.gridx = 1;
        panel.add(tipoGastoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1;
        panel.add(descricaoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Valor:"), gbc);
        gbc.gridx = 1;
        panel.add(valorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Data (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        panel.add(dataField, gbc);

        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Gasto", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                TipoGasto tipoGasto = (TipoGasto) tipoGastoComboBox.getSelectedItem();
                String descricao = descricaoField.getText();
                double valor = Double.parseDouble(valorField.getText());
                LocalDate data = LocalDate.parse(dataField.getText());

                VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
                veiculoController.adicionarGasto(new Gasto(tipoGasto, descricao, valor, data));

                JOptionPane.showMessageDialog(null, "Gasto registrado com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                throw new Excecao("Erro ao converter valores numéricos: " + e.getMessage());
            } catch (DateTimeParseException e) {
                throw new Excecao("Data inválida: " + e.getMessage());
            }
        }
    }

    private static void calcularConsumoMedio() throws Excecao {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoSelecionado = escolherVeiculo();
        if (veiculoSelecionado == null) {
            return;
        }

        VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
        double consumoMedio = veiculoController.calcularConsumoMedio();
        JOptionPane.showMessageDialog(null, "O consumo médio do veículo é: " + consumoMedio + " km/l", "Consumo Médio",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void calcularGastoTotal() throws Excecao {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoSelecionado = escolherVeiculo();
        if (veiculoSelecionado == null) {
            return;
        }

        VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
        double gastoTotal = veiculoController.calcularGastoTotal();
        JOptionPane.showMessageDialog(null, "O gasto total do veículo é: R$ " + gastoTotal, "Gasto Total",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static Veiculo escolherVeiculo() {
        String[] veiculosArray = veiculos.stream()
                .map(veiculo -> veiculo.getMarca() + " " + veiculo.getModelo() + " - " + veiculo.getPlaca())
                .toArray(String[]::new);

        String escolha = (String) JOptionPane.showInputDialog(
                null,
                "Escolha um veículo:",
                "Selecionar Veículo",
                JOptionPane.PLAIN_MESSAGE,
                null,
                veiculosArray,
                veiculosArray.length > 0 ? veiculosArray[0] : null);

        for (Veiculo veiculo : veiculos) {
            if ((veiculo.getMarca() + " " + veiculo.getModelo() + " - " + veiculo.getPlaca()).equals(escolha)) {
                return veiculo;
            }
        }

        return null;
    }
}