package org.generation.EcommerceD.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_loja")
@Getter
@Setter
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 20)
	private String nomeLoja;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String descricao;
	
	@OneToMany(mappedBy = "daLoja", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"daLoja","usuarioComprador"})
	private List<Produto> produtosDaLoja;
		
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "inscricao",
			joinColumns =  @JoinColumn(name = "fk_idUsuario"),
			inverseJoinColumns = @JoinColumn(name = "fk_idLoja"))
	@JsonIgnoreProperties({"produtosDoUsuario","minhasLojas","senha"})
	private List<Usuario> clienteUsuario;

}
