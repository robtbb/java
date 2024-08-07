package model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.entities.enuns.ECategoria;

public class Modelo implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;

	private Marca marca;

	private Motor motor;
	
	private ECategoria categoria;

	private List<Veiculo> veiculos = new ArrayList<Veiculo>();

	public Modelo() {
		super();
	}

	public Modelo(Integer id, String descricao, Marca marca, Motor motor, ECategoria categoria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.marca = marca;
		this.motor = motor;
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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public ECategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(ECategoria categoria) {
		this.categoria = categoria;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	public void addVeiculo(Veiculo v) {
		veiculos.add(v);
	}
	
	public void removeVeiculo(Veiculo v) {
		veiculos.remove(v);
	}
	
	public Integer updateVeiculo(Veiculo v) {
		for(Veiculo veiculo : veiculos) {
			if(veiculo.getId() == v.getId()) {
				veiculo.setId(v.getId());
				veiculo.setPlaca(v.getPlaca());
				veiculo.setObservacao(v.getObservacao());
				veiculo.setCor(v.getCor());
				veiculo.setModelo(v.getModelo());
			}
		}
		return v.getId();
	}
	
	public Veiculo veiculoPorId(Integer id) {
		Veiculo v = new Veiculo();
		for(Veiculo veiculo : veiculos) {
			if(veiculo.getId() == id) {
				v = veiculo;
			}
		}
		return v;
	}
	
	
	

	@Override
	public String toString() {
		return "\nModelo: " + descricao +"\n"+ marca + motor;
	}

}
