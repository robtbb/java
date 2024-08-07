package model.dao;

import java.util.List;

import model.entities.Motor;

public interface MotorDao {
	
	void insert(Motor m);
	void update(Motor m);
	void deleteById(Integer id);
	Motor findById(Integer id);
	List<Motor> findAll();

}
