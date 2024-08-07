
package com.culysoft.gestaovenda;

import com.culysoft.gestaovenda.modelo.dao.UsuarioDao;
import com.culysoft.gestaovenda.modelo.dominio.Perfil;
import com.culysoft.gestaovenda.modelo.dominio.Usuario;

public class UsuarioTest {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(0L, "leo", "1234", "leo", Perfil.PADRAO, null, null);
        
        UsuarioDao usuarioDao = new UsuarioDao();
        String mensagem = usuarioDao.salvar(usuario);
        System.out.println(mensagem);
    }
}

