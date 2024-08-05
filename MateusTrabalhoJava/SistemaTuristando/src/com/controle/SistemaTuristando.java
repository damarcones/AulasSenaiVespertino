package com.controle;

import com.model.abastecimento.Abastecimento;
import com.model.gastos.Imposto;
import com.model.gastos.Manutencao;
import com.model.gastos.Multa;
import com.model.gastos.Outros;
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
import javax.swing.JTextField;

public class SistemaTuristando {
    
   
    private static ArrayList<Veiculo> listaVeiculos= new ArrayList<>(); // criando a instancia do array
    private ArrayList<Abastecimento> listaAbastecimentos = new ArrayList<>(); // criando a instancia do array
    private ArrayList<Manutencao> listaManutencao = new ArrayList<>(); // criando a instancia do array
    private ArrayList<Imposto> listaImposto = new ArrayList<>(); // criando a instancia do array
    private ArrayList<Multa> listaMulta = new ArrayList<>(); // criando a instancia do array
    private ArrayList<Outros> listaOutrosGastos = new ArrayList<>(); // criando a instancia do array

    
    
    
    //Metodo pra filtrar um veiculo pela placa
        public static Veiculo encontrarVeiculoPorPlaca(String placa) {
            for (Veiculo veiculo : listaVeiculos) {
                try {
                    if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                    return veiculo;
                }
                else{
                    return null;
                }
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Valores inválidos. Confirme os dados e tente novamente.", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            return null;
        }
    
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
        panel.add(new JLabel("Motorização (Cv):"));
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

    //Metodo para listar todos os veiculos cadastrados
    public void listarVeiculos() {
        if (listaVeiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo cadastrado.", "Listar Veículos", JOptionPane.INFORMATION_MESSAGE);
        } else {
           ArrayList<Veiculo> veiculos = new ArrayList<>();
            
           for (Veiculo veiculo : listaVeiculos) {
            veiculos.add(veiculo);
            }
            JOptionPane.showMessageDialog(null, veiculos, "Listar Veículos", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    

    public static Abastecimento registrarAbastecimento(String placa) {
        // Criação do painel
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        // Criação dos componentes de entrada
        JTextField placaField = new JTextField(placa);
        placaField.setEditable(false);
        JTextField quilometragemField = new JTextField(10);
        JComboBox<String> tipoCombustivelBox = new JComboBox<>(new String[]{"Gasolina", "Álcool", "Diesel", "Flex", "GNV"});
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

                Veiculo v = encontrarVeiculoPorPlaca(placaField.getText());
                String veiculo = placaField.getText();
                double quilometragem = Double.parseDouble(quilometragemField.getText());
                double quantidade = Double.parseDouble(quantidadeField.getText());
                double valor = Double.parseDouble(valorField.getText());

                if (v.getCapacidadeTanque() < quantidade) {
                    throw new IllegalArgumentException("Quantidade em litros superior ao suportado por este veiculo. Confirme os dados e tente novamente.");
                }

                String tipoCombustivel = (String) tipoCombustivelBox.getSelectedItem();
                //Verificação de combustivel para veiculos flex
                if (!(v.getCombustiveisAceitos().contains(tipoCombustivel) || (tipoCombustivel.equals("Gasolina") || tipoCombustivel.equals("Álcool")) && v.getCombustiveisAceitos().equals("Flex"))) {
                    throw new IllegalArgumentException("O tipo de combustível selecionado não é aceito neste veículo. Confirme os dados e tente novamente.");
                }

                //valor negativo
                if (valor <= 0) {
                    throw new IllegalArgumentException("Valor deve ser maior que zero. Confirme os dados e tente novamente.");
                }

                // Retornar um Abastecimento com os dados
                return new Abastecimento(LocalDate.now(), veiculo, quilometragem, tipoCombustivel, quantidade, valor);
                
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

    public static String coletarInformacoesDoGasto(String placa){
        // Criação do painel
        JPanel panel = new JPanel(new GridLayout(0, 2, 0, 0));
        panel.setPreferredSize(new Dimension(100, 130));

        // Criação dos componentes de entrada
        JComboBox<String> tipoGastoBox = new JComboBox<>(new String[]{"Manutenção", "Imposto", "Multa", "Outros"});
        panel.add(new JLabel("Tipo Gasto:"));
        panel.add(tipoGastoBox);
        
        // Exibir o painel em um JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Informações do Veículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                // Verificar se os dados foram preenchidos
                if (tipoGastoBox.getSelectedItem() == null) {
                    throw new IllegalArgumentException("Campos incompletos. Confirme os dados e tente novamente.");
                }
    
                // Coletar as informações inseridas
                String tipoGasto = (String) tipoGastoBox.getSelectedItem();
    
                // Retornar o tipo de gasto selecionado
                return tipoGasto;
    
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valores numéricos inválidos. Confirme os dados e tente novamente.", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
        
    }

    
    public void registrarManutencao(Manutencao manutencao){
        this.listaManutencao.add(manutencao);
    }  

    public void listarManutencao(String placa) {
        // Verifica se a lista esta vazia
        if (listaManutencao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum gasto cadastrado.", "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        boolean encontrouGastos = false;
        double AuxManutencao=0.0;
        // StringBuilder para armazenar o relatório
        StringBuilder relatorio = new StringBuilder();

        // Adiciona as manutenções ao relatório, filtrando pela placa
        if (!listaManutencao.isEmpty()) {
            relatorio.append("\nManutenções:\n");
            for (Manutencao manutencao : listaManutencao) {
                if (manutencao.getPlaca().equalsIgnoreCase(placa)) {
                    relatorio.append(manutencao.toString()).append("\n");
                    encontrouGastos = true;
                    AuxManutencao += manutencao.getValor();
                }
            }
        }
        relatorio.append("Total: R$ " + AuxManutencao);

        // Exibe o relatório ou uma mensagem caso não haja gastos para a placa especificada
        if (encontrouGastos) {
            JOptionPane.showMessageDialog(null, relatorio.toString(), "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum gasto encontrado para o veículo com placa: " + placa, "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void registrarImposto(Imposto imposto){
        this.listaImposto.add(imposto);
    }

    public void listarImposto(String placa) {
        // Verifica se a lista esta vazia
        if (listaImposto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum gasto cadastrado.", "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        boolean encontrouGastos = false;
        double AuxImposto=0.0;
        // StringBuilder para armazenar o relatório
        StringBuilder relatorio = new StringBuilder();

        // Adiciona as manutenções ao relatório, filtrando pela placa
        if (!listaImposto.isEmpty()) {
            relatorio.append("\nManutenções:\n");
            for (Imposto imposto : listaImposto) {
                if (imposto.getPlaca().equalsIgnoreCase(placa)) {
                    relatorio.append(imposto.toString()).append("\n");
                    encontrouGastos = true;
                    AuxImposto += imposto.getValor();
                }
            }
        }
        relatorio.append("Total: R$ " + AuxImposto);

        // Exibe o relatório ou uma mensagem caso não haja gastos para a placa especificada
        if (encontrouGastos) {
            JOptionPane.showMessageDialog(null, relatorio.toString(), "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum gasto encontrado para o veículo com placa: " + placa, "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void registrarMulta(Multa multa){
        this.listaMulta.add(multa);
    }

    public void listarMulta(String placa) {
        // Verifica se a lista esta vazia
        if (listaMulta.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum gasto cadastrado.", "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        boolean encontrouGastos = false;
        double AuxMulta=0.0;
        // StringBuilder para armazenar o relatório
        StringBuilder relatorio = new StringBuilder();

        // Adiciona as manutenções ao relatório, filtrando pela placa
        if (!listaMulta.isEmpty()) {
            relatorio.append("\nManutenções:\n");
            for (Multa multa : listaMulta) {
                if (multa.getPlaca().equalsIgnoreCase(placa)) {
                    relatorio.append(multa.toString()).append("\n");
                    encontrouGastos = true;
                    AuxMulta += multa.getValor();
                }
            }
        }
        relatorio.append("Total: R$ " + AuxMulta);

        // Exibe o relatório ou uma mensagem caso não haja gastos para a placa especificada
        if (encontrouGastos) {
            JOptionPane.showMessageDialog(null, relatorio.toString(), "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum gasto encontrado para o veículo com placa: " + placa, "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void registrarOutrosGastos(Outros outros){
        this.listaOutrosGastos.add(outros);
    }

    public void listarOutrosGastos(String placa) {
        // Verifica se a lista esta vazia
        if (listaOutrosGastos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum gasto cadastrado.", "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        boolean encontrouGastos = false;
        double AuxOutrosGastos=0.0;
        // StringBuilder para armazenar o relatório
        StringBuilder relatorio = new StringBuilder();

        // Adiciona as manutenções ao relatório, filtrando pela placa
        if (!listaOutrosGastos.isEmpty()) {
            relatorio.append("\nOutros Gastos:\n");
            for (Outros OutrosGastos : listaOutrosGastos) {
                if (OutrosGastos.getPlaca().equalsIgnoreCase(placa)) {
                    relatorio.append(OutrosGastos.toString()).append("\n");
                    encontrouGastos = true;
                    AuxOutrosGastos += OutrosGastos.getValor();
                }
            }
        }
        relatorio.append("Total: R$ " + AuxOutrosGastos);

        // Exibe o relatório ou uma mensagem caso não haja gastos para a placa especificada
        if (encontrouGastos) {
            JOptionPane.showMessageDialog(null, relatorio.toString(), "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum gasto encontrado para o veículo com placa: " + placa, "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
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



    public void listarGastosPorCategoria(String placa) {
        double AuxImposto=0.0;
        double AuxManutencao=0.0;
        double AuxMultas=0.0;
        double AuxAbastecimento=0.0;

        // Verifica se as listas estão vazias
        if (listaImposto.isEmpty() && listaManutencao.isEmpty() && listaMulta.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum gasto cadastrado.", "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    
        // StringBuilder para armazenar o relatório
        StringBuilder relatorio = new StringBuilder();
    
        // Adiciona os impostos ao relatório, filtrando pela placa
        boolean encontrouGastos = false;
        if (!listaImposto.isEmpty()) {
            relatorio.append("Impostos:\n");
            for (Imposto imposto : listaImposto) {
                if (imposto.getPlaca().equalsIgnoreCase(placa)) {
                    relatorio.append(imposto.toString()).append("\n");
                    encontrouGastos = true;
                    AuxImposto += imposto.getValor();
                }
            }
            relatorio.append("Total: R$ " + AuxImposto); // Adiciona uma linha em branco entre as categorias
        }
    
        // Adiciona as manutenções ao relatório, filtrando pela placa
        if (!listaManutencao.isEmpty()) {
            relatorio.append("\nManutenções:\n");
            for (Manutencao manutencao : listaManutencao) {
                if (manutencao.getPlaca().equalsIgnoreCase(placa)) {
                    relatorio.append(manutencao.toString()).append("\n");
                    encontrouGastos = true;
                    AuxManutencao += manutencao.getValor();
                }
            }
            
        }

        relatorio.append("Total: R$ " + AuxManutencao);
    
        // Adiciona as multas ao relatório, filtrando pela placa
        if (!listaMulta.isEmpty()) {
            relatorio.append("\nMultas:\n");
            for (Multa multa : listaMulta) {
                if (multa.getPlaca().equalsIgnoreCase(placa)) {
                    relatorio.append(multa.toString()).append("\n");
                    encontrouGastos = true;
                    AuxMultas += multa.getValor();
                }
            }
            relatorio.append("Total: R$ " +AuxMultas); // Adiciona uma linha em branco entre as categorias
        }

        // Adiciona os abastecimentos ao relatório, filtrando pela placa
        if (!listaMulta.isEmpty()) {
            relatorio.append("\nAbastecimentos:\n");
            for (Abastecimento abastecimento : listaAbastecimentos) {
                if (abastecimento.getPlaca().equalsIgnoreCase(placa)) {
                    relatorio.append(abastecimento.toString()).append("\n");
                    encontrouGastos = true;
                    AuxAbastecimento += abastecimento.getValorTotal();
                }
            }
            relatorio.append("Total: R$ " +AuxMultas); // Adiciona uma linha em branco entre as categorias
        }

        //Total Geralzão
        relatorio.append("Valor total de todas as despesas R$ " + AuxImposto+AuxManutencao+AuxMultas+AuxAbastecimento);
        

        // Exibe o relatório ou uma mensagem caso não haja gastos para a placa especificada
        if (encontrouGastos) {
            JOptionPane.showMessageDialog(null, relatorio.toString(), "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum gasto encontrado para o veículo com placa: " + placa, "Listar Gastos por Categoria", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    

    public static String coletarInformacoesDoRelatorio(String placa){
        // Criação do painel
        JPanel panel = new JPanel(new GridLayout(0, 2, 0, 0));
        panel.setPreferredSize(new Dimension(100, 130));

        // Criação dos componentes de entrada
        JComboBox<String> tipoCategoriaBox = new JComboBox<>(new String[]{"Manutenção", "Imposto", "Multa", "Outros"});
        panel.add(new JLabel("Categoria:"));
        panel.add(tipoCategoriaBox);
        
        // Exibir o painel em um JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Informações do Veículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                // Verificar se os dados foram preenchidos
                if (tipoCategoriaBox.getSelectedItem() == null) {
                    throw new IllegalArgumentException("Campos incompletos. Confirme os dados e tente novamente.");
                }
    
                // Coletar as informações inseridas
                String tipoGasto = (String) tipoCategoriaBox.getSelectedItem();
    
                // Retornar o tipo de gasto selecionado
                return tipoGasto;
    
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valores numéricos inválidos. Confirme os dados e tente novamente.", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
        
    }
    
}
