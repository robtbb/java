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
import model.dao.MarcaDao;
import model.entities.Marca;

public class MarcaDaoJDBC implements MarcaDao {

	Connection conn = null;

	public MarcaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	public void insert(Marca m) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("INSERT IGNORE INTO marca (Nome) VALUES (?) ", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, m.getNome());

			int linhasInseridas = st.executeUpdate();
			if (linhasInseridas > 0) {
				rs = st.getGeneratedKeys();
				if (rs.next()) {
					m.setId(rs.getInt(1));
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

	public void update(Marca m) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("UPDATE marca SET Nome = ? WHERE id_marca = ? ",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, m.getNome());
			st.setInt(2, m.getId());

			int linhasInseridas = st.executeUpdate();
			if (linhasInseridas > 0) {
				rs = st.getGeneratedKeys();
				if (rs.next()) {
					m.setId(rs.getInt(1));
				}
			} else {
				throw new DbException("Erro inesperado, nenhuma linha alterada");
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
		Marca m = findById(id);
		try {
			st = conn.prepareStatement("delete from marca where id_marca = ?");
			st.setInt(1, id);

			int numlinha = st.executeUpdate();
			if (numlinha > 0) {
				System.out.println("Removido! " + m);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	public Marca findById(Integer id) {
		Marca mc = new Marca();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from marca where id_marca = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				mc.setId(id);
				mc.setNome(rs.getString("Nome"));
			}
			return mc;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}


	public List<Marca> findAll() {
		List<Marca> marcas = new ArrayList<Marca>();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from marca");
			rs = st.executeQuery();
			while(rs.next()) {
				Marca m = new Marca(rs.getInt("id_marca"),rs.getString("Nome"));
				marcas.add(m);
			}
			return marcas;
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
