package escola.secretaria.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import escola.secretaria.Model.Aluno;

@SuppressWarnings("rawtypes")
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @SuppressWarnings("null")
    public List<Aluno> findAll();
}
