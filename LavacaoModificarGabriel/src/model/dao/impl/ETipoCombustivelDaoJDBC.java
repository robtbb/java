package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import model.dao.ETipoCombustivelDao;
import model.entities.enuns.ETipoCombustivel;

public class ETipoCombustivelDaoJDBC implements ETipoCombustivelDao{

	Connection conn = null;
	
	public ETipoCombustivelDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	

	public ETipoCombustivel findById(Integer id) {
		ETipoCombustivel comb = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select * from combustivel where id_combustivel = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()) {
				comb = ETipoCombustivel.fromId(id);
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return comb;
	}

	public ETipoCombustivel findByString(String descricao) {
		ETipoCombustivel comb = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select * from combustivel where Descricao = ?");
			st.setString(1, descricao);;
			rs = st.executeQuery();
			while(rs.next()) {
				comb = ETipoCombustivel.fromDescricao(descricao);
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return comb;
	}

}
