package View;

import Enum.CategoriaGasto;
import Enum.tipoAbastecimento;
import Exception.InformacaoIncompletaException;
import Exception.ValorInvalidoException;
import Turistandomodel.Abastecimento;
import Turistandomodel.Gasto;
import Turistandomodel.Veiculo;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controler.VeiculoController;
import Enum.CategoriaGasto;
import Exception.CombustivelInvalidoException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {

    private static List<Veiculo> veiculos = new ArrayList<>();


    public static List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public static void setVeiculos(List<Veiculo> veiculos) {
        App.veiculos = veiculos;
    }

    public static void main(String[] args) throws Exception {
    }

     {

        JFrame frame = new JFrame("Gerenciamento de Veículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));
        
        String[] op = {"Cadastrar Veículo", "Registrar Gasto", "Registrar Abastecimento", "Relatório", "Sair"};
               
            for (int i = 0; i < op.length; i++) {
            JButton button = new JButton(op[i]);
            int escolha= i;
            button.addActionListener(e -> {
                try {
                    executarOpcao(escolha);
                } catch (InformacaoIncompletaException ex) {
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
                    
                    
    private static void executarOpcao(int escolha) throws InformacaoIncompletaException {
                    
                    switch (escolha) {
                        case 0:
                            cadastrarVeiculo();
                            break;
                        case 1:
                            mostrarVeiculosRegistrados();
                            break;
                        case 2:
                            registrarGasto();
                            break;
                        case 3:
                            registrarAbastecimento();
                            break;
                        case 4:
                            calcularConsumoMedio();
                            break;
                        case 5:
                        relatorioGeral();
                            break;
                        case 6:
                            System.exit(0);
                            break;
                        default:
                         throw new InformacaoIncompletaException("ERRO.");
                            
                    }
    }


    private static void cadastrarVeiculo() throws InformacaoIncompletaException,ValorInvalidoException {
       
            JPanel panel = criarFormularioVeiculo();
        
            int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Veículo", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);
        
            if (result == JOptionPane.OK_OPTION) {
                try {
                    Veiculo veiculo = criarVeiculo(panel);
                    veiculos.add(veiculo);
                    JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    throw new ValorInvalidoException("Valor inválido inserido: " + e.getMessage());
                }
            }
        }
        
        private static JPanel criarFormularioVeiculo() {
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
            JComboBox<tipoAbastecimento> combustiveisComboBox = new JComboBox<>(tipoAbastecimento.values());
            JTextField corField = new JTextField(15);
            JTextField placaField = new JTextField(10);
            JTextField renavamField = new JTextField(20);
        
            adicionarCampo(panel, gbc, "Marca:", marcaField, 0);
            adicionarCampo(panel, gbc, "Modelo:", modeloField, 1);
            adicionarCampo(panel, gbc, "Ano de Fabricação:", anoFabricacaoField, 2);
            adicionarCampo(panel, gbc, "Ano do Modelo:", anoModeloField, 3);
            adicionarCampo(panel, gbc, "Motorização:", motorizacaoField, 4);
            adicionarCampo(panel, gbc, "Capacidade do Tanque (litros):", capacidadeTanqueField, 5);
            adicionarCampo(panel, gbc, "Combustível:", combustiveisComboBox, 6);
            adicionarCampo(panel, gbc, "Cor:", corField, 7);
            adicionarCampo(panel, gbc, "Placa:", placaField, 8);
            adicionarCampo(panel, gbc, "Renavam:", renavamField, 9);
        
            return panel;
        }
        
        private static void adicionarCampo(JPanel panel, GridBagConstraints gbc, String label, JComponent field, int y) {
            gbc.gridx = 0;
            gbc.gridy = y;
            panel.add(new JLabel(label), gbc);
            gbc.gridx = 1;
            panel.add(field, gbc);
        }
        
        private static Veiculo criarVeiculo(JPanel panel) throws NumberFormatException {
            JTextField marcaField = (JTextField) ((JPanel) panel.getComponent(1)).getComponent(1);
            JTextField modeloField = (JTextField) ((JPanel) panel.getComponent(3)).getComponent(1);
            JTextField anoFabricacaoField = (JTextField) ((JPanel) panel.getComponent(5)).getComponent(1);
            JTextField anoModeloField = (JTextField) ((JPanel) panel.getComponent(7)).getComponent(1);
            JTextField motorizacaoField = (JTextField) ((JPanel) panel.getComponent(9)).getComponent(1);
            JTextField capacidadeTanqueField = (JTextField) ((JPanel) panel.getComponent(11)).getComponent(1);
            JComboBox<tipoAbastecimento> tipoAbastecimento = (JComboBox<tipoAbastecimento>) ((JPanel) panel.getComponent(13)).getComponent(1);
            JTextField corField = (JTextField) ((JPanel) panel.getComponent(15)).getComponent(1);
            JTextField placaField = (JTextField) ((JPanel) panel.getComponent(17)).getComponent(1);
            JTextField renavamField = (JTextField) ((JPanel) panel.getComponent(19)).getComponent(1);
        
            String marca = marcaField.getText();
            String modelo = modeloField.getText();
            int anoFabricacao = Integer.parseInt(anoFabricacaoField.getText());
            int anoModelo = Integer.parseInt(anoModeloField.getText());
            String motorizacao = motorizacaoField.getText();
            double capacidadeTanque = Double.parseDouble(capacidadeTanqueField.getText());
            tipoAbastecimento abastecimento = (tipoAbastecimento) tipoAbastecimento.getSelectedItem();
            String cor = corField.getText();
            String placa = placaField.getText();
            String renavam = renavamField.getText();
        
            return new Veiculo(marca, modelo, anoFabricacao, anoModelo, motorizacao, null, cor, cor, placa, renavam, null, null, null, veiculos);

      }       

private static void mostrarVeiculosRegistrados() {
    if (veiculos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nenhum veículo registrado.", "Informação",
                JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    JFrame frame = new JFrame("Veículos Registrados");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.add(criarPainelVeiculos());
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

private static JPanel criarPainelVeiculos() {
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
                veiculo.getCombustiveis(),
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

    return painel;
}



    private static void registrarGasto() throws ValorInvalidoException {
    if (veiculos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JTextField descricaoField = new JTextField(20);
    JFormattedTextField valorField = new JFormattedTextField(new DecimalFormat("#0.00"));
    valorField.setColumns(10);
    JFormattedTextField dataField = new JFormattedTextField(DateTimeFormatter.ofPattern("dd-MM-yyyy").toFormat());
    dataField.setColumns(10);

    JComboBox<CategoriaGasto> categoriaGastoBox = new JComboBox<>(CategoriaGasto.values());

    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(new JLabel("Tipo de Gasto:"), gbc);
    gbc.gridx = 1;
    panel.add(categoriaGastoBox, gbc);

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
    CategoriaGasto categoriaGasto = (CategoriaGasto) categoriaGastoBox.getSelectedItem();
    String descricao = descricaoField.getText();
    double valor = ((Number) valorField.getValue()).doubleValue();
    LocalDate data = parseData(dataField.getText());

    validarValor(valor);

    JOptionPane.showMessageDialog(null, "Gasto registrado com sucesso!", "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
} catch (NumberFormatException | DateTimeParseException | ValorInvalidoException e) {
    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
}
}
    }
private static LocalDate parseData(String dataText) throws DateTimeParseException {
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
return LocalDate.parse(dataText, formatter);
}

private static void validarValor(double valor) throws ValorInvalidoException {
if (valor < 0) {
    throw new ValorInvalidoException("O valor do gasto não pode ser negativo.");
}
}

private static void registrarAbastecimento() throws ValorInvalidoException {
    if (veiculos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nenhum veículo registrado. Registre um veículo primeiro.", "Erro",
                JOptionPane.ERROR_MESSAGE);
        return;
    }


    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JTextField quilometragemField = new JTextField(10);
    JTextField valorField = new JTextField(10);
    JTextField quantidadeField = new JTextField(10);

    JComboBox<tipoAbastecimento> combustiveisComboBox = new JComboBox<>(
            tipoAbastecimento.values());

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
                throw new ValorInvalidoException("O valor do abastecimento não pode ser negativo.");
            }
            if (quantidade < 0) {
                throw new ValorInvalidoException("A quantidade de combustível não pode ser negativa.");
            }

            tipoAbastecimento tipoAbastecimento = (tipoAbastecimento) combustiveisComboBox
                    .getSelectedItem();

            tipoAbastecimento Veiculo = Veiculo.getAbastecimento();
            if (!isCombustivelCompativel(Veiculo, tipoAbastecimento)) {
                throw new CombustivelInvalidoException ("O tipo de combustível selecionado não é compatível com o veículo.");
            }

            if (quantidade > veiculo.getCapacidadeTanque()) {
                throw new CombustivelInvalidoException("A quantidade de combustível excede a capacidade do tanque do veículo.");
            }

            int ultimaQuilometragem = 0;
            if (!veiculo.getAbastecimentos().isEmpty()) {
                ultimaQuilometragem = veiculo.getAbastecimentos()
                        .get(veiculo.getAbastecimentos().size() - 1)
                        .getQuilometragem();
            }

            if (quilometragemAtual < ultimaQuilometragem) {
                throw new InformacaoIncompletaException(
                        "A quilometragem atual não pode ser menor que a última quilometragem registrada.");
            }

            VeiculoController veiculoController = new VeiculoController();
            veiculoController.getAbastecimentos()
                    new Abastecimento((quilometragemAtual, valor, quantidade, tipoAbastecimento));

            JOptionPane.showMessageDialog(null, "Abastecimento registrado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            throw new ValorInvalidoException("Erro ao converter valores numéricos: " + e.getMessage());
        }
    }
}


private static void calcularConsumoMedio() throws ValorInvalidoException {
    if (verificarVeiculosVazios()) {
        return;
    }

    Veiculo veiculoSelecionado = escolherVeiculo();
    if (veiculoSelecionado == null) {
        return;
    }

    mostrarConsumoMedio(veiculoSelecionado);
}

private static boolean verificarVeiculosVazios() {
    if (veiculos.isEmpty()) {
        mostrarMensagemErro("Nenhum veículo registrado. Registre um veículo primeiro.");
        return true;
    }
    return false;
}

private static void mostrarMensagemErro(String mensagem) {
    JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
}



private static void mostrarConsumoMedio(Veiculo veiculoSelecionado) throws ValorInvalidoException {

    VeiculoController veiculoController = new VeiculoController(veiculoSelecionado);
    double consumoMedio = veiculoController.calcularConsumoMedio();
    JOptionPane.showMessageDialog(null, "O consumo médio do veículo é: " + consumoMedio + " km/l", "Consumo Médio",
            JOptionPane.INFORMATION_MESSAGE);
}



private static void relatorioGeral() {
    VeiculoController veiculoController = new VeiculoController();

    List<Gasto> gastos = veiculoController.registrarGasto(gasto);
    List<Abastecimento> abastecimentos = veiculoController.getAbastecimentos();

    double totalImpostos = 0;
    double totalMultas = 0;
    double totalManutencao = 0;
    double totalAbastecimentos = 0;
    double totalGeral = 0;

    StringBuilder relatorio = new StringBuilder();

    relatorio.append("RELATÓRIO DE GASTOS GERAIS\n");
    relatorio.append("=============================\n");

    totalImpostos = adicionarGastosPorCategoria(relatorio, "IMPOSTOS", gastos, CategoriaGasto.IMPOSTO);
    totalMultas = adicionarGastosPorCategoria(relatorio, "MULTAS", gastos, CategoriaGasto.MULTA);
    totalManutencao = adicionarGastosPorCategoria(relatorio, "MANUTENÇÃO", gastos, CategoriaGasto.MANUTENCAO);
    totalAbastecimentos = adicionarAbastecimentos(relatorio, abastecimentos);

    totalGeral = totalImpostos + totalMultas + totalManutencao + totalAbastecimentos;
    relatorio.append("=============================\n");
    relatorio.append(String.format("Total Geral: R$ %.2f", totalGeral));

    JTextArea textArea = new JTextArea(relatorio.toString());
    textArea.setEditable(false);
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
    JScrollPane scrollPane = new JScrollPane(textArea);

    JOptionPane.showMessageDialog(null, scrollPane, "Relatório de Gastos Gerais", JOptionPane.INFORMATION_MESSAGE);
}



private static double adicionarGastosPorCategoria(StringBuilder relatorio, String categoriaTitulo, List<Gasto> gastos, CategoriaGasto categoria) {
    relatorio.append(categoriaTitulo).append("\n");
    boolean houveGastos = false;
    double totalCategoria = 0;

    for (Gasto gasto : gastos) {
        if (gasto.getCategoriaGasto() == categoria) {
            houveGastos = true;
            relatorio.append(String.format("Descrição: %s | Valor: R$ %.2f | Data: %s\n",
                    gasto.getDescricao(), gasto.getValor(),
                    gasto.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
            totalCategoria += gasto.getValor();
        }
    }

    if (houveGastos) {
        relatorio.append(String.format("Total em %s: R$ %.2f\n\n", categoriaTitulo, totalCategoria));
    } else {
        relatorio.append(String.format("Não houve %s.\n\n", categoriaTitulo.toLowerCase()));
    }

    return totalCategoria;
}

private static double adicionarAbastecimentos(StringBuilder relatorio, List<Abastecimento> abastecimentos) {
    relatorio.append("ABASTECIMENTOS\n");
    boolean houveAbastecimentos = false;
    double totalAbastecimentos = 0;

    for (Abastecimento abastecimento : abastecimentos) {
        houveAbastecimentos = true;
        relatorio.append(String.format("Quilometragem: %d | Valor: R$ %.2f | Tipo: %s\n",
                abastecimento.getQuilometragem(), abastecimento.getValor(),
                abastecimento.getTipoabastecimento()));
        totalAbastecimentos += abastecimento.getValor();
    }

    if (houveAbastecimentos) {
        relatorio.append(String.format("Total em Abastecimentos: R$ %.2f\n\n", totalAbastecimentos));
    } else {
        relatorio.append("Não houve abastecimentos.\n\n");
    }

    return totalAbastecimentos;
}
    

    }

    


                
      
          
       
  




    