package com.turistando.sistematuristando.model;

import java.time.LocalDate;

import com.turistando.sistematuristando.Enum.TipoDespesa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Pontuacao")
public class Pontuacao extends Despesa {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVeiculo")
    private Veiculo veiculo;

    public Imposto(int id, TipoDespesa tipo ,LocalDate data, double valor, Veiculo veiculo) {
        super(id, tipo, data, valor);
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    

}
