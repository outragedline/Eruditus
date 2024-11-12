package com.eruditus.api.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Turma implements Serializable {
    
    @Id
    @GeneratedValue
    @Column (unique = true)
    private long id;
    
    @NotEmpty
    private long vagas;
    
    @ManyToOne
    private List<Aluno> aluno;

    public long getVagas() {
        return vagas;
    }

    public void setVagas(long vagas) {
        this.vagas = vagas;
    }

    public List<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }
    
    
}
