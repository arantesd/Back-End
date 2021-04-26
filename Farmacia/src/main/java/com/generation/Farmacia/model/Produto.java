package com.generation.Farmacia.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class Produto {
			
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@Size(min = 5, max = 500)
		private String nome;
		
		@NotNull
		@Size(min = 5, max = 500)
		private String descricaoTitulo;
		
		@NotNull
		private Long preco;
		
		@Temporal(TemporalType.TIMESTAMP)
		private Date data = new java.sql.Date(System.currentTimeMillis());
		
		@OneToMany(mappedBy = "produto" , cascade = CascadeType.ALL)
		@JsonIgnoreProperties("produto")
		private List<Categoria> categoria;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getProduto() {
			return nome;
		}

		public void setProduto(String nome) {
			this.nome = nome;
		}

		public String getDescricaoTitulo() {
			return descricaoTitulo;
		}

		public void setDescricaoTitulo(String descricaoTitulo) {
			this.descricaoTitulo = descricaoTitulo;
		}

		public Long getPreco() {
			return preco;
		}

		public void setPreco(Long preco) {
			this.preco = preco;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}
		

		public List<Categoria> getCategoria() {
			return categoria;
		}

		public void setCategoria(List<Categoria> categoria) {
			this.categoria = categoria;
		}	

}
