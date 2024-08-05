package com.model.gastos;

import java.awt.GridLayout;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Multa extends Gasto{
    
    private int pontuacao;
    
    public Multa(String placa, String tipo, LocalDate data, double valor, int pontuacao) {
        super(placa, tipo, data, valor);
        this.pontuacao = pontuacao;

    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public static Multa coletarDadosMulta(String placa){
                    // Criação do painel
                    JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

                    // Criação dos componentes de entrada
                    JTextField placaField = new JTextField(placa);
                    placaField.setEditable(false);
                    JTextField pontuacaoField = new JTextField(10);
                    JTextField tipoField = new JTextField(10);
                    JTextField valorField = new JTextField(10);

                    // Adição dos componentes ao painel
                    panel.add(new JLabel("Veículo (Placa):"));
                    panel.add(placaField);
                    panel.add(new JLabel("Pontuação:"));
                    panel.add(pontuacaoField);
                    panel.add(new JLabel("Tipo Multa (descrição):"));
                    panel.add(tipoField);
                    panel.add(new JLabel("Valor (R$):"));
                    panel.add(valorField);

                    // Exibir o painel em um JOptionPane
                    int result = JOptionPane.showConfirmDialog(null, panel, "Informações da Multa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            //verificar se os dados foram preenchidos
                            if (pontuacaoField.getText().isEmpty() || tipoField.getText().isEmpty() || valorField.getText().isEmpty()) {
                                throw new IllegalArgumentException("Campos incompletos. Confirme os dados e tente novamente.");
                            }

                            String veiculoMu = placaField.getText();
                            int pontuacaoMu = Integer.parseInt(pontuacaoField.getText());
                            if(pontuacaoMu < 0 ){
                                throw new IllegalArgumentException("Valor de pontuação deve ser maior que zero. Confirme os dados e tente novamente.");
                            }

                            String tipoMu = tipoField.getText();
                            
                            double valorMu = Double.parseDouble(valorField.getText());

                            //valor negativo
                            if (valorMu <= 0) {
                                throw new IllegalArgumentException("Valor da multa deve ser maior que zero. Confirme os dados e tente novamente.");
                            }
                            

                            // Retornar um Abastecimento com os dados
                            return new Multa(veiculoMu, tipoMu, LocalDate.now(), valorMu,  pontuacaoMu);  
                            
                        }catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Valores numéricos inválidos. Confirme os dados e tente novamente.", "Alerta", JOptionPane.ERROR_MESSAGE);
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    return null;
     }


     @Override
                public String toString() {
                    return "Placa: " + getPlaca() + 
                           ", Descrição: " +getTipo() +
                           ", Pontuação: " + getPontuacao() +  
                           ", Data: " + getData()+ 
                           ", Valor: " + getValor();
                }

}
