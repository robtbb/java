package com.culysoft.gestaovenda.modelo.dao;

import com.culysoft.gestaovenda.modelo.dominio.Perfil;
import com.culysoft.gestaovenda.modelo.dominio.Usuario;
import com.culysoft.gestaovenda.modelo.exception.NegocioException;
import com.culysoft.gestaovenda.view.modelo.LoginDto;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AutenticacaoDao {

    private final UsuarioDao usuarioDao;

    public AutenticacaoDao() {
        this.usuarioDao = new UsuarioDao();
    }

    public boolean temPermissao(Usuario usuario) {
        try {
            permissao(usuario);
            return true;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Usuario sem permissao", 0);
            return false;
        }
    }

    //aqui estamos criando uma essecao para quando o usuario nao
    // for igual ao admin isso é ferificado em (!Perfil.ADMIN) se o perfil for diferente de admin
    // equal (fazendo uma comparação com (usuario.getPerfil())
    // a messagem vai ser enciada para a classe neocioEception
    private void permissao(Usuario usuario) {
        if (!Perfil.ADMIN.equals(usuario.getPerfil())) {
            throw new NegocioException("Sem permissão para realizar essa ação");
        }
    }

    public Usuario login(LoginDto login) {
        Usuario usuario = usuarioDao.buscarUsuarioPeloUsuario(login.getUsuario());

        if (usuario == null || !usuario.isEstado()) {
            return null; // ou se usuario for diferente de true (!usuario.isEstado())
        }
        if (usuario.isEstado() && validaSenha(usuario.getSenha(), login.getSenha())) {
            return usuario;
        }
        return null;
    }
    //metodo implementado se a gente não tivesse usado spring securit
//    private boolean validaSenha(String senhaUsuario, String senhaLogin){
//        return senhaUsuario.equals(senhaLogin);
//    }

    //verificando se a senha do login são iguais
    private boolean validaSenha(String senhaUsuario, String senhaLogin) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(senhaLogin, senhaUsuario);
    }

}


//aqui finaliza entao a parte de esquema de permissão,
//permissividade de login