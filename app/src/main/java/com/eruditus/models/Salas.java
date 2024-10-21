package com.eruditus.models;

public class Salas {
	private Integer id;
	private String nome;
	private Integer capacidade;
	private String tipo;
	private String recursos;
	private String andar;


	public Salas(String nome, Integer capacidade, String tipo, String recursos,
			String andar) {
		this.nome = nome;
		this.capacidade = capacidade;
		this.tipo = tipo;
		this.recursos = recursos;
		this.andar = andar;
	}

	public Salas(Integer id, String nome, Integer capacidade, String tipo, String recursos,
			String andar) {
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		this.tipo = tipo;
		this.recursos = recursos;
		this.andar = andar;
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

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRecursos() {
		return recursos;
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

}
