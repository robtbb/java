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
import model.dao.CorDao;
import model.entities.Cor;

public class CorDaoJDBC implements CorDao{

	private Connection conn = null;
	
	public CorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	public void insert(Cor c) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("INSERT INTO `cor`(`Nome`) VALUES (?) "
					+ "ON DUPLICATE KEY UPDATE Nome = Nome",Statement.RETURN_GENERATED_KEYS);
			st.setString(1, c.getNome());
			
			int linhasAfetadas = st.executeUpdate();
			if(linhasAfetadas > 0) {
				rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					c.setId(id);
				}
			}
			else {
				throw new DbException("Erro inesperado, nenhuma linha inserida");
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

	public void update(Cor c) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE cor SET Nome = ? WHERE Id = ?",Statement.RETURN_GENERATED_KEYS);
			st.setString(1, c.getNome());
			st.setInt(2, c.getId());
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}


	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("delete from cor where Id = ?",Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}


	public Cor findById(Integer id) {
		Cor cor = new Cor();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select * from cor where Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				cor.setId(id);
				cor.setNome(rs.getString("Nome"));
			}
			return cor;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}


	public List<Cor> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Cor> cores = new ArrayList<Cor>();
		try {
			st = conn.prepareStatement("select * from cor");
			rs = st.executeQuery();
			while(rs.next()) {
				Cor cor = new Cor(rs.getInt("Id"),rs.getString("Nome"));
				cores.add(cor);
			}
			return cores;
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
