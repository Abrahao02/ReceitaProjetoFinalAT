package br.edu.infnet.appReceitaProjetobloco.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitaProjetobloco.model.domain.Endereco;
import br.edu.infnet.appReceitaProjetobloco.model.domain.Solicitante;
import br.edu.infnet.appReceitaProjetobloco.model.repositeres.SolicitanteRepository;

@Service
public class SolicitanteService {
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public void incluir(Solicitante solicitante) {
		
		String cep = solicitante.getEndereco().getCep();
		
		Endereco endereco = enderecoService.buscarCep(cep);
		
		solicitante.setEndereco(endereco);
		
		solicitanteRepository.save(solicitante);

	}
	
	public Collection<Solicitante> obterLista(){		
		return (Collection<Solicitante>) solicitanteRepository.findAll();
	}
	
	public void excluir(Integer id) {
		solicitanteRepository.deleteById(id);
	}
}