/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.usuario;

import java.util.List;
import br.com.lab.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fabio julio
 */
public class UsuarioRN {

    public UsuarioRN() {
        super();
    }

    public Usuario buscarPorMatricula(String matricula) {
        if (matricula != null) {
            try (Connection conn = new ConnectionFactory().getConnection()) {
                return new UsuarioJDBC(conn).buscarPorMatricula(matricula);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }

    public Usuario buscarPorLogin(String login) {
        if (login != null) {
            try (Connection conn = new ConnectionFactory().getConnection()) {
                return new UsuarioJDBC(conn).buscarPorLogin(login);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }

    public List<Usuario> listarUsuarios() {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            return new UsuarioJDBC(conn).listar();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Usuario> listarUsuarios(String criterio) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            return new UsuarioJDBC(conn).listar(criterio);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void salvar(Usuario usuario) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            UsuarioJDBC usuarioJDBC = new UsuarioJDBC(conn);
            try {
                if (buscarPorMatricula(usuario.getMatricula()) != null) {
                    usuarioJDBC.atualizar(usuario);
                } else {
                    usuarioJDBC.salvar(usuario);
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
