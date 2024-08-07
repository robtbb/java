package com.culysoft.gestaovenda;

import com.culysoft.gestaovenda.modelo.conexao.Conexao;
import com.culysoft.gestaovenda.modelo.conexao.ConexaoMysql;
import com.culysoft.gestaovenda.modelo.dominio.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //chamando o mysql para confirmar conexao estabelecida
        //puxando informações do banco de dados 
        
        String sql = "Select * from categoria";
        
        Conexao conexao = new ConexaoMysql();
        
        //estrutura para inserir uma informação ao banco de dados
        Categoria categoria = new Categoria(null, "Bebida Java", "Insecao no netbeans");
        //aqui estamos criando o obj para incluir no sql, id é null pois o banco de dados
        // se encarrega de definir o id
        String inserirSQL = "INSERT INTO categoria(nome, descricao) VALUES(?, ?)";
        //em values esta sendo incluido  oque categoria que foi definido a cima
        PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(inserirSQL);
        // Obtém a conexão e prepara a instrução SQL para execução
        
        // Define os valores dos parâmetros da instrução SQL
        preparedStatement.setString(1, categoria.getNome());
        preparedStatement.setString(2, categoria.getDescricao());
        //so vale fazer a inclusão uma vez, se for rodar o codigo com os mesmos nomes
        //o banco dedados não vai aceitar pois vai dar como repetido o id
        
        // Executa a instrução SQL e retorna o número de linhas afetadas
        int resultadoDoCadastro = preparedStatement.executeUpdate();
        
        System.out.println(resultadoDoCadastro);
        
        
        
        
        //estrutura para consultar algo no banco de dados
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
        
        while(result.next()){
            System.out.println(result.getString("nome"));
        }
        
        
    }
}

//ao final pode pedir para adicionar addthrows clause for java ...
// adicione com a lampada