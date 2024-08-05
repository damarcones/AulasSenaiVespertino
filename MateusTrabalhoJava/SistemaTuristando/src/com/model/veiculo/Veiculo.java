package com.model.veiculo;

public class Veiculo {

    private static int proximoId = 1;
    private int id;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int anoModelo;
    private int motorizacao;
    private double capacidadeTanque;
    private String combustiveisAceitos; 
    private String cor;
    private String placa;
    private String renavam; 
    
    
   
    //Método Construtor
    public Veiculo( String marca, String modelo, int anoFabricacao, int anoModelo, int motorizacao,
                    double capacidadeTanque,String combustiveisAceitos, String cor, String placa, String renavam) 
        {
            this.id = proximoId++; //auto incrementa o id
            this.marca = marca;
            this.modelo = modelo;
            this.anoFabricacao = anoFabricacao;
            this.anoModelo = anoModelo;
            this.motorizacao = motorizacao;
            this.capacidadeTanque = capacidadeTanque;
            this.combustiveisAceitos = combustiveisAceitos;
            this.cor = cor;
            this.placa = placa;
            this.renavam = renavam;
        }

    
    //Métodos Getters e Setters
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
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


    public int getMotorizacao() {
        return motorizacao;
    }


    public void setMotorizacao(int motorizacao) {
        this.motorizacao = motorizacao;
    }


    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }


    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }


    public String getCombustiveisAceitos() {
        return combustiveisAceitos;
    }


    public void CombustiveisAceitos(String combustiveisAceitos) {
        this.combustiveisAceitos = combustiveisAceitos;
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

    

}
