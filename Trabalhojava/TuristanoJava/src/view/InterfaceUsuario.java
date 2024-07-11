package view;

import exception.ExcecaoPersonalizada;
import model.Abastecimento;
import model.Despesa;
import model.Veiculo;
import controller.GerenciamentoVeiculos;

import javax.swing.*;
import java.time.LocalDate;

public class InterfaceUsuario {
    public static void main(String[] args) {
        controler.GerenciamentoVeiculos gerenciamento = new controler.GerenciamentoVeiculos();

        while (true) {
            String[] options = {"Cadastrar Veículo", "Registrar Abastecimento", "Registrar Despesa", "Calcular Consumo Médio", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Turistando", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha) {
                case 0:
                    cadastrarVeiculo(gerenciamento);
                    break;
                case 1:
                    registrarAbastecimento(gerenciamento);
                    break;
                case 2:
                    registrarDespesa(gerenciamento);
                    break;
                case 3:
                    calcularConsumoMedio(gerenciamento);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    private static void cadastrarVeiculo(GerenciamentoVeiculos gerenciamento) {
        try {
            String marca = JOptionPane.showInputDialog("Digite a marca do veículo:");
            String modelo = JOptionPane.showInputDialog("Digite o modelo do veículo:");
            int anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabricação do veículo:"));
            int anoModelo = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do modelo do veículo:"));
            String motorizacao = JOptionPane.showInputDialog("Digite a motorização do veículo:");
            double capacidadeTanque = Double.parseDouble(JOptionPane.showInputDialog("Digite a capacidade do tanque (em litros):"));
            String combustiveis = JOptionPane.showInputDialog("Digite os tipos de combustíveis (separados por vírgula):");
            String cor = JOptionPane.showInputDialog("Digite a cor do veículo:");
            String placa = JOptionPane.showInputDialog("Digite a placa do veículo:");
            String renavam = JOptionPane.showInputDialog("Digite o renavam do veículo:");

            Veiculo veiculo = new Veiculo(marca, modelo, anoFabricacao, anoModelo, motorizacao, capacidadeTanque, combustiveis, cor, placa, renavam);
            gerenciamento.cadastrarVeiculo(veiculo);
            JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
        } catch (ExcecaoPersonalizada | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void registrarAbastecimento(GerenciamentoVeiculos gerenciamento) {
        try {
            String placa = JOptionPane.showInputDialog("Digite a placa do veículo:");
            Veiculo veiculo = gerenciamento.getVeiculos().stream().filter(v -> v.getPlaca().equals(placa)).findFirst().orElse(null);

            if (veiculo == null) {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
                return;
            }

            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do abastecimento:"));
            double quantidadeCombustivel = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de combustível (em litros):"));
            int quilometragemAtual = Integer.parseInt(JOptionPane.showInputDialog("Digite a quilometragem atual do veículo:"));

            Abastecimento abastecimento = new Abastecimento(valor, quantidadeCombustivel, quilometragemAtual);
            gerenciamento.adicionarAbastecimento(veiculo, abastecimento);
            JOptionPane.showMessageDialog(null, "Abastecimento registrado com sucesso!");
        } catch (ExcecaoPersonalizada | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void registrarDespesa(GerenciamentoVeiculos gerenciamento) {
        try {
            String placa = JOptionPane.showInputDialog("Digite a placa do veículo:");
            Veiculo veiculo = gerenciamento.getVeiculos().stream().filter(v -> v.getPlaca().equals(placa)).findFirst().orElse(null);

            if (veiculo == null) {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
                return;
            }

            String tipo = JOptionPane.showInputDialog("Digite o tipo da despesa:");
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da despesa:"));
            String descricao = JOptionPane.showInputDialog("Digite a descrição da despesa:");
            LocalDate data = LocalDate.now(); // Usa a data atual

            Despesa despesa = new Despesa(tipo, valor, descricao, data);
            gerenciamento.adicionarDespesa(veiculo, despesa);
            JOptionPane.showMessageDialog(null, "Despesa registrada com sucesso!");
        } catch (ExcecaoPersonalizada | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void calcularConsumoMedio(GerenciamentoVeiculos gerenciamento) {
        try {
            String placa = JOptionPane.showInputDialog("Digite a placa do veículo:");
            Veiculo veiculo = gerenciamento.getVeiculos().stream().filter(v -> v.getPlaca().equals(placa)).findFirst().orElse(null);

            if (veiculo == null) {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
                return;
            }

            double consumoMedio = gerenciamento.calcularConsumoMedio(veiculo);
            JOptionPane.showMessageDialog(null, "O consumo médio do veículo é: " + consumoMedio + " km/l");
        } catch (ExcecaoPersonalizada e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}