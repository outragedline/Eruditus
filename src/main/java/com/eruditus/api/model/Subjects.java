package com.eruditus.api.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Subjects implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(unique = true)
    private long id;
    
    @NotEmpty
    private String name;
    
    @NotEmpty
    private String description;
    
    @NotEmpty
    private Double hoursOfInstruction;
    
    @ManyToOne
    private Course course;
            
    @ManyToOne
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getHoursOfInstruction() {
        return hoursOfInstruction;
    }

    public void setHoursOfInstruction(Double hoursOfInstruction) {
        this.hoursOfInstruction = hoursOfInstruction;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
