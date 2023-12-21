package br.edu.infnet.appReceitaProjetobloco.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitaProjetobloco.model.domain.CriarReceita;
import br.edu.infnet.appReceitaProjetobloco.model.repositeres.CriarReceitaRepository;

@Service
public class CriarReceitaService {
	
	@Autowired
	private CriarReceitaRepository criarReceitaRepository;
	
	public void incluir(CriarReceita criarReceita) {
		criarReceitaRepository.save(criarReceita);

	}
	
	public Collection<CriarReceita> obterLista(){		
		return (Collection<CriarReceita>) criarReceitaRepository.findAll();
	}
	
	public void excluir(Integer id) {
		criarReceitaRepository.deleteById(id);
	}
} 