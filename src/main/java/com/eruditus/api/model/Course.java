package com.eruditus.api.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Course implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(unique = true)
    private long id;
    
    @NotEmpty
    private String name;
    
    @NotEmpty
    private String description;
    
    @NotEmpty
    private Integer duration;
    
    @OneToMany
    private List<Class> classObject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptioon() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Class> getClassObject() {
        return classObject;
    }

    public void setClass(List<Class> classObject) {
        this.classObject = classObject;
    }
    
    
    
}
