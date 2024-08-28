package turistando.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import turistando.enuns.CombustivelEnum;

@Entity
@Table(name = "tb_veiculo")
public class VeiculoModel implements Serializable {

    @Id
    @NotNull(message = "O campo não pode ser nulo")
    private String placa;

    @NotNull(message = "Marca não pode ser nula")
    private String marca;

    @NotNull(message = "Modelo não pode ser nulo")
    private String modelo;

    @NotNull(message = "Ano do modelo não pode ser nulo")
    @Min(value = 1886, message = "Ano do modelo deve ser maior ou igual a 1886")
    private int anoModelo;

    @NotNull(message = "Ano de fabricação não pode ser nulo")
    @Min(value = 1886, message = "Ano de fabricação deve ser maior ou igual a 1886")
    private int anoFabricacao;

    @NotNull(message = "Cor não pode ser nula")
    private String cor;

    @NotNull(message = "RENAVAM não pode ser nulo")
    @Min(value = 1, message = "RENAVAM deve ser positivo")
    private long renavam;

    @NotNull(message = "Motorização não pode ser nula")
    @Positive(message = "Motorização deve ser positiva")
    private double motorizacao;

    @NotNull(message = "Capacidade do tanque não pode ser nula")
    @Positive(message = "Capacidade do tanque deve ser positiva")
    private double capacidadeTanque;

    @Positive(message = "Capacidade do tanque deve ser positiva")
    private double quantidadeCombustivel=0;

    @NotNull(message = "Tipo de combustível não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private CombustivelEnum combustivel;

    @OneToOne
    private AbastecimentoModel abastecimentos;

    @OneToOne
    private DespesaModel despesas;

    public AbastecimentoModel getAbastecimentos() {
        return abastecimentos;
    }
    public void setAbastecimentos(AbastecimentoModel abastecimentos) {
        this.abastecimentos = abastecimentos;
    }
    public DespesaModel getDespesas() {
        return despesas;
    }
    public void setDespesas(DespesaModel despesas) {
        this.despesas = despesas;
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
    public CombustivelEnum getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(CombustivelEnum combustivel) {
        this.combustivel = combustivel;
    }
    public double getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }
    public void setQuantidadeCombustivel(double quantidadeCombustivel) {
        this.quantidadeCombustivel = quantidadeCombustivel;
    }

    

}
