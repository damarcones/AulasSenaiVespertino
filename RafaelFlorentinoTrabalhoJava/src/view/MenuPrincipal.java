package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Despesa;
import model.Veiculo;

public class MenuPrincipal extends JFrame {

    static List<Veiculo> listaVeiculos = new ArrayList<>();
    static List<Despesa> listaDespesas = new ArrayList<>();

    Border border = BorderFactory.createLineBorder(Color.green,3);
    

    public MenuPrincipal() {
        
        // Povoando o programa

        if(listaVeiculos.isEmpty()){
            listaVeiculos.add(new Veiculo("Ford", "Fiesta", 2015, 2016, 1.6, 50, "Gasolina", "Preto", "ABC1234", "1234567890"));
            listaVeiculos.add(new Veiculo("Chevrolet", "Onix", 2018, 2019, 1.4, 45, "Flex", "Branco", "DEF5678", "0987654321"));
            listaVeiculos.add(new Veiculo("Volkswagen", "Golf", 2020, 2021, 2.0, 55, "Gasolina", "Vermelho", "GHI9012", "1122334455"));
            listaVeiculos.add(new Veiculo("Honda", "Civic", 2017, 2018, 1.8, 47, "Gasolina", "Cinza", "JKL3456", "2233445566"));
            listaVeiculos.add(new Veiculo("Toyota", "Corolla", 2019, 2020, 2.0, 50, "Flex", "Azul", "MNO7890", "3344556677"));
            
            listaDespesas.add(new Despesa("Multa velocidade", 150.00f, "ABC1234", "Multa", "estava 80km/h em uma pista de 60"));
            listaDespesas.add(new Despesa("Ipva", 1200.00f, "ABC1234", "Imposto", "Parcela unica"));
            listaDespesas.add(new Despesa("Manutenção do Carro", 350.00f, "MNO7890", "Manutenção", "Troca pastilha freio, luz faro queimado"));
            listaDespesas.add(new Despesa("Seguro do Carro", 500.00f, "JKL3456", "Outros", "Mensalidade do seguro do carro"));
            listaDespesas.add(new Despesa("Multa estacionamento", 150.00f, "GHI9012", "Multa", "estacionou em frente a garajem"));
            listaDespesas.add(new Despesa("DPVAT", 1200.00f, "GHI9012", "Imposto", "referente a 2024"));
            listaDespesas.add(new Despesa("Troca oleo", 350.00f, "DEF5678", "Manutenção", "Troca de óleo e filtro"));
            listaDespesas.add(new Despesa("Seguro do Carro", 500.00f, "DEF5678", "Outros", "Mensalidade do seguro do carro"));
        }

        // Configurações do Frame

        setTitle("Gerenciador de Frota");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);

        // Tela dentro da tela

        JPanel panel = new JPanel();
        panel.setSize(783, 560);
        panel.setBorder(border);
        panel.setLayout(null);
        panel.setOpaque(true); 
        panel.setBackground(Color.BLACK);
        panel.setVisible(true);
        
        // Criando e configurando os botões
 
        JButton jButtonCadastrarVeiculos = new JButton("Cadastrar Veiculo");
        jButtonCadastrarVeiculos.setBounds(280, 50, 250, 70); 
        jButtonCadastrarVeiculos.setFont(new Font("SansSerif", Font.BOLD, 15));
        jButtonCadastrarVeiculos.setBackground(new Color(10, 10, 10));
        jButtonCadastrarVeiculos.setForeground(Color.WHITE);
        jButtonCadastrarVeiculos.setBorder(border);
        jButtonCadastrarVeiculos.setFocusable(false);

        JButton jButtonListarVeiculos = new JButton("Listar Veiculos");
        jButtonListarVeiculos.setBounds(280, 150, 250, 70); 
        jButtonListarVeiculos.setFont(new Font("SansSerif", Font.BOLD, 15));
        jButtonListarVeiculos.setBackground(new Color(10, 10, 10));
        jButtonListarVeiculos.setForeground(Color.WHITE);
        jButtonListarVeiculos.setBorder(border);
        jButtonListarVeiculos.setFocusable(false);

        JButton jButtonRegistrarDespesas = new JButton("Registrar Despesas");
        jButtonRegistrarDespesas.setBounds(280, 250, 250, 70); 
        jButtonRegistrarDespesas.setFont(new Font("SansSerif", Font.BOLD, 15));
        jButtonRegistrarDespesas.setBackground(new Color(10, 10, 10));
        jButtonRegistrarDespesas.setForeground(Color.WHITE);
        jButtonRegistrarDespesas.setBorder(border);
        jButtonRegistrarDespesas.setFocusable(false);

        JButton jButtonListarDespesas = new JButton("Listar Despesas");
        jButtonListarDespesas.setBounds(280, 350, 250, 70); 
        jButtonListarDespesas.setFont(new Font("SansSerif", Font.BOLD, 15));
        jButtonListarDespesas.setBackground(new Color(10, 10, 10));
        jButtonListarDespesas.setForeground(Color.WHITE);
        jButtonListarDespesas.setBorder(border);
        jButtonListarDespesas.setFocusable(false);

        JButton jButtonsair = new JButton("Sair");
        jButtonsair.setBounds(280, 450, 250, 70); 
        jButtonsair.setFont(new Font("SansSerif", Font.BOLD, 15));
        jButtonsair.setBackground(new Color(10, 10, 10));
        jButtonsair.setForeground(Color.WHITE);
        jButtonsair.setBorder(border);
        jButtonsair.setFocusable(false);

        panel.add(jButtonCadastrarVeiculos);
        panel.add(jButtonListarVeiculos);
        panel.add(jButtonRegistrarDespesas);
        panel.add(jButtonListarDespesas);
        panel.add(jButtonsair);

        add(panel);

        jButtonCadastrarVeiculos.addActionListener(this::cadastrarVeiculo);
        jButtonListarVeiculos.addActionListener(this::listarVeiculo);
        jButtonRegistrarDespesas.addActionListener(this::registrarDespesa);
        jButtonListarDespesas.addActionListener(this::listarDespesa);
        jButtonsair.addActionListener(this::sair);
    }

    public void cadastrarVeiculo(ActionEvent actionEvent) {
        new TelaCadastrarVeiculo();
        dispose();  
    }

    private void listarVeiculo(ActionEvent actionEvent){
        new TelaListarVeiculos(listaVeiculos);
        dispose(); 
    }

    private void registrarDespesa(ActionEvent actionEvent){
        if (MenuPrincipal.listaVeiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Para cadastrar uma despesa é necessário primeiro cadastrar pelo menos um veiculo.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }else{
            new TelaCadastrarDespesa();
            dispose(); 
        }        
    }

    private void listarDespesa(ActionEvent actionEvent){
        if (MenuPrincipal.listaDespesas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma despesa cadastrada ainda", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }else{
            new TelaListarDespesas();
            dispose(); 
        }
    }

    private void sair(ActionEvent actionEvent){
        dispose(); 
    }

}
