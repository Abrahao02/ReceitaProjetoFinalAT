package br.edu.infnet.appReceitaProjetobloco.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitaProjetobloco.model.domain.ReceitaDetalhada;
import br.edu.infnet.appReceitaProjetobloco.model.repositeres.ReceitaDetalhadaRepository;

@Service
public class ReceitaDetalhadaService {

    @Autowired
    private ReceitaDetalhadaRepository receitaDetalhadaRepository;

    public List<ReceitaDetalhada> obterLista() {
        return receitaDetalhadaRepository.findAll();
    }

    public void incluir(ReceitaDetalhada receitaDetalhada) {
        receitaDetalhadaRepository.save(receitaDetalhada);
    }

    // Outros métodos conforme necessário

    // Exemplo de método para deletar uma ReceitaDetalhada por ID
    public void deletarPorId(Integer id) {
        receitaDetalhadaRepository.deleteById(id);
    }
    
}

