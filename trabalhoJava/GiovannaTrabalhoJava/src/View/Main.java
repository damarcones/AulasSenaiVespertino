package View;

import Controller.VeiculoController;
import exception.Excecao;
import Model.Abastecimento;
import Model.Gasto;
import Model.Veiculo;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


    @SuppressWarnings({"rawtypes"})
public class Main {


    private static List<Veiculo> veiculos = new ArrayList<>(); // Lista de veículos registrados

    public static void main(String[] args) {
        while (true) {
            String[] options = {
                "Registrar Novo Veículo",
                "Mostrar Veículos Registrados",
                "Registrar Abastecimento",
                "Registrar Gasto",
                "Calcular Consumo Médio",
                "Calcular Gasto Total",
                "Sair"
            };

            int choice = mostrarMenuVertical(options);

            try {
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
                        break;
                }
            } catch (Excecao e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada numérica inválida: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Data inválida: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static int mostrarMenuVertical(String[] options) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton[] radioButtons = new JRadioButton[options.length];

        for (int i = 0; i < options.length; i++) {
            radioButtons[i] = new JRadioButton(options[i]);
            radioButtons[i].setActionCommand(String.valueOf(i));
            buttonGroup.add(radioButtons[i]);
            panel.add(radioButtons[i]);
        }

        int result = JOptionPane.showConfirmDialog(null, panel, "Escolha uma opção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            for (int i = 0; i < radioButtons.length; i++) {
                if (radioButtons[i].isSelected()) {
                    return Integer.parseInt(radioButtons[i].getActionCommand());
                }
            }
        }
        return -1;
    }

    private static void registrarNovoVeiculo() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField marcaField = new JTextField(10);
        JTextField modeloField = new JTextField(10);
        JTextField anoFabricacaoField = new JTextField(10);
        JTextField anoModeloField = new JTextField(10);
        JTextField motorizacaoField = new JTextField(10);
        JTextField capacidadeTanqueField = new JTextField(10);
        JTextField combustivelField = new JTextField(10);
        JTextField corField = new JTextField(10);
        JTextField placaField = new JTextField(10);
        JTextField renavamField = new JTextField(10);

        panel.add(new JLabel("Marca:"));
        panel.add(marcaField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Ano de Fabricação:"));
        panel.add(anoFabricacaoField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Ano do Modelo:"));
        panel.add(anoModeloField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Motorização:"));
        panel.add(motorizacaoField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Capacidade do Tanque (litros):"));
        panel.add(capacidadeTanqueField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Combustível:"));
        panel.add(combustivelField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Cor:"));
        panel.add(corField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Placa:"));
        panel.add(placaField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("RENAVAM:"));
        panel.add(renavamField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Novo Veículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String marca = marcaField.getText();
            String modelo = modeloField.getText();
            int anoFabricacao = Integer.parseInt(anoFabricacaoField.getText());
            int anoModelo = Integer.parseInt(anoModeloField.getText());
            String motorizacao = motorizacaoField.getText();
            double capacidadeTanque = Double.parseDouble(capacidadeTanqueField.getText());
            String combustivel = combustivelField.getText();
            String cor = corField.getText();
            String placa = placaField.getText();
            String renavam = renavamField.getText();

            Veiculo veiculo = new Veiculo(marca, modelo, anoFabricacao, anoModelo, motorizacao, capacidadeTanque, combustivel, cor, placa, renavam);
            veiculos.add(veiculo);

            JOptionPane.showMessageDialog(null, "Veículo registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void mostrarVeiculosRegistrados() {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Veiculo veiculo : veiculos) {
            sb.append(veiculo).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Veículos Registrados", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void registrarAbastecimento() throws Excecao {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoSelecionado = escolherVeiculo();
        if (veiculoSelecionado == null) {
            return; // Se cancelado
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

        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Abastecimento", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            int quilometragem = Integer.parseInt(quilometragemField.getText());
            double valor = Double.parseDouble(valorField.getText());
            double quantidade = Double.parseDouble(quantidadeField.getText());

            VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
            veiculoController.adicionarAbastecimento(new Abastecimento(quilometragem, valor, quantidade));

            JOptionPane.showMessageDialog(null, "Abastecimento registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void registrarGasto() throws Excecao {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoSelecionado = escolherVeiculo();
        if (veiculoSelecionado == null) {
            return; // Se cancelado
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField categoriaField = new JTextField(10);
        JTextField descricaoField = new JTextField(10);
        JTextField valorField = new JTextField(10);
        JTextField dataField = new JTextField(10);

        panel.add(new JLabel("Categoria:"));
        panel.add(categoriaField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Valor:"));
        panel.add(valorField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Data (YYYY-MM-DD):"));
        panel.add(dataField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Gasto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String categoria = categoriaField.getText();
            String descricao = descricaoField.getText();
            double valor = Double.parseDouble(valorField.getText());
            LocalDate data = LocalDate.parse(dataField.getText());

            VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
            veiculoController.adicionarGasto(new Gasto(categoria, descricao, valor, data));

            JOptionPane.showMessageDialog(null, "Gasto registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void calcularConsumoMedio() {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoSelecionado = escolherVeiculo();
        if (veiculoSelecionado == null) {
            return; // Se cancelado
        }

        VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
        double consumoMedio = veiculoController.calcularConsumoMedio();
        JOptionPane.showMessageDialog(null, "O consumo médio do veículo é: " + consumoMedio + " km/l", "Consumo Médio", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void calcularGastoTotal() throws Excecao {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoSelecionado = escolherVeiculo();
        if (veiculoSelecionado == null) {
            return; // Se cancelado
        }

        VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
        double gastoTotal = veiculoController.calcularGastoTotal();
        JOptionPane.showMessageDialog(null, "O gasto total do veículo é: R$ " + gastoTotal, "Gasto Total", JOptionPane.INFORMATION_MESSAGE);
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
            veiculosArray.length > 0 ? veiculosArray[0] : null
        );

        for (Veiculo veiculo : veiculos) {
            if ((veiculo.getMarca() + " " + veiculo.getModelo() + " - " + veiculo.getPlaca()).equals(escolha)) {
                return veiculo;
            }
        }

        return null; // Se o usuário cancelar a seleção
    }
}