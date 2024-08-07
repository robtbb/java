package com.culysoft.gestaovenda;

import com.culysoft.gestaovenda.modelo.conexao.Conexao;
import com.culysoft.gestaovenda.modelo.conexao.ConexaoMysql;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //chamando o mysql para confirmar conexao estabelecida
        //se a conexao for bem sucedida, vai aparecer  infromação
        //--- exec:3.1.0:exec (default-cli) @ gestao-venda ---
        //com.mysql.cj.jdbc.ConnectionImpl@130d63be
        //em cima de BUILD SUCCESS
        
        Conexao conexao = new ConexaoMysql();
        
        System.out.println(conexao.obterConexao());
    }
}

//ao final pode pedir para adicionar addthrows clause for java ...
// adicione com a lampada