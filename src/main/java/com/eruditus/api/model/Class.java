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
public class Class implements Serializable {
    
    @Id
    @GeneratedValue
    @Column (unique = true)
    private long id;
    
    @NotEmpty
    private long capacity;
    
    @ManyToOne
    private List<Student> student;

    public long getCapacity() {
        return capacity;
    }

    public void setVagas(long capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setAluno(List<Student> student) {
        this.student = student;
    }
    
    
}
