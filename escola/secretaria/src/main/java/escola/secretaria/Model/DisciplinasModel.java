package escola.secretaria.Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import escola.secretaria.Enum.Disciplinas;
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
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "Disciplinas")
public class DisciplinasModel implements Serializable{

    @Id
    @Column(name = "IdDisciplina")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "idDis", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Resultados resultadosDis;


    public Disciplinas getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplinas disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Column(name = "Nome")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Disciplinas disciplinas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

 


    
}
