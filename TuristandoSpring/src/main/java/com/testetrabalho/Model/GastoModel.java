package com.testetrabalho.Model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.testetrabalho.Enum.TipodeGasto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;


@Entity
@Table(name = "Gastos")
public class GastoModel {
    
@Id
 @Column (name = "idGasto")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long idGasto;

    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name = "Placa", referencedColumnName="placa") 
    private VeiculoModel veiculo;


    
    
    
    @Column (name = "gasto")
    @Enumerated(EnumType.STRING)
    private TipodeGasto gasto;
    
    @Column (name = "Valor")
    @Min(value = 1,message = "o valor não pode ser menor que um")
    private double valor;
    
    @Column(name ="data")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date data;
    
    
    @Column(name = "descricao")
    private String descricao;
    
    
    
    public VeiculoModel getVeiculo() {
            return veiculo;
        }
    
    
    
        public void setVeiculo(VeiculoModel veiculo) {
            this.veiculo = veiculo;
        }
    public long getIdGasto() {
    return idGasto;
}



public void setIdGasto(long idGasto) {
    this.idGasto = idGasto;
}

public TipodeGasto getGasto() {
    return gasto;
}



public void setGasto(TipodeGasto gasto) {
    this.gasto = gasto;
}



public double getValor() {
    return valor;
}



public void setValor(double valor) {
    this.valor = valor;
}



public Date getData() {
    return data;
}



public void setData(Date data) {
    this.data = data;
}



public String getDescricao() {
    return descricao;
}



public void setDescricao(String descricao) {
    this.descricao = descricao;
}



    public double calcularGastos(List<GastoModel> gastos) {
        double totalGastos = 0;
        for (GastoModel gasto : gastos) {
            totalGastos += gasto.getValor();
        }
        return totalGastos;

    }

}
