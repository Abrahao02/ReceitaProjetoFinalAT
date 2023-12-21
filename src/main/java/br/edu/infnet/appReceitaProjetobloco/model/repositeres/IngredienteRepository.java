package br.edu.infnet.appReceitaProjetobloco.model.repositeres;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appReceitaProjetobloco.model.domain.Ingrediente;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Integer>{
	
}