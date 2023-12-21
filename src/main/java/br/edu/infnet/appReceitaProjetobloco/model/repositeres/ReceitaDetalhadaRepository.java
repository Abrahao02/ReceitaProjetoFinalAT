package br.edu.infnet.appReceitaProjetobloco.model.repositeres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appReceitaProjetobloco.model.domain.ReceitaDetalhada;

@Repository
public interface ReceitaDetalhadaRepository extends JpaRepository<ReceitaDetalhada, Integer> {
    // Métodos específicos, se necessário
}

