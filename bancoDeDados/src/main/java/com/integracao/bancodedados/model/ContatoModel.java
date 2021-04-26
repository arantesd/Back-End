package com.integracao.bancodedados.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class ContatoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O campus DDD é obrigatório, favor preencher")
	private String ddd;
	
	@NotEmpty(message = "O campus telefone é obrigatório, favor preencher")
	private String telefone;
	
	@NotEmpty(message = "O campus nome é obrigatório, favor preencher")
	private String nome;
	
	public ContatoModel() {	} //construtor vazio
	
	public ContatoModel(String nome, String ddd, String telefone) {
		this.nome = nome;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
