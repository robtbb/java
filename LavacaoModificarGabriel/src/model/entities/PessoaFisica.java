package model.entities;

import java.io.Serial;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import db.DbException;

public class PessoaFisica extends Cliente {
	@Serial
	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private String cpf;
	private Date dataNascimento;
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(Integer id, String nome, String celular, String email, LocalDateTime dataCadastro,
			String tipoPF, SimpleDateFormat sdf, String cpf, Date dataNascimento) {
		super();
		this.sdf = sdf;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

//	public void recebeDataNascimento(java.sql.Date dataRecebida) {
//		java.util.Date convertida = new java.util.Date(dataRecebida.getTime());
//		this.nascUtil = convertida;
//	}

	public void recebeDataNascimento(java.sql.Date dataRecebida) {
		this.dataNascimento = dataRecebida;
	}

	public void enviaDataNascimento(String enviaData) {
		try {
			java.util.Date utilDate = sdf.parse(enviaData);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			this.dataNascimento = sqlDate;
		} catch (ParseException e) {
			throw new DbException("Error na data: " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("\n");
		sb.append("CPF: ").append(cpf).append("\n");
		sb.append("Data de Nascimento: ").append(sdf.format(dataNascimento));
		return sb.toString();
	}

}
