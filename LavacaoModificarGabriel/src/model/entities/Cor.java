package model.entities;

import java.io.Serial;
import java.io.Serializable;

public class Cor implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public Cor() {
		super();
	}

	public Cor(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Cor: " + nome;
	}
}
