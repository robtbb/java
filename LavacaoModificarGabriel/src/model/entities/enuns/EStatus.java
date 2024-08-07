package model.entities.enuns;

import db.DbException;

public enum EStatus {
	
	ABERTA(1,"Aberta"),
	FECHADA(2,"Fechada"),
	CANCELADA(3,"Cancelada");
	
	private int id;
	private String descricao;
	
	
	private EStatus(int id, String descricao) {
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
	
	public static Integer qtdStatus() {
		return EStatus.values().length;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static EStatus fromDescricao(String Desc) {
		for(EStatus status : EStatus.values()) {
			if(status.getDescricao().equalsIgnoreCase(Desc)) {
				return status;
			}
		}
		throw new DbException("Categoria Inválida " + Desc);
	}
	
	public static EStatus fromId(Integer Id) {
		for(EStatus status : EStatus.values()) {
			if(status.getId() == Id) {
				return status;
			}
		}
		throw new DbException("Error, Id não encontrado: " + Id);
	}
	
	public String ApresentaStatus() {
		StringBuilder sb = new StringBuilder();
		sb.append("Status: ").append(descricao).append("\n");
		return sb.toString();
	}
}
