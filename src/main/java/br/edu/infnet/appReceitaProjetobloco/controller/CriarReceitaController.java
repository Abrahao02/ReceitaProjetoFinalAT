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

import br.edu.infnet.appReceitaProjetobloco.model.domain.CriarReceita;
import br.edu.infnet.appReceitaProjetobloco.model.service.CriarReceitaService;


@RestController
@RequestMapping("/api/criarreceita")
public class CriarReceitaController {
	
	@Autowired
	private CriarReceitaService criarReceitaService;
	
	@GetMapping(value = "/listar")
	public List<CriarReceita> obterLista(){
		return (List<CriarReceita>) criarReceitaService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody CriarReceita criarReceita) {
		criarReceitaService.incluir(criarReceita); 
		
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		criarReceitaService.excluir(id);
		
	}

}
