package com.testetrabalho.Model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.testetrabalho.Enum.TipodeGasto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "Gastos")
public class GastoModel {
    
    @Id
 @Column (name = "idGasto")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long idGasto;

//     @ManyToOne(cascade= CascadeType.PERSIST)
//     @JoinColumn(name = "Placa", referencedColumnName="placa") 
//     private VeiculoModel veiculo;

@Column (name = "Tipo de gasto ")
  @Enumerated(EnumType.STRING)
  @NotNull
  private TipodeGasto gasto;

  @Column (name = "Valor")
  @Min(value = 1,message = "o valor não pode ser menor que um")
  @NotNull
  private double valor;

    @Column(name ="data")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;


  @Column(name = "descrição")
    @NotBlank (message = "O modelo não pode ser vazio") 
    @NotNull
    private String descricao;

    public void Gastosmodel(TipodeGasto gasto, double valor, Date data, String descricao) {
        this.gasto = gasto;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }
//  public VeiculoModel getVeiculoModel() {
//         return veiculo;
//     }
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
