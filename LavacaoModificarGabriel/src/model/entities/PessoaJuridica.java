package model.entities;

import java.io.Serial;

public class PessoaJuridica extends Cliente{
	@Serial
	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String inscricaoEstadual;
	
	public PessoaJuridica() {
		super();
	}



	public PessoaJuridica(String cnpj, String inscricaoEstadual) {
		super();
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
	}



	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("\n");
		sb.append("CNPJ: ").append(cnpj).append("\n");
		sb.append("Inscrição estadual: ").append(inscricaoEstadual);
		return sb.toString();
	}
	
	
}
