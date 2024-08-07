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
import model.dao.FabricaDao;
import model.dao.MarcaDao;
import model.dao.ModeloDao;
import model.dao.MotorDao;
import model.entities.Marca;
import model.entities.Modelo;
import model.entities.Motor;
import model.entities.enuns.ECategoria;

public class ModeloJDBC implements ModeloDao{
	
	Connection conn = null;
	
	

	public ModeloJDBC(Connection conn) {
		this.conn = conn;
	}

	public void insert(Modelo m) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String sql ="insert ignore into modelo (Descricao ,marca_id, categoria_id, motor_id ) values (?, ?, ?, ?)";
			st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			st.setString(1, m.getDescricao());
			st.setInt(2, m.getMarca().getId());
			st.setInt(3, m.getCategoria().getId());
			st.setInt(4, m.getMotor().getId());
			int linhaAfetada = st.executeUpdate();
			if(linhaAfetada > 0) {
				rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Insert concluido! id = " + id );
					System.out.println(findById(id));
				}
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}


	public void update(Modelo m) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String sql ="update modelo set Descricao = ?,marca_id = ?,categoria_id = ?, motor_id = ? where id_modelo = ?";
			st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			st.setString(1, m.getDescricao());
			st.setInt(2, m.getMarca().getId());
			st.setInt(3, m.getCategoria().getId());
			st.setInt(4, m.getMotor().getId());
			st.setInt(5, m.getId());
			int linhaAfetada = st.executeUpdate();
			if(linhaAfetada > 0) {
				rs = st.getGeneratedKeys();
				if(rs.next()) {
					System.out.println("Update concluido! ");
				}
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}


	public void deleteById(Integer id) {
		Modelo modelo = findById(id);
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("delete from modelo where id_modelo = ?");
			st.setInt(1, id);
			
			int linhaApagada = st.executeUpdate();
			if(linhaApagada > 0) {
				System.out.println("Removido!\n=-=-=-=-=-=\n"+modelo+"\n=-=-=-=-=-=\n");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
		
	}


	public Modelo findById(Integer id) {
		Modelo modelo = new Modelo();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from modelo where id_modelo = ?");
			st.setInt(1, id);
			
			rs = st.executeQuery();
			while(rs.next()) {
				MarcaDao marcaDao = FabricaDao.createMarcaDao();
				MotorDao motorDao = FabricaDao.createMotorDao();
				modelo.setId(id);
				modelo.setDescricao(rs.getString("Descricao"));
				Marca marca = marcaDao.findById(rs.getInt("marca_id"));
				modelo.setMarca(marca);
				modelo.setCategoria(ECategoria.fromId(rs.getInt("categoria_id")));
				Motor motor = motorDao.findById(rs.getInt("motor_id"));
				modelo.setMotor(motor);
			}
			return modelo;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}


	public List<Modelo> findAll() {
		List<Modelo> modelos = new ArrayList<Modelo>();  
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from modelo");
			
			rs = st.executeQuery();
			while(rs.next()) {
				Modelo modelo = new Modelo();
				MarcaDao marcaDao = FabricaDao.createMarcaDao();
				MotorDao motorDao = FabricaDao.createMotorDao();
				modelo.setId(rs.getInt("id_modelo"));
				modelo.setDescricao(rs.getString("Descricao"));
				Marca marca = marcaDao.findById(rs.getInt("marca_id"));
				modelo.setMarca(marca);
				modelo.setCategoria(ECategoria.fromId(rs.getInt("categoria_id")));
				Motor motor = motorDao.findById(rs.getInt("motor_id"));
				modelo.setMotor(motor);
				
				modelos.add(modelo);
			}
			return modelos;
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
