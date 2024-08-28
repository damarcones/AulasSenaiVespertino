package turistando.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_despesas")
public class DespesaModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    
    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;

    @NotNull(message = "O valor não pode ser nulo")
    @Min(value = 0, message = "O valor não pode ser negativo")
    private double valor;

    @NotBlank(message = "A placa não pode ser vazia")
    private String placa;

    @NotBlank(message = "A categoria não pode ser vazia")
    private String categoria;

    @NotBlank(message = "A descrição não pode ser vazia")
    private String descricao;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    
}
