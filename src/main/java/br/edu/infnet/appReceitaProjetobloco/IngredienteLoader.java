package br.edu.infnet.appReceitaProjetobloco;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitaProjetobloco.model.domain.Ingrediente;
import br.edu.infnet.appReceitaProjetobloco.model.service.IngredienteService;

@Order(4)
@Component
public class IngredienteLoader implements ApplicationRunner {

	@Autowired
	private IngredienteService ingredienteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/Ingrediente.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";");

			Ingrediente ingrediente = new Ingrediente();
			ingrediente.setNomeIngrediente(campos[0]);
			ingrediente.setPrecoIngrediente(Float.valueOf(campos[1]));
			ingrediente.setQuantidadeIngrediente(Float.valueOf(campos[2]));
			ingrediente.setQuantidadeIngredienteUtilizada(Float.valueOf(campos[3]));
			
			ingredienteService.incluir(ingrediente);
			
			linha = leitura.readLine();
		}

		for(Ingrediente ingrediente : ingredienteService.obterLista()) {
			System.out.println("[INGREDIENTE] " + ingrediente);			
		}
				
		leitura.close();
	}

}
