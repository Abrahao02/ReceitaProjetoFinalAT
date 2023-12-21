package br.edu.infnet.appReceitaProjetobloco.model.repositeres;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appReceitaProjetobloco.model.domain.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Integer>{
	List<Receita> findByCodigo(int codigo);
}