package com.eruditus.api.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.Column;

@Entity
public class Administrator implements Serializable{
    
    @Id
    @Column(unique = true)
    private long id;
    
    @NotEmpty
    private String name;
    
    @OneToMany
    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
