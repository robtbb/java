package model.dao;

import java.util.List;

import model.entities.Modelo;

public interface ModeloDao {

	void insert(Modelo m);
	void update(Modelo m);
	void deleteById(Integer id);
	Modelo findById(Integer id);
	List<Modelo> findAll();	
}
