package br.edu.infnet.appReceitaProjetobloco.model.repositeres;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appReceitaProjetobloco.model.domain.CriarReceita;


@Repository
public interface CriarReceitaRepository extends CrudRepository<CriarReceita, Integer>{
	
}
