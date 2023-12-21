package br.edu.infnet.appReceitaProjetobloco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitaProjetobloco.model.domain.CriarReceita;
import br.edu.infnet.appReceitaProjetobloco.model.domain.Ingrediente;
import br.edu.infnet.appReceitaProjetobloco.model.domain.Receita;
import br.edu.infnet.appReceitaProjetobloco.model.domain.ReceitaDetalhada;
import br.edu.infnet.appReceitaProjetobloco.model.domain.Solicitante;
import br.edu.infnet.appReceitaProjetobloco.model.service.CriarReceitaService;
import br.edu.infnet.appReceitaProjetobloco.model.service.IngredienteService;
import br.edu.infnet.appReceitaProjetobloco.model.service.ReceitaDetalhadaService;
import br.edu.infnet.appReceitaProjetobloco.model.service.ReceitaService;

@Order(2)
@Component
public class ReceitaDetalhadaLoader implements ApplicationRunner {

    @Autowired
    private ReceitaDetalhadaService receitaDetalhadaService;

    @Autowired
    private CriarReceitaService criarReceitaService;

    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private IngredienteService ingredienteService;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/ReceitaDetalhada.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            CriarReceita criarReceita = new CriarReceita();
            criarReceita.setDescricao(campos[0]);
            criarReceita.setWeb(Boolean.valueOf(campos[1]));
            criarReceita.setData(LocalDateTime.now());
            criarReceitaService.incluir(criarReceita);

            Receita receita = new Receita();
            receita.setNome(campos[2]);
            receita.setCodigo(Integer.valueOf(campos[3]));
            receita.setVegana(Boolean.valueOf(campos[4]));
            receita.setSolicitante(new Solicitante(Integer.valueOf(campos[5])));
            receitaService.incluir(receita);

            ReceitaDetalhada receitaDetalhada = new ReceitaDetalhada();
            receitaDetalhada.setCriarReceita(criarReceita);
            receitaDetalhada.setReceita(receita);

            List<Ingrediente> ingredientes = new ArrayList<>();
            for (int i = 6; i < campos.length; i += 4) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setNomeIngrediente(campos[i]);
                ingrediente.setPrecoIngrediente(Float.valueOf(campos[i + 1]));
                ingrediente.setQuantidadeIngrediente(Float.valueOf(campos[i + 2]));
                ingrediente.setQuantidadeIngredienteUtilizada(Float.valueOf(campos[i + 3]));
                ingrediente.setReceitaDetalhada(receitaDetalhada);
                ingredientes.add(ingrediente);
            }

            receitaDetalhada.setIngredientes(ingredientes);
            receitaDetalhadaService.incluir(receitaDetalhada);

            criarReceitaService.incluir(criarReceita);
            receitaService.incluir(receita);
            ingredienteService.incluirLista(ingredientes);

            linha = leitura.readLine();
        }

        for (ReceitaDetalhada receitaDetalhada : receitaDetalhadaService.obterLista()) {
            System.out.println("[RECEITA-DETALHADA] " + receitaDetalhada);
        }

        leitura.close();
    }
}
