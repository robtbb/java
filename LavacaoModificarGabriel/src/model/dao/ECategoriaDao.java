package model.dao;

import model.entities.enuns.ECategoria;

public interface ECategoriaDao {


	ECategoria findById(Integer id);
	ECategoria findByString(String descricao);

}
