package model.entities;

import java.io.Serial;
import java.io.Serializable;

import model.entities.enuns.ECategoria;

public class Servico implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private Double valor;
	private static Integer pontos;

	private ECategoria categoria;

	public Servico() {
		super();
	}

	public Servico(Integer id, String descricao, Double valor, ECategoria categoria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.setCategoria(categoria);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		Servico.pontos = pontos;
	}

	public ECategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(ECategoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(getId() == null){
			sb.append(descricao).append(", Valor: ").append(valor).append(", Pontos: ").append(pontos).append(", Categoria: ").append(categoria);
		}
		else{
			sb.append("[ Serviço | Id  ").append(id).append(" ] : ").append(descricao).append(", Valor: ").append(valor).append(", Pontos: ").append(pontos).append(", Categoria: ").append(categoria);
		}
		return sb.toString();
	}
}
