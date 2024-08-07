package model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente implements Serializable,Comparable<Cliente>{
	@Serial
	private static final long serialVersionUID = 1L;
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	protected Integer id;
	protected String nome;
	protected String celular;
	protected String email;
	protected LocalDateTime dataCadastro;
	protected String tipo;
	
	List<Veiculo> veiculos = new ArrayList<>();

	public Cliente() {
		super();
	}
	

	public Cliente(Integer id, String nome, String celular, String email, LocalDateTime dataCadastro, String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.tipo = tipo;
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

	public String getcelular() {
		return celular;
	}

	public void setcelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	// MÉTODO PARA RECEBER A DATA  EM TIMESTEMP E CONVERTER-LA PARA LOCADATETIME
	public void setDataCadastro(Timestamp dataCadastro) {
		Timestamp time = dataCadastro;
		LocalDateTime data = time.toLocalDateTime();
		this.dataCadastro = data;
	}
	
	// MÉTODO PARA APRESENTAR A DATA DE CADASTRO FORMATADA NA REQUISIÇÃO
	public String dataFormatada() {
		String dataF = fmt.format(getDataCadastro());
		return dataF;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void addVeiculos(Veiculo v) {
		if(veiculos != null) {
			veiculos.add(v);
		}
		else {
			System.out.println("Error: car is null");
		}
	}
	
	public List<Veiculo> listaVeiculos(){
		List<Veiculo> lista =  new ArrayList<>();
		for(Veiculo v : veiculos) {
			lista.add(v);
		}
		return lista;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: ").append(id).append("\n");
		sb.append("Nome: ").append(nome).append("\n");
		sb.append("Celular: ").append(celular).append("\n");
		sb.append("E-mail: ").append(email).append("\n");
		sb.append("Data de Cadastro: ").append(dataFormatada()).append("\n");	
		return sb.toString();
	}

	public int compareTo(Cliente outro) {
		return nome.toLowerCase().compareTo(outro.getNome().toLowerCase());
	}
	
	
	
	
	
	
	
	;
	
	

}
