package model.entities;

import java.io.Serial;
import java.io.Serializable;

public class Veiculo implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String placa;
	private String observacao;
	
	private Cor cor;
	
	private Modelo modelo;

	public Veiculo() {
		super();
	}

	public Veiculo(Integer id, String placa, String observacao, Cor cor, Modelo modelo) {
		super();
		this.id = id;
		this.placa = placa;
		this.observacao = observacao;
		this.cor = cor;
		this.modelo = modelo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "\nPlaca: " + placa + "\nObservacao: " + observacao + cor + ", " + modelo;
	}
	
	
}
