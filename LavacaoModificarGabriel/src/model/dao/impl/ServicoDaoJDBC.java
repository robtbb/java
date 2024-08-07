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
import model.dao.ServicoDao;
import model.entities.Servico;
import model.entities.enuns.ECategoria;

public class ServicoDaoJDBC implements ServicoDao {

	Connection conn = null;

	public ServicoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Servico s) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "insert ignore into servico (Descricao, Valor, Pontos, categoria_id) values (?, ?, ?, ?)";
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, s.getDescricao());
			st.setDouble(2, s.getValor());
			st.setInt(3, s.getPontos());
			st.setInt(4, s.getCategoria().getId());

			int linhasInseridas = st.executeUpdate();
			if (linhasInseridas > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					s.setId(rs.getInt(1));
					System.out.println("\nId gerado: " + s.getId() + " \n");
				}
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void update(Servico s) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "update servico set Descricao = ?, Valor = ?, Pontos = ?, categoria_id = ? where Id = ?";
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, s.getDescricao());
			st.setDouble(2, s.getValor());
			st.setInt(3, s.getPontos());
			st.setInt(4, s.getCategoria().getId());
			st.setInt(5, s.getId());

			int linhasInseridas = st.executeUpdate();
			if (linhasInseridas > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					s.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void deleteById(Integer id) {
		Servico s = findById(id);
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "delete from servico where Id = ?";
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, id);

			int numlinha = st.executeUpdate();
			if (numlinha > 0) {
				System.out.println("Removido! " + s);
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public Servico findById(Integer id) {
		Servico servico = new Servico();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "select * from servico where Id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);

			rs = st.executeQuery();
			while (rs.next()) {
				servico.setId(rs.getInt("Id"));
				servico.setDescricao(rs.getString("Descricao"));
				servico.setValor(rs.getDouble("Valor"));
				servico.setPontos(rs.getInt("Pontos"));
				servico.setCategoria(ECategoria.fromId(rs.getInt("categoria_id")));

			}
			return servico;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Servico> findAll() {
		List<Servico> servicos = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "select * from servico ";
			st = conn.prepareStatement(sql);

			rs = st.executeQuery();
			while (rs.next()) {
				Servico servico = new Servico();
				servico.setId(rs.getInt("Id"));
				servico.setDescricao(rs.getString("Descricao"));
				servico.setValor(rs.getDouble("Valor"));
				servico.setPontos(rs.getInt("Pontos"));
				servico.setCategoria(ECategoria.fromId(rs.getInt("categoria_id")));
				servicos.add(servico);
			}
			return servicos;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Servico> findAllPorCategoria(Integer id) {
		List<Servico> servicos = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM servico WHERE categoria_id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);

			rs = st.executeQuery();
			while (rs.next()) {
				Servico servico = new Servico();
				servico.setId(rs.getInt("Id"));
				servico.setDescricao(rs.getString("Descricao"));
				servico.setValor(rs.getDouble("Valor"));
				servico.setPontos(rs.getInt("Pontos"));
				servico.setCategoria(ECategoria.fromId(rs.getInt("categoria_id")));
				servicos.add(servico);
			}
			return servicos;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public Servico findServPorTipoECategoria(String servicoOferecido, String categoriaEmString) {
		Servico servico = new Servico();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT s.Descricao,s.Valor,s.Pontos,cat.Descricao As categoria FROM servico s "
							+ "LEFT JOIN categoria cat ON s.categoria_id = cat.id_categoria "
							+ "WHERE s.Descricao = ? && cat.Descricao =  ?";
			st = conn.prepareStatement(sql);
			st.setString(1, servicoOferecido);
			st.setString(2, categoriaEmString);

			rs = st.executeQuery();
			if (rs.next()) {
				servico.setDescricao(rs.getString("Descricao"));
				servico.setValor(rs.getDouble("Valor"));
				servico.setPontos(rs.getInt("Pontos"));
				servico.setCategoria(ECategoria.fromDescricao(rs.getString("categoria")));
			}
			return servico;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
}
