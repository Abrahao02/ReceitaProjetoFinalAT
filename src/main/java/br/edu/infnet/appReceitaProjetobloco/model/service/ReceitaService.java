package br.edu.infnet.appReceitaProjetobloco.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitaProjetobloco.model.domain.Receita;
import br.edu.infnet.appReceitaProjetobloco.model.repositeres.ReceitaRepository;


@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;
	
	
	
	public void incluir(Receita receita) {
		receitaRepository.save(receita);

	}
	
	public Collection<Receita> obterLista(){		
		return (Collection<Receita>) receitaRepository.findAll();
	}
	
	public List<Receita> obterPorCodigo(int codigo) {
        return receitaRepository.findByCodigo(codigo);
    }
	
	public void excluir(Integer id) {
		receitaRepository.deleteById(id);
	}

}
