package escola.secretaria.Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import escola.secretaria.Enum.Sexo;
import escola.secretaria.Enum.Turma;
import escola.secretaria.Enum.Turnos;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Alunos")
public class Aluno implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Matricula")
    @NotNull
    private long matricula;

    @OneToOne(mappedBy = "matricula", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Resultados resultadosAlu;


    @Column(name = "Nome")
    @NotBlank(message = "O nome não pode ser vazio")
    @NotNull
    private String nome;

    @Column(name = "Turno")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Turnos turnos;

    @Column(name = "Turma")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Turma turma;

    @Column(name = "Idade")
    @NotNull
    private int idade;

    @Column(name = "Sexo")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Aluno(String nome, long matricula, Turnos turnos, int idade, Sexo sexo, Turma turma){
        this.nome = nome;
        this.matricula = matricula;
        this.turnos = turnos;
        this.idade = idade;
        this.sexo = sexo;
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public Turnos getTurnos() {
        return turnos;
    }

    public void setTurnos(Turnos turnos) {
        this.turnos = turnos;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Resultados getResultados() {
        return resultadosAlu;
    }

    public void setResultados(Resultados resultadosAlu) {
        this.resultadosAlu = resultadosAlu;
    }



}
