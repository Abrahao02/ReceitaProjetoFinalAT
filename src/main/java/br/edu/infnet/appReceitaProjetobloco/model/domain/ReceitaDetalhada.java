package br.edu.infnet.appReceitaProjetobloco.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ReceitaDetalhada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private CriarReceita criarReceita;

    @ManyToOne
    private Receita receita;

    @OneToMany(mappedBy = "receitaDetalhada", cascade = CascadeType.ALL)
    private List<Ingrediente> ingredientes;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CriarReceita getCriarReceita() {
		return criarReceita;
	}

	public void setCriarReceita(CriarReceita criarReceita) {
		this.criarReceita = criarReceita;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
    public String toString() {
        return String.format("Descrição: %s, Receita: %s, Ingredientes: %s",
                criarReceita.getDescricao(), receita.getNome(), ingredientesToString());
    }

    private String ingredientesToString() {
        if (ingredientes != null) {
            StringBuilder sb = new StringBuilder();
            for (Ingrediente ingrediente : ingredientes) {
                sb.append(ingrediente.toString()).append(", ");
            }
            return sb.toString();
        } else {
            return "Nenhum ingrediente";
        }
    }
}
