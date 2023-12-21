package br.edu.infnet.appReceitaProjetobloco.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ingrediente  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	private String NomeIngrediente;
	private float precoIngrediente;
	private float quantidadeIngrediente;
	private float quantidadeIngredienteUtilizada;
	
    @ManyToOne
    @JoinColumn(name = "idReceitaDetalhada")
    private ReceitaDetalhada receitaDetalhada;

	@Override
	public String toString() {
		
		return String.format("NomeIngrediente (%s) - precoIngrediente (%.2f) - quantidadeIngrediente (%.2f) - quantidadeIngredienteUtilizada (%.2f) - valorUtilizado (%.2f)", 
					 NomeIngrediente , precoIngrediente, quantidadeIngrediente, quantidadeIngredienteUtilizada, calcularCusto()
				);
	}
	
	
	
    public double calcularCusto() {
        double custoUnitario = precoIngrediente / quantidadeIngrediente;
        return custoUnitario * quantidadeIngredienteUtilizada;
    }
    

	public ReceitaDetalhada getReceitaDetalhada() {
		return receitaDetalhada;
	}



	public void setReceitaDetalhada(ReceitaDetalhada receitaDetalhada) {
		this.receitaDetalhada = receitaDetalhada;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeIngrediente() {
		return NomeIngrediente;
	}

	public void setNomeIngrediente(String nomeIngrediente) {
		NomeIngrediente = nomeIngrediente;
	}

	public float getPrecoIngrediente() {
		return precoIngrediente;
	}

	public void setPrecoIngrediente(float precoIngrediente) {
		this.precoIngrediente = precoIngrediente;
	}

	public float getQuantidadeIngrediente() {
		return quantidadeIngrediente;
	}

	public void setQuantidadeIngrediente(float quantidadeIngrediente) {
		this.quantidadeIngrediente = quantidadeIngrediente;
	}

	public float getQuantidadeIngredienteUtilizada() {
		return quantidadeIngredienteUtilizada;
	}

	public void setQuantidadeIngredienteUtilizada(float quantidadeIngredienteUtilizada) {
		this.quantidadeIngredienteUtilizada = quantidadeIngredienteUtilizada;
	}



	
}