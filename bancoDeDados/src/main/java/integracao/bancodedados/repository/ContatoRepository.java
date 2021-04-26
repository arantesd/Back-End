package integracao.bancodedados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.integracao.bancodedados.model.ContatoModel;


public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {

}