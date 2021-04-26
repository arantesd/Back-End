package org.generation.EcommerceD.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 20)
	private String usuario;
	
	@NotNull
	@Size(min = 6, max = 10)
	private String senha;
	
	@OneToMany(mappedBy = "usuarioComprador" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"usuarioComprador","daLoja"})
	private List<Produto> produtosDoUsuario;
	
	@ManyToMany(mappedBy = "clienteUsuario" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"produtosDaLoja","clienteUsuario"})
	private List<Loja> minhasLojas;

}
