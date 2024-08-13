package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import model.Veiculo;

public class TelaCadastrarVeiculo extends JFrame {

    JTextField inputMarca, inputModelo, inputAnoFabricacao, inputAnoModelo, inputMotorizacao, inputCapacidadeTanque, inputCor, inputPlaca, inputRenavam; 
    Border border = BorderFactory.createLineBorder(Color.green, 3);
    JComboBox<String> tipoCombustivel;

    public TelaCadastrarVeiculo() {
        setTitle("Cadastrar Veículo");
        setSize(670, 735);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setSize(654, 697);
        panel.setLayout(null);
        panel.setBorder(border);
        panel.setOpaque(true); 
        panel.setBackground(Color.BLACK);
        panel.setVisible(true);

        JLabel textoCadastroVeiculo = new JLabel("Cadastro Veículo");
        textoCadastroVeiculo.setBounds(300, 10, 250, 60);
        textoCadastroVeiculo.setFont(new Font("SansSerif", Font.BOLD, 16));
        textoCadastroVeiculo.setForeground(Color.GREEN);
        panel.add(textoCadastroVeiculo);

        // Marca
        JLabel textoMarca = new JLabel("Marca: ");
        textoMarca.setBounds(180, 60, 250, 70);
        textoMarca.setFont(new Font("SansSerif", Font.BOLD, 18));
        textoMarca.setForeground(Color.WHITE);
        panel.add(textoMarca);

        inputMarca = new JTextField("");
        inputMarca.setBounds(250, 80, 250, 35);
        inputMarca.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputMarca);

        // Modelo
        JLabel textoModelo = new JLabel("Modelo: ");
        textoModelo.setBounds(165, 110, 250, 70);
        textoModelo.setFont(new Font("SansSerif", Font.BOLD, 18));
        textoModelo.setForeground(Color.WHITE);
        panel.add(textoModelo);

        inputModelo = new JTextField("");
        inputModelo.setBounds(250, 130, 250, 35);
        inputModelo.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputModelo);

        // Ano Fabricação
        JLabel textoAnoFabricacao = new JLabel("Ano Fabricação: ");
        textoAnoFabricacao.setBounds(95, 160, 250, 70);
        textoAnoFabricacao.setFont(new Font("SansSerif", Font.BOLD, 18));
        textoAnoFabricacao.setForeground(Color.WHITE);
        panel.add(textoAnoFabricacao);

        inputAnoFabricacao = new JTextField("");
        inputAnoFabricacao.setBounds(250, 180, 250, 35);
        inputAnoFabricacao.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputAnoFabricacao);

        // Ano Modelo
        JLabel textoAnoModelo = new JLabel("Ano Modelo: ");
        textoAnoModelo.setBounds(125, 210, 250, 70);
        textoAnoModelo.setFont(new Font("SansSerif", Font.BOLD, 18));
        textoAnoModelo.setForeground(Color.WHITE);
        panel.add(textoAnoModelo);

        inputAnoModelo = new JTextField("");
        inputAnoModelo.setBounds(250, 230, 250, 35);
        inputAnoModelo.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputAnoModelo);

        // Motorização
        JLabel textoMotorizacao = new JLabel("Motor: ");
        textoMotorizacao.setBounds(180, 260, 250, 70);
        textoMotorizacao.setFont(new Font("SansSerif", Font.BOLD, 18));
        textoMotorizacao.setForeground(Color.WHITE);
        panel.add(textoMotorizacao);

        inputMotorizacao = new JTextField("");
        inputMotorizacao.setBounds(250, 280, 250, 35);
        inputMotorizacao.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputMotorizacao);

        // Capacidade Tanque
        JLabel textoCapacidadeTanque = new JLabel("Capacidade Tanque: ");
        textoCapacidadeTanque.setBounds(60, 310, 250, 70);
        textoCapacidadeTanque.setFont(new Font("SansSerif", Font.BOLD, 18));
        textoCapacidadeTanque.setForeground(Color.WHITE);
        panel.add(textoCapacidadeTanque);

        inputCapacidadeTanque = new JTextField("");
        inputCapacidadeTanque.setBounds(250, 330, 250, 35);
        inputCapacidadeTanque.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputCapacidadeTanque);

        // Cor
        JLabel textoCor = new JLabel("Cor: ");
        textoCor.setBounds(200, 360, 250, 70);
        textoCor.setFont(new Font("SansSerif", Font.BOLD, 18));
        textoCor.setForeground(Color.WHITE);
        panel.add(textoCor);

        inputCor = new JTextField("");
        inputCor.setBounds(250, 380, 250, 35);
        inputCor.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputCor);

        // Placa
        JLabel textoPlaca = new JLabel("Placa: ");
        textoPlaca.setBounds(185, 410, 250, 70);
        textoPlaca.setFont(new Font("SansSerif", Font.BOLD, 18));
        textoPlaca.setForeground(Color.WHITE);
        panel.add(textoPlaca);

        inputPlaca = new JTextField("");
        inputPlaca.setBounds(250, 430, 250, 35);
        inputPlaca.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputPlaca);

        // Renavam
        JLabel textoRenavam = new JLabel("Renavam: ");
        textoRenavam.setBounds(150, 460, 250, 70);
        textoRenavam.setFont(new Font("SansSerif", Font.BOLD, 18));
        textoRenavam.setForeground(Color.WHITE);
        panel.add(textoRenavam);

        inputRenavam = new JTextField("");
        inputRenavam.setBounds(250, 480, 250, 35);
        inputRenavam.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(inputRenavam);

        // Tipo Combustível
        JLabel textoCombustivel = new JLabel("Combustível: ");
        textoCombustivel.setBounds(120, 510, 250, 70);
        textoCombustivel.setFont(new Font("SansSerif", Font.BOLD, 18));
        textoCombustivel.setForeground(Color.WHITE);
        panel.add(textoCombustivel);

        String[] combustiveis = {"Gasolina", "Álcool", "Flex", "Diesel"};
        tipoCombustivel = new JComboBox<>(combustiveis);
        tipoCombustivel.setBounds(250, 530, 250, 35);
        tipoCombustivel.setFont(new Font("SansSerif", Font.ITALIC, 15));
        panel.add(tipoCombustivel);    

        // Botão Cadastrar Veiculo
        JButton buttonCadastrarVeiculo = new JButton("Cadastrar");
        buttonCadastrarVeiculo.setBounds(50, 600, 250, 70); 
        buttonCadastrarVeiculo.setFont(new Font("SansSerif", Font.BOLD, 15));
        buttonCadastrarVeiculo.setBackground(new Color(10, 10, 10));
        buttonCadastrarVeiculo.setForeground(Color.WHITE);
        buttonCadastrarVeiculo.setFocusable(false);
        buttonCadastrarVeiculo.setBorder(border);
        panel.add(buttonCadastrarVeiculo);

        // Botão Voltar
        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(350, 600, 250, 70); 
        buttonVoltar.setFont(new Font("SansSerif", Font.BOLD, 15));
        buttonVoltar.setBackground(new Color(10, 10, 10));
        buttonVoltar.setForeground(Color.WHITE);
        buttonVoltar.setFocusable(false);
        buttonVoltar.setBorder(border);
        panel.add(buttonVoltar);

        add(panel);

        // Redirecionamentos botões
        buttonCadastrarVeiculo.addActionListener(this::cadastrar);
        buttonVoltar.addActionListener(this::voltar);

        setVisible(true);
    }

    public void cadastrar(ActionEvent actionEvent) {
        // Verificar se todos os campos foram preenchidos
        if (inputMarca.getText().isEmpty() || inputModelo.getText().isEmpty() || 
            inputAnoFabricacao.getText().isEmpty() || inputAnoModelo.getText().isEmpty() || 
            inputMotorizacao.getText().isEmpty() || inputCapacidadeTanque.getText().isEmpty() ||
            inputCor.getText().isEmpty() || inputPlaca.getText().isEmpty() ||
            inputRenavam.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Só aceita números e valores positivos nesses campos
            if (!inputAnoFabricacao.getText().matches("\\d+") || !inputAnoModelo.getText().matches("\\d+") || 
                !inputMotorizacao.getText().matches("\\d+(\\.\\d+)?") || !inputCapacidadeTanque.getText().matches("\\d+") || !inputRenavam.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Os campos Ano de Fabricação, Ano do Modelo, Motorização, Capacidade Tanque e Renavam devem conter apenas números positivos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return; 
            }            
            
            Veiculo novoVeiculo = new Veiculo(
                inputMarca.getText(),
                inputModelo.getText(),
                Integer.parseInt(inputAnoFabricacao.getText()), 
                Integer.parseInt(inputAnoModelo.getText()), 
                Double.parseDouble(inputMotorizacao.getText()),
                Double.parseDouble(inputCapacidadeTanque.getText()), 
                tipoCombustivel.getSelectedItem().toString(),
                inputCor.getText(),
                inputPlaca.getText(),
                inputRenavam.getText()
            );
            MenuPrincipal.listaVeiculos.add(novoVeiculo);

            JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso\n" + novoVeiculo.toString(), "Dados Veículo", JOptionPane.INFORMATION_MESSAGE);
            new MenuPrincipal();
            dispose(); 
        }
    }   

    public void voltar(ActionEvent actionEvent) {
        new MenuPrincipal();
        dispose(); 
    }
}
