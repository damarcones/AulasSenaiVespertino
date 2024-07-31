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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border; 
import model.Despesa;
import model.Veiculo;

public class TelaCadastrarDespesa extends JFrame{

    JTextField inputNomeDespesa, inputValorDespesa;
    JTextArea inputDescricaoDespesa;
    JComboBox<String> comboBoxPlacaDespesa, comboBoxCategoria;
    Border border = BorderFactory.createLineBorder(Color.green, 3);

    public TelaCadastrarDespesa() {

        setTitle("Registrar Despesa");
        setSize(680, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null); 
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setSize(665, 460);
        panel.setLayout(null);
        panel.setBorder(border);
        panel.setOpaque(true); 
        panel.setBackground(Color.BLACK);
        panel.setVisible(true);

        // Nome Despesa
        JLabel TextoNomeDespesa = new JLabel("Nome da despesa:");
        TextoNomeDespesa.setBounds(50, 50, 200, 30); 
        TextoNomeDespesa.setFont(new Font("SansSerif", Font.BOLD, 18));
        TextoNomeDespesa.setForeground(Color.WHITE);
        panel.add(TextoNomeDespesa);

        inputNomeDespesa = new JTextField("");
        inputNomeDespesa.setFont(new Font("SansSerif", Font.ITALIC, 15));
        inputNomeDespesa.setBounds(300, 50, 250, 35); 
        panel.add(inputNomeDespesa);

        // Valor Despesa
        JLabel TextoValorDespesa = new JLabel("Valor da despesa:");
        TextoValorDespesa.setBounds(50, 100, 200, 30); 
        TextoValorDespesa.setFont(new Font("SansSerif", Font.BOLD, 18));
        TextoValorDespesa.setForeground(Color.WHITE);
        panel.add(TextoValorDespesa);

        inputValorDespesa = new JTextField("");
        inputValorDespesa.setFont(new Font("SansSerif", Font.ITALIC, 15));
        inputValorDespesa.setBounds(300, 100, 250, 35); 
        panel.add(inputValorDespesa);

        // Placa Veículo
        JLabel TextoPlacaDespesa = new JLabel("Placa do veículo:");
        TextoPlacaDespesa.setBounds(50, 150, 200, 30); 
        TextoPlacaDespesa.setFont(new Font("SansSerif", Font.BOLD, 18));
        TextoPlacaDespesa.setForeground(Color.WHITE);
        panel.add(TextoPlacaDespesa);

        comboBoxPlacaDespesa = new JComboBox<>();
        comboBoxPlacaDespesa.setFont(new Font("SansSerif", Font.ITALIC, 15));
        comboBoxPlacaDespesa.setBounds(300, 150, 250, 35); 
        panel.add(comboBoxPlacaDespesa);
        carregarPlacasVeiculos();

        // Categoria
        JLabel TextoCategoriaDespesa = new JLabel("Categoria:");
        TextoCategoriaDespesa.setBounds(50, 200, 200, 30); 
        TextoCategoriaDespesa.setFont(new Font("SansSerif", Font.BOLD, 18));
        TextoCategoriaDespesa.setForeground(Color.WHITE);
        panel.add(TextoCategoriaDespesa);

        comboBoxCategoria = new JComboBox<>(new String[]{"Manutenção", "Imposto", "Multa", "Outros"});
        comboBoxCategoria.setFont(new Font("SansSerif", Font.PLAIN, 15));
        comboBoxCategoria.setBounds(300, 200, 250, 35); 
        panel.add(comboBoxCategoria);

        // Descrição Despesa
        JLabel TextoDescricaoDespesa = new JLabel("Descrição da despesa:");
        TextoDescricaoDespesa.setBounds(50, 250, 250, 30); 
        TextoDescricaoDespesa.setFont(new Font("SansSerif", Font.BOLD, 18));
        TextoDescricaoDespesa.setForeground(Color.WHITE);
        panel.add(TextoDescricaoDespesa);

        inputDescricaoDespesa = new JTextArea("");
        inputDescricaoDespesa.setFont(new Font("SansSerif", Font.ITALIC, 15));
        inputDescricaoDespesa.setLineWrap(true);
        inputDescricaoDespesa.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(inputDescricaoDespesa);
        scrollPane.setBounds(300, 250, 250, 100); 
        panel.add(scrollPane);

        // Botão Cadastrar
        JButton buttonCadastrarVeiculo = new JButton("Cadastrar");
        buttonCadastrarVeiculo.setFont(new Font("SansSerif", Font.BOLD, 15));
        buttonCadastrarVeiculo.setBackground(new Color(10, 10, 10));
        buttonCadastrarVeiculo.setForeground(Color.WHITE);
        buttonCadastrarVeiculo.setBorder(border);
        buttonCadastrarVeiculo.setFocusable(false);
        buttonCadastrarVeiculo.setBounds(150, 400, 150, 40); 
        buttonCadastrarVeiculo.addActionListener(this::cadastrarDespesa);
        panel.add(buttonCadastrarVeiculo);

        // Botão Voltar
        JButton jButtonVoltar = new JButton("Voltar");
        jButtonVoltar.setFont(new Font("SansSerif", Font.BOLD, 15));
        jButtonVoltar.setBackground(new Color(10, 10, 10));
        jButtonVoltar.setForeground(Color.WHITE);
        jButtonVoltar.setBorder(border);
        jButtonVoltar.setFocusable(false);
        jButtonVoltar.setBounds(350, 400, 150, 40); 
        jButtonVoltar.addActionListener(this::voltar);
        panel.add(jButtonVoltar);

        add(panel);
    }

    private void carregarPlacasVeiculos() {
        for (Veiculo veiculo : MenuPrincipal.listaVeiculos) {
            comboBoxPlacaDespesa.addItem(veiculo.getPlaca());
        }
    }

    public void cadastrarDespesa(ActionEvent actionEvent) {

        if(  
            inputNomeDespesa.getText().isEmpty() || inputValorDespesa.getText().isEmpty() || 
            comboBoxPlacaDespesa.getSelectedItem() == null || inputDescricaoDespesa.getText().isEmpty() 
        ){
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente", "Informação", 0);
        }else{
            
            if (!inputValorDespesa.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Os campos Valor deve conter apenas números positivos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return; 
            }            
            
            Despesa novaDespesa = new Despesa(
                inputNomeDespesa.getText(),
                Float.parseFloat(inputValorDespesa.getText()), 
                comboBoxPlacaDespesa.getSelectedItem().toString(),
                comboBoxCategoria.getSelectedItem().toString(),
                inputDescricaoDespesa.getText()
            );
            MenuPrincipal.listaDespesas.add(novaDespesa);

            JOptionPane.showMessageDialog(null,novaDespesa, "Despesa cadastrada com sucesso \nDados Despesa:",JOptionPane.INFORMATION_MESSAGE);
            new MenuPrincipal();
            dispose(); 
        }

    }   
    
    public void voltar(ActionEvent actionEvent) {
        new MenuPrincipal();
        dispose(); 
    }
}
