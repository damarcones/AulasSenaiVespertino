package turistando.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import turistando.app.controller.Enum.gastoEnum;

@Entity
@Table(name="Gasto")
public class GastoModel {

    @Id
    @Enumerated(EnumType.STRING)
    private gastoEnum tipogasto;
    private String descricao;
    private double valor;

    @OneToOne
    private VeiculoModel placaveiculo;

    public VeiculoModel getPlacaveiculo() {
        return placaveiculo;
    }

    public void setPlacaveiculo(VeiculoModel placaveiculo) {
        this.placaveiculo = placaveiculo;
    }

    public gastoEnum getTipoGasto() {
        return tipogasto;
    }

    public void setTipoGasto(gastoEnum tipoGasto) {
        this.tipogasto = tipoGasto;
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

}
