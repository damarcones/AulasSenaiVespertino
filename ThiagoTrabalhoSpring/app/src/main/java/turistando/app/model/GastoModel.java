package turistando.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import turistando.app.controller.Enum.gastoEnum;

@Entity
@Table(name = "Gasto")
public class GastoModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idGasto;

    @Enumerated(EnumType.STRING)
    private gastoEnum tipogasto;
    
    private String descricao;
    private double valor;

    @OneToOne
    private VeiculoModel placaveiculo;

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public gastoEnum getTipogasto() {
        return tipogasto;
    }

    public void setTipogasto(gastoEnum tipogasto) {
        this.tipogasto = tipogasto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public VeiculoModel getPlacaveiculo() {
        return placaveiculo;
    }

    public void setPlacaveiculo(VeiculoModel placaveiculo) {
        this.placaveiculo = placaveiculo;
    }

}
