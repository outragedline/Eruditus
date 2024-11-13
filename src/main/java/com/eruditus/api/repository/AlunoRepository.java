package com.eruditus.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.eruditus.api.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, String>{
    
    Aluno findByCodigo(long id);
    List<Aluno> findByNome(String nome);
    
}
