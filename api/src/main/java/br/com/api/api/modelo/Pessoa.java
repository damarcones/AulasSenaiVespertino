package br.com.api.api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "Pessoas") // Caso queira mudar o nome da tabela, senão a tabela recebe o nome da classe
public class Pessoa {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

}
