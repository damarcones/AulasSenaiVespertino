package View;

import Controller.VeiculoController;
import Model.Abastecimento;
import Model.Abastecimento.TipoCombustivelAbastecimento;
import Model.Gasto;
import Model.Gasto.TipoGasto;
import Model.Gasto.TipoRelatorioGasto;
import Model.Veiculo;
import Model.Veiculo.TipoCombustivel;
import exception.Excecao;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                "Relatório",
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
                relatorio();
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
        JComboBox<TipoCombustivel> combustiveisComboBox = new JComboBox<>(TipoCombustivel.values());
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
        panel.add(new JLabel("Combustível:"), gbc);
        gbc.gridx = 1;
        panel.add(combustiveisComboBox, gbc);

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
                TipoCombustivel combustivel = (TipoCombustivel) combustiveisComboBox.getSelectedItem();
                String cor = corField.getText();
                String placa = placaField.getText();
                String renavam = renavamField.getText();

                Veiculo veiculo = new Veiculo(marca, modelo, anoFabricacao, anoModelo, motorizacao, capacidadeTanque,
                        combustivel, cor, placa, renavam);
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

    private static boolean isCombustivelCompativel(TipoCombustivel tipoVeiculo,
            TipoCombustivelAbastecimento tipoAbastecimento) {
        switch (tipoVeiculo) {
            case GASOLINA:
                return tipoAbastecimento == TipoCombustivelAbastecimento.GASOLINA;
            case DIESEL:
                return tipoAbastecimento == TipoCombustivelAbastecimento.DIESEL;
            case ALCOOL:
                return tipoAbastecimento == TipoCombustivelAbastecimento.ALCOOL;
            case GNV:
                return tipoAbastecimento == TipoCombustivelAbastecimento.GNV;
            case FLEX:
                return tipoAbastecimento == TipoCombustivelAbastecimento.GASOLINA
                        || tipoAbastecimento == TipoCombustivelAbastecimento.ALCOOL;
            default:
                return false;
        }
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

        JComboBox<TipoCombustivelAbastecimento> combustiveisComboBox = new JComboBox<>(
                TipoCombustivelAbastecimento.values());

        panel.add(new JLabel("Quilometragem:"));
        panel.add(quilometragemField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Valor (R$):"));
        panel.add(valorField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Quantidade de combustível (litros):"));
        panel.add(quantidadeField);
        panel.add(Box.createVerticalStrut(15));

        panel.add(new JLabel("Tipo de Combustível:"));
        panel.add(combustiveisComboBox);

        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Abastecimento", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int quilometragemAtual = Integer.parseInt(quilometragemField.getText());
                double valor = Double.parseDouble(valorField.getText());
                double quantidade = Double.parseDouble(quantidadeField.getText());

                if (valor < 0) {
                    throw new Excecao("O valor do abastecimento não pode ser negativo.");
                }
                if (quantidade < 0) {
                    throw new Excecao("A quantidade de combustível não pode ser negativa.");
                }

                TipoCombustivelAbastecimento tipoAbastecimento = (TipoCombustivelAbastecimento) combustiveisComboBox
                        .getSelectedItem();

                TipoCombustivel tipoVeiculo = veiculoSelecionado.getCombustivel();
                if (!isCombustivelCompativel(tipoVeiculo, tipoAbastecimento)) {
                    throw new Excecao("O tipo de combustível selecionado não é compatível com o veículo.");
                }

                if (quantidade > veiculoSelecionado.getCapacidadeTanque()) {
                    throw new Excecao("A quantidade de combustível excede a capacidade do tanque do veículo.");
                }

                int ultimaQuilometragem = 0;
                if (!veiculoSelecionado.getAbastecimentos().isEmpty()) {
                    ultimaQuilometragem = veiculoSelecionado.getAbastecimentos()
                            .get(veiculoSelecionado.getAbastecimentos().size() - 1)
                            .getQuilometragem();
                }

                if (quilometragemAtual < ultimaQuilometragem) {
                    throw new Excecao(
                            "A quilometragem atual não pode ser menor que a última quilometragem registrada.");
                }

                VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
                veiculoController.adicionarAbastecimento(
                        new Abastecimento(quilometragemAtual, valor, quantidade, tipoAbastecimento));

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
        panel.add(new JLabel("Data (DD-MM-YYYY):"), gbc);
        gbc.gridx = 1;
        panel.add(dataField, gbc);

        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Gasto", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                TipoGasto tipoGasto = (TipoGasto) tipoGastoComboBox.getSelectedItem();
                String descricao = descricaoField.getText();
                double valor = Double.parseDouble(valorField.getText());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate data = LocalDate.parse(dataField.getText(), formatter);

                if (valor < 0) {
                    throw new Excecao("O valor do gasto não pode ser negativo.");
                }

                VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
                veiculoController.adicionarGasto(new Gasto(tipoGasto, descricao, valor, data));

                JOptionPane.showMessageDialog(null, "Gasto registrado com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                throw new Excecao("Erro ao converter valores numéricos: " + e.getMessage());
            } catch (DateTimeParseException e) {
                throw new Excecao("Data inválida. Use o formato DD-MM-YYYY: " + e.getMessage());
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

    private static void relatorio() throws Excecao {
        if (veiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] opcoes = { "Geral", "Específico" };
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Deseja ver um relatório geral ou específico?",
                "Escolha do Relatório",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        if (escolha == -1) {
            return;
        }

        Veiculo veiculoSelecionado = escolherVeiculo();
        if (veiculoSelecionado == null) {
            return;
        }

        if (escolha == 0) {
            relatorioGeral(veiculoSelecionado);
        } else {
            relatorioEspecifico(veiculoSelecionado);
        }
    }

    private static void relatorioGeral(Veiculo veiculoSelecionado) {
        VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);

        List<Gasto> gastos = veiculoController.getListaDeGastos();
        List<Abastecimento> abastecimentos = veiculoController.getAbastecimentos();

        double totalImpostos = 0;
        double totalMultas = 0;
        double totalManutencao = 0;
        double totalAbastecimentos = 0;
        double totalGeral = 0;

        StringBuilder relatorio = new StringBuilder();

        relatorio.append("RELATÓRIO DE GASTOS GERAIS\n");
        relatorio.append("=============================\n");

        relatorio.append("IMPOSTOS\n");
        boolean houveImpostos = false;
        for (Gasto gasto : gastos) {
            if (gasto.getTipoGasto() == TipoGasto.IMPOSTO) {
                houveImpostos = true;
                relatorio.append(String.format("Descrição: %s | Valor: R$ %.2f | Data: %s\n",
                        gasto.getDescricao(), gasto.getValor(),
                        gasto.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                totalImpostos += gasto.getValor();
            }
        }
        if (houveImpostos) {
            relatorio.append(String.format("Total em Impostos: R$ %.2f\n\n", totalImpostos));
        } else {
            relatorio.append("Não houve impostos.\n\n");
        }

        relatorio.append("MULTAS\n");
        boolean houveMultas = false;
        for (Gasto gasto : gastos) {
            if (gasto.getTipoGasto() == TipoGasto.MULTA) {
                houveMultas = true;
                relatorio.append(String.format("Descrição: %s | Valor: R$ %.2f | Data: %s\n",
                        gasto.getDescricao(), gasto.getValor(),
                        gasto.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                totalMultas += gasto.getValor();
            }
        }
        if (houveMultas) {
            relatorio.append(String.format("Total em Multas: R$ %.2f\n\n", totalMultas));
        } else {
            relatorio.append("Não houve multas.\n\n");
        }

        relatorio.append("MANUTENÇÃO\n");
        boolean houveManutencao = false;
        for (Gasto gasto : gastos) {
            if (gasto.getTipoGasto() == TipoGasto.MANUTENCAO) {
                houveManutencao = true;
                relatorio.append(String.format("Descrição: %s | Valor: R$ %.2f | Data: %s\n",
                        gasto.getDescricao(), gasto.getValor(),
                        gasto.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                totalManutencao += gasto.getValor();
            }
        }
        if (houveManutencao) {
            relatorio.append(String.format("Total em Manutenção: R$ %.2f\n\n", totalManutencao));
        } else {
            relatorio.append("Não houve manutenções.\n\n");
        }

        relatorio.append("ABASTECIMENTOS\n");
        boolean houveAbastecimentos = false;
        for (Abastecimento abastecimento : abastecimentos) {
            houveAbastecimentos = true;
            relatorio.append(String.format("Quilometragem: %d | Valor: R$ %.2f | Tipo: %s\n",
                    abastecimento.getQuilometragem(), abastecimento.getValor(),
                    abastecimento.getTipoCombustivelAbastecimento()));
            totalAbastecimentos += abastecimento.getValor();
        }
        if (houveAbastecimentos) {
            relatorio.append(String.format("Total em Abastecimentos: R$ %.2f\n\n", totalAbastecimentos));
        } else {
            relatorio.append("Não houve abastecimentos.\n\n");
        }

        totalGeral = totalImpostos + totalMultas + totalManutencao + totalAbastecimentos;
        relatorio.append("=============================\n");
        relatorio.append(String.format("Total Geral: R$ %.2f", totalGeral));

        JTextArea textArea = new JTextArea(relatorio.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Relatório de Gastos Gerais", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void relatorioEspecifico(Veiculo veiculoSelecionado) {
        TipoRelatorioGasto[] tiposRelatorio = TipoRelatorioGasto.values();
        TipoRelatorioGasto tipoRelatorioSelecionado = (TipoRelatorioGasto) JOptionPane.showInputDialog(
                null,
                "Selecione o tipo de gasto para o relatório:",
                "Tipo de Gasto",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tiposRelatorio,
                tiposRelatorio[0]);

        if (tipoRelatorioSelecionado == null) {
            return;
        }

        VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);

        List<Gasto> gastos = veiculoController.getListaDeGastos();
        List<Abastecimento> abastecimentos = veiculoController.getAbastecimentos();

        double totalGasto = 0;

        StringBuilder relatorio = new StringBuilder();

        relatorio.append("RELATÓRIO DE GASTOS - ").append(tipoRelatorioSelecionado.getDescricao()).append("\n");
        relatorio.append("=============================\n");

        boolean houveGastos = false;

        if (tipoRelatorioSelecionado == TipoRelatorioGasto.ABASTECIMENTO) {
            relatorio.append("ABASTECIMENTOS\n");
            for (Abastecimento abastecimento : abastecimentos) {
                houveGastos = true;
                relatorio.append(String.format("Quilometragem: %d | Valor: R$ %.2f | Tipo: %s\n",
                        abastecimento.getQuilometragem(), abastecimento.getValor(),
                        abastecimento.getTipoCombustivelAbastecimento()));
                totalGasto += abastecimento.getValor();
            }
        } else {

            TipoGasto tipoGastoCorrespondente = TipoGasto.valueOf(tipoRelatorioSelecionado.name());
            for (Gasto gasto : gastos) {
                if (gasto.getTipoGasto() == tipoGastoCorrespondente) {
                    houveGastos = true;
                    relatorio.append(String.format("Descrição: %s | Valor: R$ %.2f | Data: %s\n",
                            gasto.getDescricao(), gasto.getValor(),
                            gasto.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                    totalGasto += gasto.getValor();
                }
            }
        }

        if (!houveGastos) {
            relatorio.append("Não houve gastos deste tipo.\n");
        } else {
            relatorio.append(
                    String.format("\nTotal em %s: R$ %.2f\n", tipoRelatorioSelecionado.getDescricao(), totalGasto));
        }

        JTextArea textArea = new JTextArea(relatorio.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Relatório de Gastos Específicos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static Veiculo escolherVeiculo() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Selecionar Veículo");
        dialog.setModal(true);
        dialog.setLayout(new BorderLayout());

        JTextField searchField = new JTextField(20);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> veiculosList = new JList<>(listModel);
        veiculosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(veiculosList);

        atualizarListaVeiculos(listModel, "");
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                atualizarListaVeiculos(listModel, searchField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                atualizarListaVeiculos(listModel, searchField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                atualizarListaVeiculos(listModel, searchField.getText());
            }
        });

        dialog.add(new JLabel("Digite para buscar:"), BorderLayout.NORTH);
        dialog.add(searchField, BorderLayout.NORTH);
        dialog.add(scrollPane, BorderLayout.CENTER);

        JButton selectButton = new JButton("Selecionar");
        selectButton.addActionListener(e -> dialog.dispose());

        dialog.add(selectButton, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        String selectedValue = veiculosList.getSelectedValue();
        if (selectedValue != null) {
            for (Veiculo veiculo : veiculos) {
                if ((veiculo.getMarca() + " " + veiculo.getModelo() + " - " + veiculo.getPlaca())
                        .equals(selectedValue)) {
                    return veiculo;
                }
            }
        }

        return null;

    }

    private static void atualizarListaVeiculos(DefaultListModel<String> listModel, String filtro) {
        listModel.clear();
        List<String> resultadosFiltrados = veiculos.stream()
                .map(veiculo -> veiculo.getMarca() + " " + veiculo.getModelo() + " - " + veiculo.getPlaca())
                .filter(nome -> nome.toLowerCase().contains(filtro.toLowerCase()))
                .collect(Collectors.toList());

        for (String nomeVeiculo : resultadosFiltrados) {
            listModel.addElement(nomeVeiculo);
        }
    }

}