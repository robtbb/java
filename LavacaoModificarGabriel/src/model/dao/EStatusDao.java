package model.dao;

import model.entities.enuns.EStatus;

public interface EStatusDao {
	
	EStatus findById(Integer id);
	EStatus findByString(String descricao);

}
