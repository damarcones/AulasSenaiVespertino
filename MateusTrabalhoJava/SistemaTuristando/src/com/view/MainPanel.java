package com.view;
import com.controle.SistemaTuristando;
import com.model.abastecimento.Abastecimento;
import com.model.gasto.Gasto;
import com.model.veiculo.Veiculo;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainPanel {
    public static void main(String[] args) {
        SistemaTuristando sistema = new SistemaTuristando();
        
        JFrame frame = new JFrame("Sistema de Gestão de Veículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));

        JButton listarVeiculosButton = new JButton("Listar Veículos");
        JButton listarGastosButton = new JButton("Listar Gastos");
        JButton listarAbastecimentosButton = new JButton("Listar Abastecimentos");
        JButton adicionarVeiculoButton = new JButton("Adicionar Veículo");
        JButton registrarGastoButton = new JButton("Registrar Gasto");
        JButton registrarAbastecimentoButton = new JButton("Registrar Abastecimento");
        JButton calcularConsumoButton = new JButton("Calcular Consumo Médio");
        JButton gerarRelatorioButton = new JButton("Gerar Relatório");

         // Adiciona os botões ao painel
         panel.add(listarVeiculosButton);//f
         panel.add(listarGastosButton);//f
         panel.add(listarAbastecimentosButton);//f
         panel.add(adicionarVeiculoButton);//f
         panel.add(registrarGastoButton);//f
         panel.add(registrarAbastecimentoButton);//f
         panel.add(calcularConsumoButton);//F
         panel.add(gerarRelatorioButton);
        
         // Adiciona o painel ao frame
         frame.add(panel);
         frame.setVisible(true);


        //retorna as funcoes ao clicar nos botoes
        adicionarVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Veiculo veiculo = SistemaTuristando.coletarInformacoesDoVeiculo();

                if (veiculo != null) {
                    JOptionPane.showMessageDialog(null, new JLabel("Veiculo "+veiculo.getModelo()+", placa: " + veiculo.getPlaca()+" adicionado com sucesso!"), "Informações do Veículo", JOptionPane.INFORMATION_MESSAGE);
                    sistema.adicionarVeiculo(veiculo);
                }
            }
        });

        listarVeiculosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               sistema.listarVeiculos();
            }
        });

        registrarAbastecimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Abastecimento abastecimento;
                JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

                JTextField placaField = new JTextField(10);     
                panel.add(new JLabel("Insira a Placa do veiculo:"));
                panel.add(placaField);
                int result = JOptionPane.showConfirmDialog(null, panel, "Informações do Abastecimento", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
                if (result == JOptionPane.OK_OPTION) {
                        String placa = (String) placaField.getText();
                        
                         if(sistema.encontrarVeiculoPorPlaca(placa) != null){

                            abastecimento = SistemaTuristando.registrarAbastecimento(placa);
                            if (abastecimento != null) {
                                JOptionPane.showMessageDialog(null, new JLabel(abastecimento.toString()), "Informações do Abastecimento", JOptionPane.INFORMATION_MESSAGE);
                                sistema.registrarAbastecimento(abastecimento);
                            }                        
                        }               
                 }   
            }
        });

        listarAbastecimentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               sistema.listarAbastecimentos();
            }
        });

        calcularConsumoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

                    JTextField placaField = new JTextField(10);     
                    panel.add(new JLabel("Insira a Placa do veiculo:"));
                    panel.add(placaField);
                    int result = JOptionPane.showConfirmDialog(null, panel, "Calcular consumo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    
                    if (result == JOptionPane.OK_OPTION) {


                            String placa = (String) placaField.getText();
                            if(sistema.encontrarVeiculoPorPlaca(placa) != null){
                                sistema.calcularConsumoMedio(placa);                        
                            }else {
                                JOptionPane.showMessageDialog(null,"Placa não encontrada. Confirme os dados e tente novamente", "Alerta", JOptionPane.ERROR_MESSAGE);
                            }            
                    }
            }                                  
        });

        registrarGastoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gasto gasto;
                JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

                JTextField placaField = new JTextField(10);     
                panel.add(new JLabel("Insira a Placa do veiculo:"));
                panel.add(placaField);
                int result = JOptionPane.showConfirmDialog(null, panel, "Informações do Abastecimento", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
                    if (result == JOptionPane.OK_OPTION) {
                        String placa = (String) placaField.getText();
                        
                         if(sistema.encontrarVeiculoPorPlaca(placa) != null){

                            gasto = SistemaTuristando.coletarInformacoesDoGasto(placa);
                                    if (gasto != null) {
                                    JOptionPane.showMessageDialog(null, new JLabel(gasto.toString()), "Informações do Gasto", JOptionPane.INFORMATION_MESSAGE);
                                    sistema.registrarGasto(gasto);
                                    }                        
                        }else {
                            JOptionPane.showMessageDialog(null,"Placa não encontrada. Confirme os dados e tente novamente", "Alerta", JOptionPane.ERROR_MESSAGE);
                        }                
                    } 
            }
        });

        listarGastosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               sistema.listarGastos();
            }
        });

        gerarRelatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    sistema.gerarRelatorio();
            }
        });

       
    }

   
}
