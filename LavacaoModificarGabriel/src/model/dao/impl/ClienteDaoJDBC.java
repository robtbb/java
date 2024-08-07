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
import model.dao.ClienteDao;
import model.entities.Cliente;
import model.entities.PessoaFisica;
import model.entities.PessoaJuridica;

public class ClienteDaoJDBC implements ClienteDao {

    Connection conn = null;

    public ClienteDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Cliente cliente) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT IGNORE INTO clientes (Tipo) VALUES (?)";
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, cliente.getTipo());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Cliente inserido!");
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    if (cliente.getTipo().equals("PF")) {
                        PessoaFisica PF = (PessoaFisica) cliente;
                        String sqlPF = "INSERT IGNORE INTO pessoa_fisica (Id,Nome,Celular,Email,CPF,Data_Nascimento) VALUES (?,?,?,?,?,?)";
                        st = conn.prepareStatement(sqlPF);
                        st.setInt(1, id);
                        st.setString(2, PF.getNome());
                        st.setString(3, PF.getcelular());
                        st.setString(4, PF.getEmail());
                        st.setString(5, PF.getCpf());
                        st.setDate(6, PF.getDataNascimento());

                        int linhaInserida = st.executeUpdate();
                        if (linhaInserida > 0) {
                            System.out.println("PF inserido com sucesso!!");
                        }
                    }
                    if (cliente.getTipo().equals("PJ")) {
                        PessoaJuridica PJ = (PessoaJuridica) cliente;
                        String sqlPJ = "INSERT IGNORE INTO pessoa_juridica (Id,Nome,Celular,Email,CNPJ,Inscricao_Estadual) VALUES (?,?,?,?,?,?)";
                        st = conn.prepareStatement(sqlPJ);
                        st.setInt(1, id);
                        st.setString(2, PJ.getNome());
                        st.setString(3, PJ.getcelular());
                        st.setString(4, PJ.getEmail());
                        st.setString(5, PJ.getCnpj());
                        st.setString(6, PJ.getInscricaoEstadual());

                        int linhaInserida = st.executeUpdate();
                        if (linhaInserida > 0) {
                            System.out.println("PJ inserido com sucesso!!");
                        }
                    }

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
    public void update(Cliente cliente) {
        int id = cliente.getId();
        PreparedStatement stClientes = null;
        ResultSet rsClientes = null;
        try {
            String sqlClientes = "SELECT * FROM clientes WHERE ID = ?";
            stClientes = conn.prepareStatement(sqlClientes);
            stClientes.setInt(1, id);
            rsClientes = stClientes.executeQuery();
            if (rsClientes.next()) {
                String tipo = rsClientes.getString("Tipo");
                if (tipo.equals("PF")) {
                    String sqlPF = "UPDATE pessoa_fisica SET Nome = ?,Celular = ?,Email = ?,CPF = ?,Data_Nascimento = ? WHERE Id = ?";
                    PreparedStatement stPF = conn.prepareStatement(sqlPF);
                    stPF.setString(1, cliente.getNome());
                    stPF.setString(2, cliente.getcelular());
                    stPF.setString(3, cliente.getEmail());
                    stPF.setString(4, ((PessoaFisica) cliente).getCpf());
                    stPF.setDate(5, ((PessoaFisica) cliente).getDataNascimento());
                    stPF.setInt(6, id);

                    int linhaAlterada = stPF.executeUpdate();
                    if (linhaAlterada > 0) {
                        System.out.println("PF atualizado(a) com sucesso!!");
                    }
                }
                if (tipo.equals("PJ")) {
                    String sqlPJ = "UPDATE pessoa_juridica SET Nome = ?,Celular = ?,Email = ?,CNPJ = ?,Inscricao_Estadual = ? WHERE Id = ?";
                    PreparedStatement stPJ = conn.prepareStatement(sqlPJ);
                    stPJ.setString(1, cliente.getNome());
                    stPJ.setString(2, cliente.getcelular());
                    stPJ.setString(3, cliente.getEmail());
                    stPJ.setString(4, ((PessoaJuridica) cliente).getCnpj());
                    stPJ.setString(5, ((PessoaJuridica) cliente).getInscricaoEstadual());
                    stPJ.setInt(6, id);

                    int linhaAlterada = stPJ.executeUpdate();
                    if (linhaAlterada > 0) {
                        System.out.println("PJ atualizado(a) com sucesso!!");
                    }
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(stClientes);
            DB.closeResultSet(rsClientes);
        }

    }

    @Override
    public void deleteById(Integer id) {
        Cliente c = findById(id);
        PreparedStatement stClientes = null;
        ResultSet rsClientes = null;
        try {
            String sqlClientes = "DELETE FROM clientes WHERE ID = ?";
            stClientes = conn.prepareStatement(sqlClientes);
            stClientes.setInt(1, id);
            int linhaAfetada = stClientes.executeUpdate();
            if (linhaAfetada > 0) {
                System.out.println("Cliente :\n");
                System.out.println(c);
                System.out.println("\nExcluido com sucesso! \n\n");

            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(stClientes);
            DB.closeResultSet(rsClientes);
        }
    }

    @Override
    public Cliente findById(Integer id) {
        PreparedStatement stClientes = null;
        ResultSet rsClientes = null;
        try {
            String sqlClientes = "SELECT * FROM clientes WHERE ID = ?";
            stClientes = conn.prepareStatement(sqlClientes);
            stClientes.setInt(1, id);
            rsClientes = stClientes.executeQuery();

            if (rsClientes.next()) {
                String tipo = rsClientes.getString("Tipo");

                if (tipo.equals("PF")) {
                    PessoaFisica PF = new PessoaFisica();
                    String sqlPF = "SELECT * FROM pessoa_fisica WHERE Id = ?";
                    PreparedStatement stPF = conn.prepareStatement(sqlPF);
                    stPF.setInt(1, id);

                    ResultSet rsPF = stPF.executeQuery();
                    if (rsPF.next()) {
                        PF.setId(id);
                        PF.setNome(rsPF.getString("Nome"));
                        PF.setcelular(rsPF.getString("Celular"));
                        PF.setEmail(rsPF.getString("Email"));
                        PF.setDataCadastro(rsPF.getTimestamp("Data_Cadastro"));
                        PF.setCpf(rsPF.getString("CPF"));
                        PF.recebeDataNascimento(rsPF.getDate("Data_Nascimento"));

                        return PF;
                    }
                } else if (tipo.equals("PJ")) {
                    PessoaJuridica PJ = new PessoaJuridica();
                    String sqlPJ = "SELECT * FROM pessoa_juridica WHERE Id = ?";
                    PreparedStatement stPJ = conn.prepareStatement(sqlPJ);
                    stPJ.setInt(1, id);

                    ResultSet rsPJ = stPJ.executeQuery();
                    if (rsPJ.next()) {
                        PJ.setId(id);
                        PJ.setNome(rsPJ.getString("Nome"));
                        PJ.setcelular(rsPJ.getString("Celular"));
                        PJ.setEmail(rsPJ.getString("Email"));
                        PJ.setDataCadastro(rsPJ.getTimestamp("Data_Cadastro"));
                        PJ.setCnpj(rsPJ.getString("CNPJ"));
                        PJ.setInscricaoEstadual(rsPJ.getString("Inscricao_Estadual"));

                        return PJ;
                    }
                }
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(stClientes);
            DB.closeResultSet(rsClientes);
        }
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> lista = new ArrayList<>();
        PreparedStatement stClientes = null;
        ResultSet rsClientes = null;
        try {
            String sqlClientes = "SELECT * FROM clientes";
            stClientes = conn.prepareStatement(sqlClientes);
            rsClientes = stClientes.executeQuery();
            while (rsClientes.next()) {
                int id = rsClientes.getInt("ID");
                Cliente c = findById(id);
                lista.add(c);
            }
            return lista;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(stClientes);
            DB.closeResultSet(rsClientes);
        }
    }

    @Override
    public List<Cliente> findAllLimit(Integer qtd) {
        List<Cliente> lista = new ArrayList<>();
        PreparedStatement stClientes = null;
        ResultSet rsClientes = null;
        try {
            String sqlClientes = "SELECT * FROM clientes LIMIT ?";
            stClientes = conn.prepareStatement(sqlClientes);
            stClientes.setInt(1, qtd);
            rsClientes = stClientes.executeQuery();
            while (rsClientes.next()) {
                int id = rsClientes.getInt("ID");
                Cliente c = findById(id);
                lista.add(c);
            }
            return lista;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(stClientes);
            DB.closeResultSet(rsClientes);
        }
    }

}
