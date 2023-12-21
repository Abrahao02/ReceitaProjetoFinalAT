package br.edu.infnet.appReceitaProjetobloco.model.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CriarReceita{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	private String descricao;
	private LocalDateTime data;
	private boolean web;
	
    @OneToOne(mappedBy = "criarReceita", cascade = CascadeType.ALL)
    private ReceitaDetalhada receitaDetalhada;
	
	public ReceitaDetalhada getReceitaDetalhada() {
		return receitaDetalhada;
	}

	public void setReceitaDetalhada(ReceitaDetalhada receitaDetalhada) {
		this.receitaDetalhada = receitaDetalhada;
	}

	@Override
	public String toString() {

		return String.format("%s - descricao (%s) - data (%s) - web (%s) ", 
				super.toString(), descricao, data, web 
				);
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public boolean isWeb() {
		return web;
	}
	public void setWeb(boolean web) {
		this.web = web;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
//	public double calcularCustoTotal() {
//	    double custoTotal = 0;
//	    
//	    if (ingredientes != null) {
//	        for (Ingrediente ingrediente : ingredientes) {
//	            custoTotal += ingrediente.calcularCusto();
//	        }
//	    }
//	    
//	    return custoTotal;
//	}

}