package org.generation.EcommerceD.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String tituloProduto;
	
	private Float valor;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String urlImagem;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_idUsuario")
	@JsonIgnoreProperties({"produtosDoUsuario","minhasLojas"})
	private Usuario usuarioComprador;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_idLoja")
	@JsonIgnoreProperties({"produtosDaLoja","clienteUsuario"})
	private Loja daLoja;

}
