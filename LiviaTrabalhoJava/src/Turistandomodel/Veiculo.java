package Turistandomodel;

import Enum.tipoAbastecimento;
import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int anoModelo;
    private String motorizacao;
    private Double capacidadeTanque;
    private String combustiveis;
    private String cor;
    private String placa;
    private String renavam;
    private List <tipoAbastecimento> tipoAbastecimentos; 
    private List <Abastecimento> abastecimento = new ArrayList<>();
    private List<Gasto> gastos = new ArrayList<>();
    private List<Veiculo> veiculos = new ArrayList<>();
    
    
    public Veiculo(String marca, String modelo, int anoFabricacao, int anoModelo, String motorizacao,
            Double capacidadeTanque, String combustiveis, String cor, String placa, String renavam,
            List<tipoAbastecimento> tipoAbastecimentos, List<Abastecimento> abastecimento, List<Gasto> gastos,
            List<Veiculo> veiculos) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.motorizacao = motorizacao;
        this.capacidadeTanque = capacidadeTanque;
        this.combustiveis = combustiveis;
        this.cor = cor;
        this.placa = placa;
        this.renavam = renavam;
        this.tipoAbastecimentos = tipoAbastecimentos;
        this.abastecimento = abastecimento;
        this.gastos = gastos;
        this.veiculos = veiculos;
    }
    public Double getCapacidadeTanque() {
        return capacidadeTanque;
    }



    public void setCapacidadeTanque(Double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }



    public List<Abastecimento> getAbastecimento() {
        return abastecimento;
    }






    public List<tipoAbastecimento> getTipoAbastecimentos() {
        return tipoAbastecimentos;
    }



    public void setTipoAbastecimentos(List<tipoAbastecimento> tipoAbastecimentos) {
        this.tipoAbastecimentos = tipoAbastecimentos;
    }



   
    
    
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    
    
    
    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
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
    
 
    
    
    public String getCombustiveis() {
        return combustiveis;
    }
    
    
    
    public void setCombustiveis(String combustiveis) {
        this.combustiveis = combustiveis;
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
    
    
    public List<Gasto> getGastos() {
        return gastos;
    }
    
    
    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }
    
    public void adicionarGasto(Gasto gasto) {
        gastos.add(gasto);
    }
    
    
    public List<Abastecimento> getAbastecimentos() {
        return abastecimento;
    }



    public void setAbastecimento(List<Abastecimento> abastecimento) {
        this.abastecimento = abastecimento;
    }
    
   



  
}  
    