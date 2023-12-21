package br.edu.infnet.appReceitaProjetobloco.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Boolean vegana;
	private int codigo;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idSolicitante")
	private Solicitante solicitante;
	
    @OneToOne(mappedBy = "receita", cascade = CascadeType.ALL)
    private ReceitaDetalhada receitaDetalhada;
    
    
		
		
	public ReceitaDetalhada getReceitaDetalhada() {
		return receitaDetalhada;
	}

	public void setReceitaDetalhada(ReceitaDetalhada receitaDetalhada) {
		this.receitaDetalhada = receitaDetalhada;
	}

	@Override
	public String toString() {
		
		return String.format("nome (%s) - vegana (%s) - codigo (%d) - solicitante (%s) ", 
					nome, vegana, codigo, solicitante
				);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getVegana() {
		return vegana;
	}

	public void setVegana(Boolean vegana) {
		this.vegana = vegana;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}
	
}