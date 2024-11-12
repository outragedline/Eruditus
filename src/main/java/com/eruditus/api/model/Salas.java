package com.eruditus.api.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Salas implements Serializable {
    
    @Id
    @GeneratedValue
    @Column (unique = true)
    private long id;
    
    @NotEmpty
    private long capacide;
    
    @NotEmpty
    private String drescricao;
    
    @NotEmpty
    private String recursos;

    public long getCapacide() {
        return capacide;
    }

    public void setCapacide(long capacide) {
        this.capacide = capacide;
    }

    public String getDrescricao() {
        return drescricao;
    }

    public void setDrescricao(String drescricao) {
        this.drescricao = drescricao;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }
    
    
}
