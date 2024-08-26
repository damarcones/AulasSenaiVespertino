package turistando.app.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import turistando.app.Exceptions.ValidaQuilometragem;
import turistando.app.controller.Enum.combustivelEnum;

@Entity
@Table(name = "abastecimento")
public class AbastecimentoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAbastecimento;
    private double litroAbastecido;
    private double valorabastecimento;
    private double quilometragem;

    @Enumerated(EnumType.STRING)
    private combustivelEnum tipoabastecido;

    @ManyToOne
    private VeiculoModel placaveiculo;

    public int getIdAbastecimento() {
        return idAbastecimento;
    }

    public void setIdAbastecimento(int idAbastecimento) {
        this.idAbastecimento = idAbastecimento;
    }

    public double getLitroAbastecido() {
        return placaveiculo.getCapacidadeTanque();
    }

    public void setLitroAbastecido(double litroAbastecido) {
        this.litroAbastecido = litroAbastecido;
    }

    public combustivelEnum getTipoabastecido() {
        return tipoabastecido;
    }

    public void setTipoabastecido(combustivelEnum tipoabastecido) {
        switch (tipoabastecido) {
            case Gasolina -> valorabastecimento = litroAbastecido * 5.40;
            case Alcool -> valorabastecimento = litroAbastecido * 3.80;
            case Diesel -> valorabastecimento = litroAbastecido * 4.90;
            case Etanol -> valorabastecimento = litroAbastecido * 3.80;
            case GNV -> valorabastecimento = litroAbastecido * 3.50;
        }
        this.tipoabastecido = tipoabastecido;
    }

    public double getValorabastecimento() {
        return valorabastecimento;
    }

    public void setValorabastecimento(double valorabastecimento) {
        this.valorabastecimento = valorabastecimento;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) throws ValidaQuilometragem {
     if(this.quilometragem > quilometragem){
        throw new ValidaQuilometragem();
     }
        this.quilometragem = quilometragem;
    }

    public VeiculoModel getPlacaveiculo() {
        return placaveiculo;
    }

    public void setPlacaveiculo(VeiculoModel placaveiculo) {
        this.placaveiculo = placaveiculo;
    }

}
