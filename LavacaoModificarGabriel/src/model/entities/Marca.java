package model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Marca implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	private static Set<Modelo> modelos = new HashSet<Modelo>();

	public Marca() {
		super();
	}

	public Marca(Integer id, String nome) {
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
	
	public Set<Modelo> getModelos(){
		return modelos;
	}
	
	public List<Modelo> listAllModelo(){
		List<Modelo> lista = new ArrayList<Modelo>();
		for(Modelo mod : modelos) {
			lista.add(mod);
		}
		return lista;
	}
	
	public List<String> nomeModelo(){
		System.out.println("\n\t\t** MARCAS CADASTRADOS **\n");
		List<String> list = new ArrayList<String>();
		for(Modelo nome : modelos) {
			list.add(nome.getDescricao());
		}
		return list;
	}
	
	public void addModelo(Modelo mod) {
		modelos.add(mod);
	}
	

	@Override
	public String toString() {
		return "Marca: " + nome;
	}

}
