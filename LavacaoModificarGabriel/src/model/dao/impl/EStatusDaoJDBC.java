package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import model.dao.EStatusDao;
import model.entities.enuns.EStatus;

public class EStatusDaoJDBC implements EStatusDao{
	
	Connection conn = null;
	
	public EStatusDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	public EStatus findById(Integer id) {
		EStatus status = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select * from status where id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()) {
				status = EStatus.fromId(id);
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return status;
	}

	public EStatus findByString(String descricao) {
		EStatus status = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select * from status where descricao = ?");
			st.setString(1, descricao);
			rs = st.executeQuery();
			while(rs.next()) {
				status = EStatus.fromDescricao(descricao);
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return status;
	}

}
