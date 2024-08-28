package turistando.turistandospring.model;

import jakarta.persistence.*;
import turistando.turistandospring.Enum.TipoAbastecimento;


@Entity
public class AbastecimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quilometragem;
    private double valor;
    private double quantidade;

    @Enumerated(EnumType.STRING)
    public TipoAbastecimento tipoAbastecimento;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoModel veiculo;
    
    public TipoAbastecimento getTipoAbastecimento() {
        return tipoAbastecimento;
    }

    public void setTipoAbastecimento(TipoAbastecimento tipoAbastecimento) {
        this.tipoAbastecimento = tipoAbastecimento;
    }



    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public VeiculoModel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }
}

