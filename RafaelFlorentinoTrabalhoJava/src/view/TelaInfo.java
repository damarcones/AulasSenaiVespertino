package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import model.Veiculo;

public class TelaInfo extends JFrame {
    
    Border border = BorderFactory.createLineBorder(Color.green, 3);

    public TelaInfo(Veiculo veiculo) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Veículos Cadastrados");
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        mainPanel.setOpaque(true);
        mainPanel.setBackground(Color.BLACK);
        

        JLabel tituloInfo = new JLabel(veiculo.getMarca() + " " + veiculo.getModelo() + " - " + veiculo.getPlaca());
        tituloInfo.setFont(new Font("SansSerif", Font.BOLD, 16));
        tituloInfo.setForeground(Color.GREEN);
        tituloInfo.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(tituloInfo);
        mainPanel.add(Box.createVerticalStrut(10)); 

        String[] columnNames = {"Propriedade", "Valor"};
        Object[][] data = {
            {"Marca", veiculo.getMarca()},
            {"Modelo", veiculo.getModelo()},
            {"Ano de Fabricação", String.valueOf(veiculo.getAnoFabricacao())},
            {"Ano do Modelo", String.valueOf(veiculo.getAnoModelo())},
            {"Motorização", String.valueOf(veiculo.getMotorizacao())},
            {"Capacidade do Tanque", String.valueOf(veiculo.getCapacidadeTanque())},
            {"Tipo de Combustível", veiculo.getTipoCombustivel()},
            {"Cor", veiculo.getCor()},
            {"Placa", veiculo.getPlaca()},
            {"Renavam", veiculo.getRenavam()}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setFont(new Font("SansSerif", Font.BOLD, 15));
        table.setForeground(Color.WHITE);
        table.setBackground(Color.BLACK);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane);

        mainPanel.add(Box.createVerticalStrut(20)); 

        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setFont(new Font("SansSerif", Font.BOLD, 15));
        buttonVoltar.setBackground(new Color(10, 10, 10));
        buttonVoltar.setForeground(Color.WHITE);
        buttonVoltar.setFocusable(false);
        buttonVoltar.setBorder(border);
        buttonVoltar.addActionListener(this::voltar);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(buttonVoltar);

        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

    public void voltar(ActionEvent actionEvent) {
        new TelaListarVeiculos(MenuPrincipal.listaVeiculos);
        dispose();
    }
}
