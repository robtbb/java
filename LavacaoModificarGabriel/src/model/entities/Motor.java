package model.entities;

import java.io.Serial;
import java.io.Serializable;

import model.entities.enuns.ETipoCombustivel;

public class Motor implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer potencia;
	
	private ETipoCombustivel combustivel;
	
	private Modelo modelo;
	
	
	public Motor() {
		super();
	}
	

	public Motor(Integer id, Integer potencia, ETipoCombustivel combustivel) {
		super();
		this.id = id;
		this.potencia = potencia;
		this.combustivel = combustivel;
	}


	public Motor(Integer id, Modelo modelo, Integer potencia, ETipoCombustivel combustivel) {
		super();
		this.id = id;
		this.potencia = potencia;
		this.combustivel = combustivel;
		this.modelo = modelo;
	}
	
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public Integer getPotencia() {
		return potencia;
	}


	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}


	public ETipoCombustivel getCombustivel() {
		return combustivel;
	}


	public void setCombustivel(ETipoCombustivel combustivel) {
		this.combustivel = combustivel;
	}


	@Override
	public String toString() {
		return "\nMotor: Id = "+ id + "\nPotência [" + potencia + "]\nCombustível: " + combustivel;
	}
}
