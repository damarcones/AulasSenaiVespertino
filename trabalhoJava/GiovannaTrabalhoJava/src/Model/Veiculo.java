package Model;

import java.util.ArrayList;



    @SuppressWarnings("hiding")
    
public class Veiculo<Abastecimento, Gasto> {
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int anoModelo;
    private String motorizacao;
    private double capacidadeTanque;
    private String combustivel;
    private String cor;
    private String placa;
    private String renavam;
    private ArrayList<Abastecimento> abastecimentos;
    private ArrayList<Gasto> gastos;

    public Veiculo(String marca, String modelo, int anoFabricacao, int anoModelo, String motorizacao, double capacidadeTanque, String combustivel, String cor, String placa, String renavam) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.motorizacao = motorizacao;
        this.capacidadeTanque = capacidadeTanque;
        this.combustivel = combustivel;
        this.cor = cor;
        this.placa = placa;
        this.renavam = renavam;
        this.abastecimentos = new ArrayList<>();
        this.gastos = new ArrayList<>();
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

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
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

    public ArrayList<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public void setAbastecimentos(ArrayList<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }

    public ArrayList<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(ArrayList<Gasto> gastos) {
        this.gastos = gastos;
    }

    public void adicionarAbastecimento(Model.Abastecimento abastecimento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarAbastecimento'");
    }

    public void adicionarGasto(Model.Gasto gasto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarGasto'");
    }

    public double calcularConsumoMedio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularConsumoMedio'");
    }

    public double calcularGastosTotais() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularGastosTotais'");
    }

    

}