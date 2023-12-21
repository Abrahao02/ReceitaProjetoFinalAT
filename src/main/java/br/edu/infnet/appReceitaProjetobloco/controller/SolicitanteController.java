package br.edu.infnet.appReceitaProjetobloco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appReceitaProjetobloco.model.domain.Solicitante;
import br.edu.infnet.appReceitaProjetobloco.model.service.SolicitanteService;

@RestController
@RequestMapping("/api/solicitante")
public class SolicitanteController {
	
	@Autowired
	private SolicitanteService solicitantesService;
	
	@GetMapping(value = "/listar")
	public List<Solicitante> obterLista(){
		return (List<Solicitante>) solicitantesService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Solicitante solicitante) {
		solicitantesService.incluir(solicitante); 
		
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		solicitantesService.excluir(id);
		
	}
			
}
