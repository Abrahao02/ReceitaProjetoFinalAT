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

import br.edu.infnet.appReceitaProjetobloco.model.domain.Ingrediente;
import br.edu.infnet.appReceitaProjetobloco.model.service.IngredienteService;

@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {

	@Autowired
	private IngredienteService ingredienteService;
	
	@GetMapping(value = "/listar")
	public List<Ingrediente> obterLista(){
		return (List<Ingrediente>) ingredienteService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Ingrediente ingrediente) {
		ingredienteService.incluir(ingrediente); 
		
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		ingredienteService.excluir(id);
		
	}
}
