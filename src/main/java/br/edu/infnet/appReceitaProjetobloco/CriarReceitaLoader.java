package br.edu.infnet.appReceitaProjetobloco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitaProjetobloco.model.domain.CriarReceita;
import br.edu.infnet.appReceitaProjetobloco.model.domain.Ingrediente;
import br.edu.infnet.appReceitaProjetobloco.model.domain.Receita;
import br.edu.infnet.appReceitaProjetobloco.model.domain.Solicitante;
import br.edu.infnet.appReceitaProjetobloco.model.service.CriarReceitaService;

@Order(5)
@Component
public class CriarReceitaLoader implements ApplicationRunner {
	
	@Autowired
	private CriarReceitaService criarReceitaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/CriarReceita.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		CriarReceita criarReceita = null;
		
		while(linha != null) {
			campos = linha.split(";");
			
			switch (campos[0]) {
			case "P":
				criarReceita = new CriarReceita();
				criarReceita.setDescricao(campos[1]);
				criarReceita.setWeb(Boolean.valueOf(campos[2]));
				criarReceita.setData(LocalDateTime.now());
				
				criarReceitaService.incluir(criarReceita);
				
				break;

			case "B":
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setNomeIngrediente(campos[1]);
				ingrediente.setPrecoIngrediente(Float.valueOf(campos[2]));
				ingrediente.setQuantidadeIngrediente(Float.valueOf(campos[3]));
				ingrediente.setQuantidadeIngredienteUtilizada(Float.valueOf(campos[4]));
				
//				criarReceita.getReceita().add(ingrediente);
				
				break;
				
			default:
				break;
			}

			linha = leitura.readLine();
		}
		
		for(CriarReceita p : criarReceitaService.obterLista()) {
			System.out.println("[CRIAR-RECEITA] " + p);			
		}
		
		leitura.close();
	}

}
