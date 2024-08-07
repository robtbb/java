package model.entities;

import java.io.Serial;
import java.io.Serializable;

public class ItemOS implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Double valorServico;
	private String observacoes;

	private OrdemServico ordem;
	private Servico servico;

	private Double descontoNoServico = 0.0;

	public ItemOS() {
		super();
	}

	public ItemOS(Double valorServico, String observacoes, OrdemServico ordem, Servico servico) {
		super();
		this.valorServico = valorServico;
		this.observacoes = observacoes;
		this.ordem = ordem;
		this.servico = servico;
	}

	public Double getValorServico() {
		return valorServico;
	}

	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public OrdemServico getOrdem() {
		return ordem;
	}

	public void setOrdem(OrdemServico ordem) {
		this.ordem = ordem;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	// VALOR APENAS DO DESCONTO EM CADA ITEM/SERVIÇO
	public Double getDescontoNoServico() {
		Double valorDoDesconto = 0.0;
		Double subtracao = valorServico - descontoNoServico;
		valorDoDesconto = getValorServico() - subtracao;
		return valorDoDesconto;
	}

	// RECEBE O VALOR PARA APLICAR O DESCONTO NO ITEM/SERVIÇO
	public void aplicaDescontoNoServico(Double desc) {
		this.descontoNoServico = desc;
	}

}
