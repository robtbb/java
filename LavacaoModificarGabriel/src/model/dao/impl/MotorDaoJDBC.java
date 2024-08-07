package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.MotorDao;
import model.entities.Motor;
import model.entities.enuns.ETipoCombustivel;

public class MotorDaoJDBC implements MotorDao {

	Connection conn = null;

	public MotorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	public void insert(Motor m) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("INSERT IGNORE INTO motor (Potencia,combustivel_id) VALUES (?,?) ", Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, m.getPotencia());
			st.setInt(2, m.getCombustivel().getId());

			int linhasInseridas = st.executeUpdate();
			if (linhasInseridas > 0) {
				 rs = st.getGeneratedKeys();
				if (rs.next()) {
					m.setId(rs.getInt(1));
					System.out.println("\nId gerado: " + m.getId() +" \n");
				}
			} else {
				throw new DbException("Erro inesperado, nenhuma linha inserida");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}


	public void update(Motor m) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("UPDATE motor SET Potencia = ?, combustivel_id = ? where id_motor = ? ", Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, m.getPotencia());
			st.setInt(2, m.getCombustivel().getId());
			st.setInt(3, m.getId());

			int linhasInseridas = st.executeUpdate();
			if (linhasInseridas > 0) {
				 rs = st.getGeneratedKeys();
				if (rs.next()) {
					m.setId(rs.getInt(1));
					System.out.println("\nId gerado: " + m.getId() +" \n");
				}
			} else {
				throw new DbException("Erro inesperado, nenhuma linha inserida");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}


	public void deleteById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Motor m = findById(id);
		try {
			st = conn.prepareStatement("delete from motor where id_motor = ?");
			st.setInt(1, id);

			int numlinha = st.executeUpdate();
			if (numlinha > 0) {
				System.out.println("\nRemovido! " + m + "\n");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}


	public Motor findById(Integer id) {
		Motor motor = new Motor();
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			st = conn.prepareStatement("select * from motor where id_motor = ? ");
			st.setInt(1, id);
			 
			rs =  st.executeQuery();
			while(rs.next()) {
				motor.setId(id);
				motor.setPotencia(rs.getInt("Potencia"));
				motor.setCombustivel(ETipoCombustivel.fromId(rs.getInt("combustivel_id")));
			}
			return motor;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	public List<Motor> findAll() {
		List<Motor> motores = new ArrayList<Motor>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			st = conn.prepareStatement("select * from motor ");			 
			rs =  st.executeQuery();
			while(rs.next()) {
				Motor motor = new Motor(rs.getInt("id_motor"),rs.getInt("Potencia"),ETipoCombustivel.fromId(rs.getInt("combustivel_id")));
				motores.add(motor);
			}
			return motores;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
