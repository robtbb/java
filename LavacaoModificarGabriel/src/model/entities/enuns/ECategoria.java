package model.entities.enuns;

import db.DbException;

public enum ECategoria {

	PEQUENO(1,"Pequeno"),
	MEDIO(2,"Medio"),
	GRANDE(3,"Grande"),
	MOTO(4,"Moto"),
	PADRAO(5,"Padrao");
	
	private int id;
	private String descricao;
	
	private ECategoria(int id, String descricao) {
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
	
	public static ECategoria fromDescricao(String Desc) {
		for(ECategoria categoria : ECategoria.values()) {
			if(categoria.getDescricao().equalsIgnoreCase(Desc)) {
				return categoria;
			}
		}
		throw new DbException("Categoria Inválida " + Desc);
	}
	
	public static ECategoria fromId(Integer Id) {
		for(ECategoria categoria : ECategoria.values()) {
			if(categoria.getId() == Id) {
				return categoria;
			}
		}
		throw new DbException("Error, Id não encontrado: " + Id);
	}
	
	public static int findIdByDescricao(String descricao){
		for(ECategoria categoria : ECategoria.values()){
			if(categoria.getDescricao().equalsIgnoreCase(descricao)){
				return categoria.getId();
			}
		}
		return -1;
	}
	
	public String ApresentaCat() {
		StringBuilder sb = new StringBuilder();
		sb.append("Categoria: ").append(descricao).append("\n");
		return sb.toString();
	}
}
