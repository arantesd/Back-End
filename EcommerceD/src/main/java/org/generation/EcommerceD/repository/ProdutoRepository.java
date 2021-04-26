package org.generation.EcommerceD.repository;

import java.util.List;

import org.generation.EcommerceD.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query(value = "SELECT * FROM tb_produto WHERE titulo_produto LIKE '%c%'", nativeQuery = true)
	public List<Produto> findBytituloProduto();
	
	@Query(value = "SELECT * FROM tb_produto WHERE valor >= 10 AND valor <= 100", nativeQuery = true)
	public List<Produto> findAllByValor();
	
}
