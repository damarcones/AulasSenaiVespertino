package turistando.app.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import turistando.app.controller.Enum.combustivelEnum;

@Entity
@Table(name="abastecimento")
public class AbastecimentoModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAbastecimento;
    private double litroAbastecido;
    private double valorabastecimento;
    @Enumerated(EnumType.STRING)
    private combustivelEnum tipoabastecido;

    @OneToOne
    private VeiculoModel placaveiculo;

    public int getIdAbastecimento() {
        return idAbastecimento;
    }

    public void setIdAbastecimento(int idAbastecimento) {
        this.idAbastecimento = idAbastecimento;
    }

    public double getLitroAbastecido() {
        return litroAbastecido;
    }

    public void setLitroAbastecido(double litroAbastecido) {
        this.litroAbastecido = litroAbastecido;
    }

    public double getValorabastecimento() {
        return valorabastecimento;
    }

    public void setValorabastecimento(double valorabastecimento) {
        this.valorabastecimento = valorabastecimento;
    }

    public combustivelEnum getTipoabastecido() {
        return tipoabastecido;
    }

    public void setTipoabastecido(combustivelEnum tipoabastecido) {
        this.tipoabastecido = tipoabastecido;
    }

    public VeiculoModel getPlacaveiculo() {
        return placaveiculo;
    }

    public void setPlacaveiculo(VeiculoModel placaveiculo) {
        this.placaveiculo = placaveiculo;
    }
    
}
