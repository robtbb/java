package model.dao;

import model.entities.enuns.ETipoCombustivel;

public interface ETipoCombustivelDao {

	ETipoCombustivel findById(Integer id);
	ETipoCombustivel findByString(String descricao);
}
