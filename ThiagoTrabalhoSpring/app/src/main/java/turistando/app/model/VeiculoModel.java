package turistando.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import turistando.app.controller.Enum.combustivelEnum;

@Entity
@Table(name="veiculo")
public class VeiculoModel {

    @Id
    private String placa;

    private String marca;
    private String modelo;
    private int anoModelo;
    private int anoFabricacao;
    private String cor;
    private long renavam;
    private double motorizacao;
    private double capacidadeTanque;
    @Enumerated(EnumType.STRING)
    private combustivelEnum combustivel;
    @OneToOne(mappedBy="placaveiculo",cascade= CascadeType.ALL, orphanRemoval=true)
    private AbastecimentoModel abastecimentos;

    public AbastecimentoModel getAbastecimentos() {
        return abastecimentos;
    }

    public void setAbastecimentos(AbastecimentoModel abastecimentos) {
        this.abastecimentos = abastecimentos;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public long getRenavam() {
        return renavam;
    }

    public void setRenavam(long renavam) {
        this.renavam = renavam;
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

    public combustivelEnum getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(combustivelEnum combustivel) {
        this.combustivel = combustivel;
    }
}
