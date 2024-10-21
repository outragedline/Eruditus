package com.eruditus.models;


public class Professor {
	private Integer id;
	private String nome;
	private Integer idade;
	private String formacao;
	private String sexo;


	public Professor(String nome, Integer idade, String formacao, String sexo) {
		this.nome = nome;
		this.idade = idade;
		this.formacao = formacao;
		this.sexo = sexo;
	}

	public Professor(Integer id, String nome, Integer idade, String formacao, String sexo) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.formacao = formacao;
		this.sexo = sexo;
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
