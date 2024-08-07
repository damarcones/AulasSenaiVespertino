package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;
import model.Veiculo;

public class TelaAbastecer extends JFrame {
    
    JTextField inputValorAbastecido, inputQuantidadeCombustivel, inputQuilometragem;
    JComboBox<String> selectCombustivel;
    Border border = BorderFactory.createLineBorder(Color.green, 3);
    Veiculo veiculo;

    public TelaAbastecer(Veiculo veiculo) {
        this.veiculo = veiculo;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registrar Abastecimento: " + veiculo.getMarca() + " " + veiculo.getModelo());
        setSize(475, 385);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);  // Uso de layout nulo aqui para posicionamento absoluto
        panel.setBorder(border);
        panel.setOpaque(true);
        panel.setBackground(Color.BLACK);
        panel.setSize(500, 400);

        JLabel textoValorAbastecido = new JLabel("Valor Abastecido: ");
        textoValorAbastecido.setBounds(50, 30, 150, 35);
        textoValorAbastecido.setFont(new Font("SansSerif", Font.ITALIC, 18));
        textoValorAbastecido.setForeground(Color.WHITE);
        panel.add(textoValorAbastecido);

        inputValorAbastecido = new JTextField("");
        inputValorAbastecido.setBounds(200, 30, 200, 35);
        inputValorAbastecido.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputValorAbastecido);

        JLabel textoQuantidadeCombustivel = new JLabel("Litros: ");
        textoQuantidadeCombustivel.setBounds(50, 80, 150, 35);
        textoQuantidadeCombustivel.setFont(new Font("SansSerif", Font.ITALIC, 18));
        textoQuantidadeCombustivel.setForeground(Color.WHITE);
        panel.add(textoQuantidadeCombustivel);

        inputQuantidadeCombustivel = new JTextField("");
        inputQuantidadeCombustivel.setBounds(200, 80, 200, 35);
        inputQuantidadeCombustivel.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputQuantidadeCombustivel);

        JLabel textoQuilometragem = new JLabel("Quilometragem: ");
        textoQuilometragem.setBounds(50, 130, 150, 35);
        textoQuilometragem.setFont(new Font("SansSerif", Font.ITALIC, 18));
        textoQuilometragem.setForeground(Color.WHITE);
        panel.add(textoQuilometragem);

        inputQuilometragem = new JTextField("");
        inputQuilometragem.setBounds(200, 130, 200, 35);
        inputQuilometragem.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputQuilometragem);

        JLabel textoCombustivel = new JLabel("Combustível: ");
        textoCombustivel.setBounds(50, 180, 150, 35);
        textoCombustivel.setFont(new Font("SansSerif", Font.ITALIC, 18));
        textoCombustivel.setForeground(Color.WHITE);
        panel.add(textoCombustivel);

        String[] tiposCombustivel = {"Álcool", "Gasolina", "Diesel"};
        selectCombustivel = new JComboBox<>(tiposCombustivel);
        selectCombustivel.setBounds(200, 180, 200, 35);
        selectCombustivel.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(selectCombustivel);

        JButton buttonRegistrarAbastecimento = new JButton("Registrar");
        buttonRegistrarAbastecimento.setBounds(50, 250, 150, 50);
        buttonRegistrarAbastecimento.setFont(new Font("SansSerif", Font.BOLD, 15));
        buttonRegistrarAbastecimento.setBackground(new Color(10, 10, 10));
        buttonRegistrarAbastecimento.setForeground(Color.WHITE);
        buttonRegistrarAbastecimento.setFocusable(false);
        buttonRegistrarAbastecimento.setBorder(border);
        buttonRegistrarAbastecimento.addActionListener(this::Abastecer);
        panel.add(buttonRegistrarAbastecimento);

        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(250, 250, 150, 50);
        buttonVoltar.setFont(new Font("SansSerif", Font.BOLD, 15));
        buttonVoltar.setBackground(new Color(10, 10, 10));
        buttonVoltar.setForeground(Color.WHITE);
        buttonVoltar.setFocusable(false);
        buttonVoltar.setBorder(border);
        buttonVoltar.addActionListener(this::voltar);
        panel.add(buttonVoltar);

        getContentPane().add(panel);
    }

    public void Abastecer(ActionEvent actionEvent) {
        String tipoCombustivelSelecionado = selectCombustivel.getSelectedItem().toString();
    
        // Verificar se algum campo está vazio
        if (inputValorAbastecido.getText().isEmpty() ||
            inputQuantidadeCombustivel.getText().isEmpty() ||
            inputQuilometragem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (!tipoCombustivelSelecionado.equalsIgnoreCase(veiculo.getTipoCombustivel()) &&
            !(veiculo.getTipoCombustivel().equalsIgnoreCase("Flex") && 
              (tipoCombustivelSelecionado.equalsIgnoreCase("Álcool") || tipoCombustivelSelecionado.equalsIgnoreCase("Gasolina")))) {
            JOptionPane.showMessageDialog(null, "Não aceita esse combustível!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                // Tentar converter os valores para números
                double valorAbastecido = Double.parseDouble(inputValorAbastecido.getText());
                double quantidadeCombustivel = Double.parseDouble(inputQuantidadeCombustivel.getText());
                double quilometragem = Double.parseDouble(inputQuilometragem.getText());
    
                // Verificar se os valores são negativos
                if (valorAbastecido < 0 || quantidadeCombustivel < 0 || quilometragem < 0) {
                    JOptionPane.showMessageDialog(null, "Os valores não podem ser negativos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
    
                // Verificar se a quilometragem é menor do que a última quilometragem registrada
                double ultimaQuilometragem = 0;
                if (!veiculo.getAbastecimentos().isEmpty()) {
                    ultimaQuilometragem = veiculo.getAbastecimentos()
                                                .get(veiculo.getAbastecimentos().size() - 1)
                                                .getQuilometragem();
                }
    
                if (quilometragem < ultimaQuilometragem) {
                    JOptionPane.showMessageDialog(null, "A quilometragem não pode ser menor do que a última quilometragem registrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
    
                // Registrar o abastecimento
                veiculo.registrarAbastecimento(valorAbastecido, quantidadeCombustivel, quilometragem);
    
                JOptionPane.showMessageDialog(null, "Abastecimento registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                new TelaListarVeiculos(MenuPrincipal.listaVeiculos);
                dispose();
            } catch (NumberFormatException e) {
                // Se não for números mensagem erro
                JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void voltar(ActionEvent actionEvent) {
        new TelaListarVeiculos(MenuPrincipal.listaVeiculos);
        dispose();
    }
}