package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import model.dao.ECategoriaDao;
import model.entities.enuns.ECategoria;

public class ECategoriaDaoJDBC implements ECategoriaDao{
	
	Connection conn = null;
	
	public ECategoriaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	public ECategoria findById(Integer id) {
		ECategoria cat = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select * from categoria where id_categoria = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()) {
				cat = ECategoria.fromId(id);
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return cat;
	}

	public ECategoria findByString(String nome) {
		ECategoria cat = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select * from categoria where Descricao = ?");
			st.setString(1, nome);;
			rs = st.executeQuery();
			while(rs.next()) {
				cat = ECategoria.fromDescricao(nome);
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return cat;
	}

}
