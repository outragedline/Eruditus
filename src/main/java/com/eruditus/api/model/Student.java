package com.eruditus.api.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Student implements Serializable {
    
    private static final long serrialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @NotEmpty
    private long code;
    
    @NotEmpty
    private String name;
    
    @NotEmpty
    private String gender;
    
    @NotEmpty
    private Integer age;
    
    @ManyToOne
    private Class classObject;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    
    private List<Contacts> contacts;
    
    public long getCode(){
        return code;
    }
    
    public void setCode(long code){
        this.code = code;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    public Class getClassObject() {
        return classObject;
    }

    public void setClassObject(Class classObject) {
        this.classObject = classObject;
    }
 
}
