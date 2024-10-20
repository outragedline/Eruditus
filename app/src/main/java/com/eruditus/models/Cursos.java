package com.eruditus.models;

public class Cursos {
	private Integer id;
	private String nome;
	private String desc;
	private Integer duracao;
	private Integer cargaHorariaTotal;
	private Double cargaHorariaDiaria;

	public Cursos(Integer id, String nome, String desc, Integer duracao, Integer cargaHorariaTotal,
			Double cargaHorariaDiaria) {
		this.id = id;
		this.nome = nome;
		this.desc = desc;
		this.duracao = duracao;
		this.cargaHorariaTotal = cargaHorariaTotal;
		this.cargaHorariaDiaria = cargaHorariaDiaria;
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

	public Integer getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}

	public void setCargaHorariaTotal(Integer cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
	}

	public Double getCargaHorariaDiaria() {
		return cargaHorariaDiaria;
	}

	public void setCargaHorariaDiaria(Double cargaHorariaDiaria) {
		this.cargaHorariaDiaria = cargaHorariaDiaria;
	}

}
