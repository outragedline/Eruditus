/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eruditus.models;

public class Cursos {
        private Integer id;
    private String nome;
    private String desc;
    private Integer duracao;
    private Integer numeroAulas;
    private Double horasDiarias;
    
    public Cursos(Integer id, String nome, String desc, Integer duracao, Integer numeroAulas, Double horasDiarias){
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.duracao = duracao;
        this.numeroAulas = numeroAulas;
        this.horasDiarias = horasDiarias;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getNumeroAulas() {
        return numeroAulas;
    }

    public void setNumeroAulas(Integer numeroAulas) {
        this.numeroAulas = numeroAulas;
    }

    public Double getHorasDiarias() {
        return horasDiarias;
    }

    public void setHorasDiarias(Double horasDiarias) {
        this.horasDiarias = horasDiarias;
    }
}
