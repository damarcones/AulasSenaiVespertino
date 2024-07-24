package escola.secretaria.Model;

import escola.secretaria.Enum.Disciplinas;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "Disciplinas")
public class DisciplinasModel {

    @Id
    @Column(name = "Id Disciplina")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    public Disciplinas getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplinas disciplinas) {
        this.disciplinas = disciplinas;
    }


    
}
