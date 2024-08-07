package model.entities.enuns;

import db.DbException;

public enum ETipoCombustivel {

	
	GASOLINA(1,"Gasolina"),
	ETANOL(2,"Etanol"),
	FLEX(3,"Flex"),
	DIESEL(4,"Diesel"),
	GNV(5,"GNV"),
	OUTRO(6,"Outro");
	
	private int id;
	private String descricao;
	
	private ETipoCombustivel(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static ETipoCombustivel fromDescricao(String Desc) {
		for(ETipoCombustivel combustivel : ETipoCombustivel.values()) {
			if(combustivel.getDescricao().equalsIgnoreCase(Desc)) {
				return combustivel;
			}
		}
		throw new DbException("Categoria Inválida " + Desc);
	}
	
	public static ETipoCombustivel fromId(Integer Id) {
		for(ETipoCombustivel combustivel : ETipoCombustivel.values()) {
			if(combustivel.getId() == Id) {
				return combustivel;
			}
		}
		throw new DbException("Error, Id não encontrado: " + Id);
	}
	
	public String ApresentaCombustivel() {
		StringBuilder sb = new StringBuilder();
		sb.append("Combustivel: ").append(descricao).append("\n");
		return sb.toString();
	}
}
