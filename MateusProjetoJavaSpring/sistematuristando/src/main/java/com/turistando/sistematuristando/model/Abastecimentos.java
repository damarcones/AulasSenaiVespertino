package com.turistando.sistematuristando.model;

import java.time.LocalDate;

import com.turistando.sistematuristando.Enum.TipoCombsutiveis;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Abastecimentos")
public class Abastecimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAbastecimento;

    @Column(name= "Data", nullable=false)
    private LocalDate data;

    @Column(name= "Quilometragem", nullable=false)
    private double quilometragem;
    
    @Column(name= "TipoCombustivel", nullable=false)
    @Enumerated(EnumType.STRING)
    private TipoCombsutiveis tipoCombustivel; 
    
    @Column(name= "QuantidadeCombustivel", nullable=false)
    private double quantidadeCombustivel;

    @Column(name= "ValorTotal", nullable=false)
    private double valorTotal;

    @OneToOne
    @JoinColumn(name="idVeiculo")
    private Veiculos Veiculo;
    

}
