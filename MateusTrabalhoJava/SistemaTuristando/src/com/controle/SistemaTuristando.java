package com.controle;

import com.model.abastecimento.Abastecimento;
import com.model.gasto.Gasto;
import com.model.veiculo.Veiculo;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SistemaTuristando {
    
    private ArrayList<Gasto> listaGastos = new ArrayList<>(); // criando a instancia do array
    private static ArrayList<Veiculo> listaVeiculos= new ArrayList<>(); // criando a instancia do array
    private ArrayList<Abastecimento> listaAbastecimentos = new ArrayList<>(); // criando a instancia do array

    
    //Metodo que cria a interface grafica para a inserção de informações
    public static Veiculo coletarInformacoesDoVeiculo() {
        // Criação do painel
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        // Criação dos componentes de entrada
        JTextField marcaField = new JTextField(10);
        JTextField modeloField = new JTextField(10);
        JTextField anoFabricacaoField = new JTextField(4);
        JTextField anoModeloField = new JTextField(4);
        JTextField motorizacaoField = new JTextField(10);
        JTextField capacidadeTanqueField = new JTextField(5);
        JComboBox<String> combustiveisBox = new JComboBox<>(new String[] {"Gasolina", "Álcool", "Diesel", "Flex", "GNV"});
        JTextField corField = new JTextField(12);
        JTextField placaField = new JTextField(7);
        JTextField renavamField = new JTextField(10);

        // Adição dos componentes ao painel
        panel.add(new JLabel("Marca:"));
        panel.add(marcaField);
        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);
        panel.add(new JLabel("Ano de Fabricação:"));
        panel.add(anoFabricacaoField);
        panel.add(new JLabel("Ano do Modelo:"));
        panel.add(anoModeloField);
        panel.add(new JLabel("Motorização:"));
        panel.add(motorizacaoField);
        panel.add(new JLabel("Capacidade do Tanque (litros):"));
        panel.add(capacidadeTanqueField);
        panel.add(new JLabel("Combustíveis Aceitos:"));
        panel.add(combustiveisBox);
        panel.add(new JLabel("Cor:"));
        panel.add(corField);
        panel.add(new JLabel("Placa:"));
        panel.add(placaField);
        panel.add(new JLabel("RENAVAM:"));
        panel.add(renavamField);

        // Exibir o painel em um JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Informações do Veículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {

            try {
                
                if (marcaField.getText().isEmpty() || modeloField.getText().isEmpty() || anoFabricacaoField.getText().isEmpty() || motorizacaoField.getText().isEmpty() || capacidadeTanqueField.getText().isEmpty() || combustiveisBox.getSelectedItem() == null || corField.getText().isEmpty() || placaField.getText().isEmpty() || renavamField.getText().isEmpty()) {
                    throw new IllegalArgumentException("Campos incompletos. Confirme os dados e tente novamente.");
                }
                // Coletar as informações inseridas
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                
                int anoFabricacao = Integer.parseInt(anoFabricacaoField.getText());
                int anoModelo = Integer.parseInt(anoModeloField.getText());

                
                // Obtém uma instância do calendário com a data e hora atuais
                Calendar calendar = Calendar.getInstance();
                // Obtém o ano atual
                int anoAtual = calendar.get(Calendar.YEAR);

                if ((anoFabricacao > anoAtual || anoModelo > anoAtual) ) {
                    throw new IllegalArgumentException("Data Fabricação e Modelo deve ser menor ou igual ao ano atual. Confirme os dados e tente novamente.");
                }
               
                String motorizacao = motorizacaoField.getText();
                
                double capacidadeTanque = Double.parseDouble(capacidadeTanqueField.getText());
                if ( capacidadeTanque < 0 ) {
                throw new IllegalArgumentException("Capacidade do tanque deve ser maior que zero. Confirme os dados e tente novamente.");
                }
                String combustiveisAceitos = (String) combustiveisBox.getSelectedItem();
                String cor = corField.getText();
                
                String placa = placaField.getText();
                if (placa.length() > 7) {
                    throw new IllegalArgumentException("Número placa deve ser de 7 caracteres. Confirme os dados e tente novamente.");
                    }

                String renavam = renavamField.getText();
                if ( renavam.length() > 11 ) {
                    throw new IllegalArgumentException("Número renavam deve ser de 16 caracteres. Confirme os dados e tente novamente.");
                    }

                // retornar um Veiculo com os dados 
                return new Veiculo(marca, modelo, anoFabricacao, anoModelo, motorizacao, capacidadeTanque, combustiveisAceitos, cor, placa, renavam);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valores numéricos inválidos. Confirme os dados e tente novamente.", "Alerta", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
    
    //Metodo que adiociona todos os Veiculos a uma lista
    public void adicionarVeiculo(Veiculo veiculo){
        this.listaVeiculos.add(veiculo);
    }


    //Metodo pra filtrar um veiculo pela placa
    public static Veiculo encontrarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : listaVeiculos) {
            try {
                if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
            else{
                JOptionPane.showMessageDialog(null, "Placa de veículo não encontrada. Confirme os dados e tente novamente.", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Valores inválidos. Confirme os dados e tente novamente.", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        return null;
    }
    
    //Metodo para listar todos os veiculos cadastrados
    public void listarVeiculos() {
        if (listaVeiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo cadastrado.", "Listar Veículos", JOptionPane.INFORMATION_MESSAGE);
        } else {
        StringBuilder listaVeiculosStringB = new StringBuilder("Veículos cadastrados:\n");
        
        //  Iterando sobre a lista de veículos e construindo a lista de veículos
        for (Veiculo veiculo : listaVeiculos) {
            listaVeiculosStringB.append("\nId: ").append(veiculo.getId())
                                .append(", Placa: ").append(veiculo.getPlaca())
                                .append(", Modelo: ").append(veiculo.getModelo())
                                .append(", Marca: ").append(veiculo.getMarca())
                                .append("\n");
             }

        //     Criando um JTextArea para exibir a lista de veículos com scroll
             JTextArea textArea = new JTextArea(listaVeiculosStringB.toString());
             textArea.setEditable(false);
             textArea.setPreferredSize(new Dimension(500, 400)); // Define o tamanho da área de texto

        //   Exibindo a lista de veículos em uma caixa de diálogo com rolagem
             JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Lista de Veículos", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    
    

    public static Abastecimento registrarAbastecimento(String placa) {
        // Criação do painel
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        // Criação dos componentes de entrada
        JTextField placaField = new JTextField(placa);
        placaField.setEditable(false);
        JTextField quilometragemField = new JTextField(10);
        JComboBox<String> tipoCombustivelBox = new JComboBox<>(new String[]{"Gasolina", "Álcool", "Diesel", "GNV"});
        JTextField quantidadeField = new JTextField(10);
        JTextField valorField = new JTextField(10);

        // Adição dos componentes ao painel
        panel.add(new JLabel("Veículo (Placa):"));
        panel.add(placaField);
        panel.add(new JLabel("Tipo Combustivel:"));
        panel.add(tipoCombustivelBox);
        panel.add(new JLabel("Quilometragem:"));
        panel.add(quilometragemField);
        panel.add(new JLabel("Quantidade (litros):"));
        panel.add(quantidadeField);
        panel.add(new JLabel("Valor (R$):"));
        panel.add(valorField);

        // Exibir o painel em um JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Informações do Abastecimento", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                //verificar se os dados foram preenchidos
                if (quilometragemField.getText().isEmpty() || quantidadeField.getText().isEmpty() || valorField.getText().isEmpty()) {
                    throw new IllegalArgumentException("Campos incompletos. Confirme os dados e tente novamente.");
                }

                Veiculo veiculo = encontrarVeiculoPorPlaca(placaField.getText());
                String placaVeiculo = placaField.getText();
                double quilometragem = Double.parseDouble(quilometragemField.getText());
                double quantidade = Double.parseDouble(quantidadeField.getText());
                double valor = Double.parseDouble(valorField.getText());

                if (veiculo.getCapacidadeTanque() < quantidade) {
                    throw new IllegalArgumentException("Quantidade em litros superior ao suportado por este veiculo. Confirme os dados e tente novamente.");
                }

                String tipoCombustivel = (String) tipoCombustivelBox.getSelectedItem();
                //Verificação de combustivel para veiculos flex
                
                //tipoCombustivel armazena qualquer coisa menos "Flex", logo primeiro parametro retorna F,
                //Caso tipo combustivel for Gasolina ou Alcool, vai retornar V. Logo (F V)
                //
                if (!(veiculo.getCombustiveisAceitos().contains(tipoCombustivel) || (tipoCombustivel.equals("Gasolina") || tipoCombustivel.equals("Álcool")) && veiculo.getCombustiveisAceitos().equals("Flex"))) {
                     throw new IllegalArgumentException("O tipo de combustível selecionado não é aceito neste veículo. Confirme os dados e tente novamente.");
                 }
                
                //valor negativo
                if (valor < 0) {
                    throw new IllegalArgumentException("Valor deve ser maior que zero. Confirme os dados e tente novamente.");
                }

                // Retornar um Abastecimento com os dados
                return new Abastecimento(LocalDate.now(), placaVeiculo, quilometragem, tipoCombustivel, quantidade, valor);
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valores numéricos inválidos. Confirme os dados e tente novamente.", "Alerta", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }    

    //Metodo para listar todos os abastecimentos cadastrados
    public void listarAbastecimentos() {
        if (listaAbastecimentos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum abastecimento cadastrado.", "Listar Abastecimentos", JOptionPane.INFORMATION_MESSAGE);
        } else {
           ArrayList<Abastecimento> abastecimentos = new ArrayList<>();
            
           for (Abastecimento abastecimento : listaAbastecimentos) {
            abastecimentos.add(abastecimento);
            }
            JOptionPane.showMessageDialog(null, abastecimentos, "Listar Abastecimentos", JOptionPane.INFORMATION_MESSAGE);
        }
    } 
    
    //Metodo que adiociona todos os Abastecimentos a uma lista
    public void registrarAbastecimento(Abastecimento abastecimento){
        this.listaAbastecimentos.add(abastecimento);
        //this.registrarGasto(new Gasto(abastecimento.getVeiculo(), "Abastecimento", "Abastecimento do Veículo", abastecimento.getValorTotal()));
    }

    public static Gasto coletarInformacoesDoGasto(String placa){
        // Criação do painel
        JPanel panel = new JPanel(new GridLayout(0, 2, 0, 0));
        panel.setPreferredSize(new Dimension(300, 400));

        // Criação dos componentes de entrada
        JComboBox<String> tipoGastoBox = new JComboBox<>(new String[]{"Manutenção ", "Imposto", "Multa", "Outros"});
        JTextArea descricaoGastoArea = new JTextArea(3, 15); // Define 3 linhas e 15 colunas
        descricaoGastoArea.setLineWrap(true); // Habilita quebra de linha automática
        descricaoGastoArea.setWrapStyleWord(true); // Quebra de linha apenas entre palavras
        JScrollPane descricaoGastoScrollPane = new JScrollPane(descricaoGastoArea); // Adiciona JScrollPane ao JTextArea
        JTextField valorGastoField = new JTextField(8);
        // Adição dos componentes ao painel
        panel.add(new JLabel("Tipo Gasto:"));
        panel.add(tipoGastoBox);
        panel.add(new JLabel("Descrição Gasto:"));
        panel.add(descricaoGastoScrollPane);
        panel.add(new JLabel("Valor Gasto: R$"));
        panel.add(valorGastoField);

        // Exibir o painel em um JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Informações do Veículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                //verificar se os dados foram preenchidos
                if (tipoGastoBox.getSelectedItem() == null || descricaoGastoArea.getText().trim().isEmpty() || valorGastoField.getText().isEmpty()) {
                    throw new IllegalArgumentException("Campos incompletos. Confirme os dados e tente novamente.");
                }

               // Coletar as informações inseridas
                String tipoGasto = (String) tipoGastoBox.getSelectedItem();
                String descricaoGasto = descricaoGastoArea.getText();
                double valorGasto = Double.parseDouble(valorGastoField.getText());

                //valor negativo
                if (valorGasto <= 0) {
                    throw new IllegalArgumentException("Valor deve ser maior que zero. Confirme os dados e tente novamente.");
                }

                // retornar um Veiculo com os dados 
                return new Gasto(LocalDate.now(), placa, tipoGasto, descricaoGasto, valorGasto);
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valores numéricos inválidos. Confirme os dados e tente novamente.", "Alerta", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public void registrarGasto(Gasto gasto){
        this.listaGastos.add(gasto);
    }

    //Metodo para listar todos os abastecimentos cadastrados
    public void listarGastos() {
        if (listaGastos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum gasto cadastrado.", "Listar Gastos", JOptionPane.INFORMATION_MESSAGE);
        } else {
           ArrayList<Gasto> gastos = new ArrayList<>();
            
           for (Gasto gasto : listaGastos) {
            gastos.add(gasto);
            }
            JOptionPane.showMessageDialog(null, gastos, "Listar Gastos", JOptionPane.INFORMATION_MESSAGE);
        }
    } 


    //Metodo calcular o consumo de um unico veiculo atraves da placa como parametro.
    public void calcularConsumoMedio(String placa) {
        Veiculo veiculo = encontrarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            Abastecimento abastecimentoAnterior = null;
            double totalQuilometros = 0.0;
            double totalLitros = 0.0;
            int cont = 0;
            try {
                for (Abastecimento abastecimento : listaAbastecimentos) {
                //verifica de o abastecimente é do carro em questão
                if (abastecimento.getPlaca().equals(placa)) {
                    //caso for, vai calcular a distancia percorrida desde o abastecimento anterior e se n tiver, vai armazenar numa variavel auxiliar
                    if (abastecimentoAnterior != null) {
                        double quilometrosPercorridos = abastecimento.getQuilometragem() - abastecimentoAnterior.getQuilometragem();
                        totalQuilometros += quilometrosPercorridos;
                        totalLitros += abastecimento.getQuantidadeCombustivel();
                    }
                    abastecimentoAnterior = abastecimento;
                    cont++;
                }
            }

            if (cont >= 2) {
                double consumoMedio = totalQuilometros / totalLitros;
                JOptionPane.showMessageDialog(null, "O consumo médio do veículo é: " + String.format("%.2f", consumoMedio) + " km/l");

            } else {
                    JOptionPane.showMessageDialog(null, "Não há abastecimentos suficientes para calcular o consumo do veículo","Erro", JOptionPane.ERROR_MESSAGE);        
            }
            } catch (Exception e) {
            
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Metodo que exibe o relatorio geral(não categoria) do sistema
    public void gerarRelatorio() {
        
        
        
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        JComboBox<String> relatoriosBox = new JComboBox<>(new String[] {"Relatório Geral", "Relatório Por Categoria"});
        
        //JButton relatorioGeralButton = new JButton("Relatório Geral");
        //JButton relatorioPorCategoriaButton = new JButton("Relatório Por Categoria");
        //panel.add(relatorioPorCategoriaButton);//f
        // Adiciona os botões ao painel
        
        panel.add(relatoriosBox);//f
        
            int result = JOptionPane.showConfirmDialog(null, panel, "Relatório", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (result == JOptionPane.OK_OPTION) {
                if(relatoriosBox.getSelectedItem().equals("Relatório Geral")){
                    
                    
                         StringBuilder listaVeiculosStringB = new StringBuilder("Veículos cadastrados:\n");
                    //     // Iterando sobre a lista de veículos e construindo a lista de veículos
                         
                    for (Veiculo veiculo : listaVeiculos) {
                        listaVeiculosStringB.append("id: ").append(veiculo.getId())
                                            .append(", Placa: ").append(veiculo.getPlaca())
                                            .append(", Modelo: ").append(veiculo.getModelo())
                                            .append(", Marca: ").append(veiculo.getMarca())
                                            .append("\n");
                         }

                    //     Criando um JTextArea para exibir a lista de veículos com scroll
                         JTextArea textArea = new JTextArea(listaVeiculos.toString());
                         textArea.setEditable(false);
                         textArea.setPreferredSize(new Dimension(400, 300)); // Define o tamanho da área de texto

                    //     // Exibindo a lista de veículos em uma caixa de diálogo com rolagem
                         JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Lista de Veículos", JOptionPane.INFORMATION_MESSAGE);
                    

                    ArrayList relatorio = new ArrayList();

                    ArrayList<Veiculo> veiculos = new ArrayList<>();
                    
                    for (Veiculo veiculo : listaVeiculos) {
                    veiculos.add(veiculo);
                    }
                    relatorio.add(veiculos);
                    
                    ArrayList<Abastecimento> abastecimentos = new ArrayList<>();
                    
                    for (Abastecimento abastecimento : listaAbastecimentos) {
                        abastecimentos.add(abastecimento);
                    }
                    JOptionPane.showMessageDialog(null, relatorio, "Relatório Geral", JOptionPane.INFORMATION_MESSAGE);
                }
            }              
        
    }

    
}
