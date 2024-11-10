package com.eruditus.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Cursos {
    
    @Id
    @GeneratedValue
    @Column(unique = true)
    private long id;
    
    @NotEmpty
    private String nome;
    
    @NotEmpty
    private String desc;
    
    @NotEmpty
    private Integer duracao;
    
    @OneToMany
    private List<Turma> turma;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }
    
    
    
}
