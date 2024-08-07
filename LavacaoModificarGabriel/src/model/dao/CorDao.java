package model.dao;

import java.util.List;

import model.entities.Cor;

public interface CorDao {
	
	public void insert(Cor c);
	public void update(Cor c);
	public void deleteById(Integer id);
	public Cor findById(Integer id);
	public List<Cor> findAll();	

}
