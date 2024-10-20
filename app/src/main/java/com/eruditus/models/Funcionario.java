package com.eruditus.models;

public class Funcionario {
	private Integer id;
	private String nome;
	private Integer idade;
	private String formacao;
	private String sexo;
	private String funcao;

	public Funcionario(Integer id, String nome, Integer idade, String formacao, String sexo,
			String funcao) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.formacao = formacao;
		this.sexo = sexo;
		this.funcao = funcao;
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
