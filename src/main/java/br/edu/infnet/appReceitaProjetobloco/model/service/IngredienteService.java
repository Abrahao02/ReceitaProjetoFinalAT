package br.edu.infnet.appReceitaProjetobloco.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitaProjetobloco.model.domain.Ingrediente;
import br.edu.infnet.appReceitaProjetobloco.model.repositeres.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public void incluir(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);

	}
	
	public Collection<Ingrediente> obterLista(){		
		return (Collection<Ingrediente>) ingredienteRepository.findAll();
	}
	
	public void incluirLista(List<Ingrediente> ingredientes) {
        ingredienteRepository.saveAll(ingredientes);
    }
	
	public void excluir(Integer id) {
		ingredienteRepository.deleteById(id);
	}
}

