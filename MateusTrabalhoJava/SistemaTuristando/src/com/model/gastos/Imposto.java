package com.model.gastos;

import java.awt.GridLayout;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Imposto extends Gasto{

    public Imposto(String placa, String tipo, LocalDate data, double valor) {
        super(placa, tipo, data, valor);
        
    }

    public static Imposto coletarDadosImposto(String placa){
        // Criação do painel
                    JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

                    // Criação dos componentes de entrada
                    JTextField placaField = new JTextField(placa);
                    placaField.setEditable(false);
                    JTextField tipoField = new JTextField(10);
                    JTextField valorField = new JTextField(10);

                    // Adição dos componentes ao painel
                    panel.add(new JLabel("Veículo (Placa):"));
                    panel.add(placaField);
                    panel.add(new JLabel("Tipo imposto (descrição):"));
                    panel.add(tipoField);
                    panel.add(new JLabel("Valor (R$):"));
                    panel.add(valorField);

                    // Exibir o painel em um JOptionPane
                    int result = JOptionPane.showConfirmDialog(null, panel, "Informações do Imposto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            //verificar se os dados foram preenchidos
                            if ( tipoField.getText().isEmpty() || valorField.getText().isEmpty()) {
                                throw new IllegalArgumentException("Campos incompletos. Confirme os dados e tente novamente.");
                            }

                            String veiculoI = placaField.getText();
                            String tipoI = tipoField.getText();
                            
                            double valorI = Double.parseDouble(valorField.getText());

                            //valor negativo
                            if (valorI <= 0) {
                                throw new IllegalArgumentException("Valor deve ser maior que zero. Confirme os dados e tente novamente.");
                            }

                            // Retornar um Abastecimento com os dados
                            return new Imposto(veiculoI, tipoI, LocalDate.now(), valorI);  
                            
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
                           ", Data: " + getData()+ 
                           ", Valor: " + getValor();
                } 

                

}
