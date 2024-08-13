package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import model.Veiculo;

public class TelaListarVeiculos extends JFrame {

    Border border = BorderFactory.createLineBorder(Color.green, 3);

    public TelaListarVeiculos(List<Veiculo> listaVeiculos) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Veículos Cadastrados");
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(border);
        panel.setOpaque(true); 
        panel.setBackground(Color.BLACK);

        JLabel labelTitulo = new JLabel("Veículos Cadastrados", SwingConstants.CENTER);
        labelTitulo.setForeground(Color.GREEN);
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(labelTitulo, BorderLayout.NORTH);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(listaVeiculos.size() + 1, 1, 5, 5));
        listPanel.setOpaque(true);
        listPanel.setBackground(Color.BLACK);

        if (listaVeiculos.isEmpty()) {
            JLabel headerLabel = new JLabel("Nenhum Veículo Cadastrado");
            headerLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
            headerLabel.setForeground(Color.GREEN);
            headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            listPanel.add(headerLabel);
        } else {
            for (Veiculo veiculo : listaVeiculos) {
                JPanel panelMeio = new JPanel();
                panelMeio.setLayout(new FlowLayout());
                panelMeio.setOpaque(true);
                panelMeio.setBackground(Color.BLACK);

                JLabel veiculoLabel = new JLabel(veiculo.getMarca() + " " + veiculo.getModelo() + " - Placa: " + veiculo.getPlaca());
                veiculoLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
                veiculoLabel.setForeground(Color.WHITE);

                JButton buttonInfo = new JButton("Info");
                buttonInfo.setBackground(new Color(10, 10, 10));
                buttonInfo.setForeground(Color.WHITE);
                buttonInfo.setHorizontalAlignment(SwingConstants.CENTER);
                buttonInfo.addActionListener(e -> info(veiculo));
                buttonInfo.setFocusable(false);
                buttonInfo.setBorder(border);

                JButton buttonDespesas = new JButton("Despesas");
                buttonDespesas.setBackground(new Color(10, 10, 10));
                buttonDespesas.setForeground(Color.WHITE);
                buttonDespesas.setHorizontalAlignment(SwingConstants.CENTER);
                buttonDespesas.addActionListener(e -> despesa(veiculo));
                buttonDespesas.setFocusable(false);
                buttonDespesas.setBorder(border);

                JButton buttonAbastecer = new JButton("Abastecer");
                buttonAbastecer.setBackground(new Color(10, 10, 10));
                buttonAbastecer.setForeground(Color.WHITE);
                buttonAbastecer.setHorizontalAlignment(SwingConstants.CENTER);
                buttonAbastecer.setFocusable(false);
                buttonAbastecer.setBorder(border);
                buttonAbastecer.addActionListener(e -> abastecer(veiculo));

                panelMeio.add(veiculoLabel);
                panelMeio.add(buttonInfo);
                panelMeio.add(buttonDespesas);

                if (veiculo.getAbastecimentos().size() >= 2) {
                    JButton buttonMedia = new JButton("Consumo");
                    buttonMedia.setBackground(new Color(10, 10, 10));
                    buttonMedia.setForeground(Color.WHITE);
                    buttonMedia.setHorizontalAlignment(SwingConstants.CENTER);
                    buttonMedia.addActionListener(e -> consumo(veiculo));
                    buttonMedia.setFocusable(false);
                    buttonMedia.setBorder(border);
                    panelMeio.add(buttonMedia);
                }

                panelMeio.add(buttonAbastecer);

                listPanel.add(panelMeio);
            }
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton buttonVoltar = new JButton("Voltar");
        buttonVoltar.setFont(new Font("SansSerif", Font.BOLD, 15));
        buttonVoltar.setBackground(new Color(10, 10, 10));
        buttonVoltar.setForeground(Color.WHITE);
        buttonVoltar.setHorizontalAlignment(SwingConstants.CENTER);
        buttonVoltar.setFocusable(false);
        buttonVoltar.setBorder(border);
        buttonVoltar.addActionListener(this::voltar);

        panel.add(buttonVoltar, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setVisible(true);
    }

    public void voltar(ActionEvent actionEvent) {
        new MenuPrincipal();
        dispose();
    }

    public void info(Veiculo veiculo) {
        dispose();
        new TelaInfo(veiculo);
    }    

    public void abastecer(Veiculo veiculo) {
        dispose();
        new TelaAbastecer(veiculo);
    }

    public void consumo(Veiculo veiculo) {
        veiculo.mostrarMediaKmPorLitro();
    }

    public void despesa(Veiculo veiculo) {
        dispose();
        new TelaDespesa(veiculo);
    }
}