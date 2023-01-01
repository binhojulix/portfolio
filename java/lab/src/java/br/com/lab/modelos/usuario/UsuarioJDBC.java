/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.lab.modelos.tabela.Tabela;

/**
 *
 * @author fabio julio
 */
class UsuarioJDBC implements UsuarioDao {

    private Connection connection = null;

    public UsuarioJDBC(Connection conn) {
        connection = conn;
    }

    @Override
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO SOLICITANTE(MATRICULA, NOME, AREA, TELEFONE) VALUES(?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getMatricula());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getArea().getCodigo());
            stmt.setString(4, usuario.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario buscarPorLogin(String login) {
        Usuario usuario = null;

        String sql = "SELECT *FROM SOLICITANTE, AREA WHERE LOGIN = ? AND AREA_CODIGO = AREA";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    usuario = new Usuario();
                    Tabela area = new Tabela();
                    usuario.setMatricula(resultado.getString("MATRICULA"));
                    usuario.setNome(resultado.getString("NOME"));
                    usuario.setTelefone(resultado.getString("TELEFONE"));
                    usuario.setCargo(resultado.getString("CARGO"));
                    usuario.setManutenedor(resultado.getBoolean("MANTENEDOR"));
                    usuario.setLogin(resultado.getString("LOGIN"));
                    area.setCodigo(resultado.getString("AREA_CODIGO"));
                    area.setDescricao(resultado.getString("AREA_DESCRICAO"));
                    usuario.setArea(area);
                }
            }
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario buscarPorMatricula(String matricula) {
        Usuario usuario = null;
        String sql = "SELECT *FROM SOLICITANTE, AREA WHERE MATRICULA = ? AND AREA_CODIGO = AREA";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    usuario = new Usuario();
                    Tabela area = new Tabela();
                    usuario.setMatricula(resultado.getString("MATRICULA"));
                    usuario.setNome(resultado.getString("NOME"));
                    usuario.setTelefone(resultado.getString("TELEFONE"));
                    usuario.setCargo(resultado.getString("CARGO"));
                    usuario.setManutenedor(resultado.getBoolean("MANTENEDOR"));
                    usuario.setLogin(resultado.getString("LOGIN"));
                    area.setCodigo(resultado.getString("AREA_CODIGO"));
                    area.setDescricao(resultado.getString("AREA_DESCRICAO"));
                    usuario.setArea(area);
                }
            }
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE SOLICITANTE SET AREA = ?, TELEFONE = ? WHERE MATRICULA = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getArea().getCodigo());
            stmt.setString(2, usuario.getTelefone());
            stmt.setString(3, usuario.getMatricula());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> listar(String criterio) {

        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT MATRICULA, NOME, TELEFONE, AREA FROM SOLICITANTE WHERE MATRICULA LIKE ? OR NOME LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + criterio + "%");
            stmt.setString(2, "%" + criterio + "%");
            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    Usuario usuario = new Usuario();
                    Tabela area = new Tabela();
                    usuario.setMatricula(resultado.getString("MATRICULA"));
                    usuario.setNome(resultado.getString("NOME"));
                    usuario.setTelefone(resultado.getString("TELEFONE"));
                    area.setCodigo(resultado.getString("AREA"));
                    usuario.setArea(area);
                    usuarios.add(usuario);
                }
            }
            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> listar() {

        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT *FROM SOLICITANTE, AREA WHERE MANTENEDOR = TRUE AND AREA = AREA_CODIGO ORDER BY NOME";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    Usuario usuario = new Usuario();
                    Tabela area = new Tabela();
                    usuario.setMatricula(resultado.getString("MATRICULA"));
                    usuario.setNome(resultado.getString("NOME"));
                    usuario.setTelefone(resultado.getString("TELEFONE"));
                    usuario.setCargo(resultado.getString("CARGO"));
                    usuario.setManutenedor(resultado.getBoolean("MANTENEDOR"));
                    usuario.setLogin(resultado.getString("LOGIN"));
                    area.setCodigo(resultado.getString("AREA_CODIGO"));
                    area.setDescricao(resultado.getString("AREA_DESCRICAO"));
                    usuario.setArea(area);
                    usuarios.add(usuario);
                }
            }
            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
