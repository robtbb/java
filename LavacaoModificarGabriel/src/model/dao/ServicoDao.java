package model.dao;

import java.util.List;

import model.entities.Servico;

public interface ServicoDao {

	void insert(Servico s);
	void update(Servico s);
	void deleteById(Integer id);
	Servico findById(Integer id);
	List<Servico> findAll();
	List<Servico> findAllPorCategoria(Integer id);
	Servico findServPorTipoECategoria(String servicoOferecido,String categoriaEmString);
}
