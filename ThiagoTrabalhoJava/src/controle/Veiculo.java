package controle;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Enum.TipoCombustivel;

public class Veiculo {
    private String marca;
    private String modelo;
    private String anoModelo;
    private String anoFabricacao;
    private double motorizacao;
    private double capacidadeTanque;
    private Enum tipoCombustivel;
    private String cor;
    private String placa;
    private int renavam;
    private int numeroPneus;
    private int assentos;

    private static List<Veiculo> veiculos = new ArrayList<>();    

    public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public double getMotorizacao() {
		return motorizacao;
	}

	public void setMotorizacao(double motorizacao) {
		this.motorizacao = motorizacao;
	}

	public double getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(double capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getRenavam() {
		return renavam;
	}

	public void setRenavam(int renavam) {
		this.renavam = renavam;
	}

	public int getNumeroPneus() {
		return numeroPneus;
	}

	public void setNumeroPneus(int numeroPneus) {
		this.numeroPneus = numeroPneus;
	}

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}

	public static void setVeiculos(List<Veiculo> veiculos) {
		Veiculo.veiculos = veiculos;
	}

	 public void cadastrarVeiculo() {
	        JPanel painel = new JPanel();
	        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

	        JTextField campoMarca = new JTextField(20);
	        JTextField campoModelo = new JTextField(20);
	        JTextField campoAnoModelo = new JTextField(20);
	        JTextField campoAnoFabricacao = new JTextField(20);
	        JTextField campoMotorizacao = new JTextField(20);
	        JTextField campoCapacidadeTanque = new JTextField(20);
	        JComboBox<TipoCombustivel> comboTipoCombustivel = new JComboBox<>(TipoCombustivel.values());
	        JTextField campoCor = new JTextField(20);
	        JTextField campoPlaca = new JTextField(20);
	        JTextField campoRenavam = new JTextField(20);
	        JTextField campoNumeroPneus = new JTextField(20);
	        JTextField campoNumerAssentos = new JTextField(20);

	        painel.add(new JLabel("Marca:"));
	        painel.add(campoMarca);
	        painel.add(new JLabel("Modelo:"));
	        painel.add(campoModelo);
	        painel.add(new JLabel("Ano Modelo:"));
	        painel.add(campoAnoModelo);
	        painel.add(new JLabel("Ano Fabricação:"));
	        painel.add(campoAnoFabricacao);
	        painel.add(new JLabel("Motorização:"));
	        painel.add(campoMotorizacao);
	        painel.add(new JLabel("Capacidade do Tanque (em litros):"));
	        painel.add(campoCapacidadeTanque);
	        painel.add(new JLabel("Tipo de Combustível:"));
	        painel.add(comboTipoCombustivel);
	        painel.add(new JLabel("Cor:"));
	        painel.add(campoCor);
	        painel.add(new JLabel("Placa:"));
	        painel.add(campoPlaca);
	        painel.add(new JLabel("Renavam:"));
	        painel.add(campoRenavam);
	        painel.add(new JLabel("Número de Pneus:"));
	        painel.add(campoNumeroPneus);
	        painel.add(new JLabel("Número de Assentos:"));
	        painel.add(campoNumerAssentos);

	        int resultado = JOptionPane.showConfirmDialog(null, painel, "Cadastro de Veículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (resultado == JOptionPane.OK_OPTION) {
	            try {
	                this.marca = campoMarca.getText();
	                this.modelo = campoModelo.getText();
	                this.anoModelo = campoAnoModelo.getText();
	                this.anoFabricacao = campoAnoFabricacao.getText();
	                this.motorizacao = Double.parseDouble(campoMotorizacao.getText());
	                this.capacidadeTanque = Double.parseDouble(campoCapacidadeTanque.getText());
	                this.tipoCombustivel = (TipoCombustivel) comboTipoCombustivel.getSelectedItem();
	                this.cor = campoCor.getText();
	                this.placa = campoPlaca.getText();
	                this.renavam = Integer.parseInt(campoRenavam.getText());
	                this.numeroPneus = Integer.parseInt(campoNumeroPneus.getText());
	                this.assentos = Integer.parseInt(campoNumerAssentos.getText());

	                veiculos.add(this);

	                JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "Erro ao processar os dados. Verifique se todos os campos numéricos estão corretos.", "Erro", JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
	        }
	    }

	    public static List<Veiculo> getVeiculos() {
	        return veiculos;
	    }

	    public static void mostrarVeiculos() {
	        StringBuilder mensagem = new StringBuilder();
	        for (Veiculo veiculo : veiculos) {
	            mensagem.append(String.format("Veículo cadastrado:\n" +
	                    "Marca: %s\n" +
	                    "Modelo: %s\n" +
	                    "Ano Modelo: %s\n" +
	                    "Ano Fabricação: %s\n" +
	                    "Motorização: %.2f\n" +
	                    "Capacidade do Tanque: %.2f\n" +
	                    "Tipo de Combustível: %s\n" +
	                    "Cor: %s\n" +
	                    "Placa: %s\n" +
	                    "Renavam: %d\n" +
	                    "Número de Pneus: %d\n" +
	                    "Número de Assentos: %d\n\n",
	                    veiculo.marca.toUpperCase(),
	                    veiculo.modelo.toUpperCase(),
	                    veiculo.anoModelo,
	                    veiculo.anoFabricacao,
	                    veiculo.motorizacao,
	                    veiculo.capacidadeTanque,
	                    veiculo.tipoCombustivel,
	                    veiculo.cor.toUpperCase(),
	                    veiculo.placa.toUpperCase(),
	                    veiculo.renavam,
	                    veiculo.numeroPneus,
	                    veiculo.assentos));
	        }
	        JOptionPane.showMessageDialog(null, mensagem.toString(), "Veículos Cadastrados", JOptionPane.INFORMATION_MESSAGE);
	    }
	}