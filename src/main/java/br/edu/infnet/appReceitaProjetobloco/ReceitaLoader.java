package br.edu.infnet.appReceitaProjetobloco;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitaProjetobloco.model.domain.Receita;
import br.edu.infnet.appReceitaProjetobloco.model.domain.Solicitante;
import br.edu.infnet.appReceitaProjetobloco.model.service.ReceitaService;

@Order(3)
@Component
public class ReceitaLoader implements ApplicationRunner {

	@Autowired
	private ReceitaService receitaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/Receita.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";");

			Receita receita = new Receita();
			receita.setNome(campos[0]);
			receita.setCodigo(Integer.valueOf(campos[1]));
			receita.setVegana(Boolean.valueOf(campos[2]));
			receita.setSolicitante(new Solicitante(Integer.valueOf(campos[3])));

			
			receitaService.incluir(receita);
			
			linha = leitura.readLine();
		}

		for(Receita receita : receitaService.obterLista()) {
			System.out.println("[RECEITA] " + receita);			
		}
				
		leitura.close();
	}

}