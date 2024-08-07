
package com.culysoft.gestaovenda.modelo.dao;


import com.culysoft.gestaovenda.modelo.conexao.Conexao;
import com.culysoft.gestaovenda.modelo.conexao.ConexaoMysql;
import com.culysoft.gestaovenda.modelo.dominio.Perfil;
import com.culysoft.gestaovenda.modelo.dominio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioDao {
    private final Conexao conexao;
    
    public UsuarioDao(){
        this.conexao = new ConexaoMysql();
    }
    
    public String salvar(Usuario usuario){
        return usuario.getId() == 0L ? adicionar(usuario) : editar(usuario);
    }// se for igual a 0 (0L)(ZERO LONG) pois o id é do tipo log 
    // isso acima é um if ternario true adiciona false editar

    private String adicionar(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, usuario, senha, perfil, estado) VALUES(?, ?, ?, ?, ?)";
        
        Usuario usuarioTemp = buscarUsuarioPeloUsuario(usuario.getUsuario());
        
        if(usuarioTemp != null){
            return String.format("Error: usuario %s ja existe no banco de dados", usuario.getUsuario());
        }
        try{
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, usuario);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Usuario adicionado com sucesso" : "Nao foi possivel adicionar usuario";
        } catch (SQLException e){
            return String.format("Error: %s", e.getMessage());
        }
    }

    private String editar(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, usuario = ?, senha = ?, perfil = ?, estado=? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, usuario);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Usuario adicionado com sucesso" : "Nao foi possivel adicionar usuario";
        } catch (SQLException e){
            return String.format("Error: %s", e.getMessage());
        }
    }

    private void preencherValoresPreparedStatement(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
   //usando para pictografar a senha
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        String senhaCrypt = passwordEncoder.encode(usuario.getSenha());
        
        preparedStatement.setString(1, usuario.getNome());
    preparedStatement.setString(2, usuario.getUsuario());
    preparedStatement.setString(3, senhaCrypt);
    preparedStatement.setString(4, usuario.getSenha());
    preparedStatement.setBoolean(5, usuario.isEstado()); // Corrigido para setBoolean
    
    if(usuario.getId() != 0L){
        preparedStatement.setLong(6, usuario.getId());
    }
}

    
    
    public List<Usuario> buscarTodosUsuarios(){
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try{
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()){
                usuarios.add(getUsuario(result));
            }
        }catch(Exception e){
            System.out.println(String.format("Error: ", e.getMessage()));
        }
        return usuarios;
    }
    
    
    
    private Usuario getUsuario(ResultSet result) throws SQLException{
        Usuario usuario = new Usuario();
        
        usuario.setId(result.getLong("id"));
        usuario.setNome(result.getString("nome"));
        usuario.setUsuario(result.getString("usuario"));
        usuario.setSenha(result.getString("senha"));
        usuario.setPerfil(result.getObject("perfil", Perfil.class));
        usuario.setEstado(result.getBoolean("estado"));
        usuario.setDataHoraCriacao(result.getObject("data_hora_craicao", LocalDateTime.class));
        usuario.setUltimoLogin(result.getObject("ultipo_login", LocalDateTime.class));
        
        return usuario;
    }
        
    
   
    public Usuario buscarTodosUsuariosPeloId(Long id){
        String sql = String.format("SELECT * FROM usuario WHERE id = %d", id);
        try{
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()){
                return getUsuario(result);
            }
        }catch(SQLException e){
            System.out.println(String.format("Error: ", e.getMessage()));
        }
        return null;
    }
    
    
    public Usuario buscarUsuarioPeloUsuario(String usuario){
        String sql = String.format("SELECT * FROM usuario WHERE id = %s", usuario);
        try{
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()){
                return getUsuario(result);
            }
        }catch(SQLException e){
            System.out.println(String.format("Error: ", e.getMessage()));
        }
        return null;
    }
}


/*

********  THROWS   **********

Explicação do Exemplo:
public void metodoQuePodeLancarExcecao() throws SQLException:

Declara que o método metodoQuePodeLancarExcecao pode
lançar uma SQLException. O método não trata a exceção 
internamente, então ele precisa ser declarado com throws SQLException.
throw new SQLException("Erro ao acessar o banco de dados");:

Lança uma nova SQLException dentro do método.
try e catch no main:

O método metodoQuePodeLancarExcecao é chamado dentro de 
um bloco try, e a exceção SQLException é capturada no bloco catch.
Quando Usar throws:
Exceções Checadas (Checked Exceptions):

throws é usado para exceções checadas que devem ser tratadas 
ou declaradas. Por exemplo, IOException ou SQLException.
Exceções Não Checadas (Unchecked Exceptions):

Exceções não checadas, como RuntimeException, não precisam ser 
declaradas com throws. Elas são usadas para indicar erros de 
programação, como NullPointerException e IllegalArgumentException.

*/