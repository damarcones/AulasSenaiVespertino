package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Veiculo {
    private String marca;
    private String modelo; 
    private int anoFabricacao;
    private int anoModelo;
    private double motorizacao;
    private double capacidadeTanque;
    private String tipoCombustivel;
    private String cor;
    private String placa; 
    private String renavam;
    private List<Abastecimento> abastecimentos; 
    
    public Veiculo(String marca, String modelo, int anoFabricacao, int anoModelo, double motorizacao,
        double capacidadeTanque, String tipoCombustivel, String cor, String placa, String renavam) {
        setMarca(marca);
        setModelo(modelo);
        setAnoFabricacao(anoFabricacao);
        setAnoModelo(anoModelo);
        setMotorizacao(motorizacao);
        setCapacidadeTanque(capacidadeTanque);
        setTipoCombustivel(tipoCombustivel);
        setCor(cor);
        setPlaca(placa);
        setRenavam(renavam);
        abastecimentos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Dados Veiculo [\nmarca = " + getMarca() + ", \nmodelo = " + getModelo() + ", \nanoFabricacao = " + getAnoFabricacao() + ", \nanoModelo = "
                + getAnoModelo() + ", \nmotorizacao = " + getMotorizacao() + ", \ncapacidadeTanque = " + getCapacidadeTanque() + ", \ntipoCombustivel = " + getTipoCombustivel() + ", \ncor = " + getCor()
                + ", \nplaca = " + getPlaca() + ", \nrenavam = " + getRenavam() + "]";
    }

    public void registrarAbastecimento(double valorAbastecido, double quantidadeCombustivel, double quilometragem) {
        Abastecimento abastecimento = new Abastecimento(valorAbastecido, quantidadeCombustivel, quilometragem);
        abastecimentos.add(abastecimento);
    }

     public void mostrarMediaKmPorLitro() {
        if (abastecimentos == null || abastecimentos.size() < 2) {
            JOptionPane.showMessageDialog(null, "Não há dados suficientes para calcular a média!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        abastecimentos.sort((a, b) -> Double.compare(a.getQuilometragem(), b.getQuilometragem())); // vou ordenar a array antes de somar os valores

        double distanciaTotal = abastecimentos.get(abastecimentos.size() - 1).getQuilometragem() - abastecimentos.get(0).getQuilometragem();
        double totalCombustivel = 0;
        
        for (Abastecimento abastecimento : abastecimentos) {
            totalCombustivel += abastecimento.getQuantidadeCombustivel();
        }

        double mediaKmPorLitro = distanciaTotal / totalCombustivel;

        JOptionPane.showMessageDialog(null, String.format("Média de km por litro: %.2f km/l", mediaKmPorLitro),
                "Média de Consumo", JOptionPane.INFORMATION_MESSAGE);
    }

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
    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    public int getAnoModelo() {
        return anoModelo;
    }
    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
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
    public void setCapacidadeTanque(double capacidadeTanque2) {
        this.capacidadeTanque = capacidadeTanque2;
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
    public String getRenavam() {
        return renavam;
    }
    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    } 
}
