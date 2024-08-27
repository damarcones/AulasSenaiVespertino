package ryantrabalhospring;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String tipo;
    private double valor;
    private LocalDate data;
    private String descricao;
    
    
    @ManyToOne
    @JoinColumn(name = "veiculo_id") 
    private Veiculo veiculo;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public double getValor() {
        return valor;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescericao(String descricao) {
        this.descricao = descricao;
    }


    public Veiculo getVeiculo() {
        return veiculo;
    }


    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    

}
