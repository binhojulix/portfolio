/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cptm.sc.modelos.material;

import br.com.cptm.sc.config.ConnectionFactory;
import br.com.cptm.sc.modelos.usuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabiolu
 */
public class MaterialJDBC {

    public void salvar(Material material) throws SQLException {

        String sql = "insert into cotacao_material (codigo_cptm,"
                + "descricao, osm, quantidade, tipo, status, solicitante, data_solicitacao)"
                + "values(?,?,?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement stmt = null;
        try {

            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, material.getCodigoCPTM());
            stmt.setString(2, material.getDescricao());
            stmt.setString(3, material.getOsm());
            stmt.setDouble(4, material.getQuantidade());
            stmt.setString(5, material.getTipo());
            stmt.setString(6, material.getStatus());
            stmt.setLong(7, material.getUsuario().getId());
            stmt.setDate(8, new java.sql.Date(material.getDataSolicitacao().getTime()));
            stmt.executeUpdate();

        } catch (SQLException ex) {
            connection.rollback();
            throw new RuntimeException(ex);
        } finally {
            stmt.close();
            connection.close();
        }
    }

    public void editar(Material material) throws SQLException {
        String sql = "update cotacao_material "
                + "set codigo_cptm=?, descricao=?, osm=?, quantidade=?, tipo=?, status=?"
                + " where id=?";
        Connection connection = null;
        PreparedStatement stmt = null;
        try {

            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, material.getCodigoCPTM());
            stmt.setString(2, material.getDescricao());
            stmt.setString(3, material.getOsm());
            stmt.setDouble(4, material.getQuantidade());
            stmt.setString(5, material.getTipo());
            stmt.setString(6, material.getStatus());
            stmt.setLong(7, material.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            connection.rollback();
            throw new RuntimeException(ex);
        } finally {
            stmt.close();
            connection.close();
        }
    }

    public void excluir(long id) throws SQLException {
        String sql = "delete from cotacao_material where id=?";
        Connection connection = null;
        try {
            connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeQuery();
        } catch (SQLException ex) {
            connection.rollback();
        } finally {
            connection.close();
        }
    }

    public List<Material> listar() throws SQLException {
        String sql = "select *from cotacao_material inner join solicitante on solicitante=solicitante.id";
        List<Material> materiais = new ArrayList<>();
        Connection connection = null;
        try {
            connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {

                Material material = new Material();

                material.setId(rst.getLong("id"));
                material.setCodigoCPTM(rst.getString("codigo_cptm"));
                material.setDescricao(rst.getString("descricao"));
                material.setOsm(rst.getString("osm"));
                material.setQuantidade(rst.getDouble("quantidade"));
                material.setTipo(rst.getString("tipo"));
                material.setStatus(rst.getString("status"));
                
                Usuario user = new Usuario();
                user.setId(rst.getInt("solicitante"));
                user.setNome(rst.getString("nome"));
                user.setMatricula(rst.getString("matricula"));
                
                material.setUsuario(user);

                materiais.add(material);

            }
        } catch (SQLException ex) {
            connection.rollback();
        } finally {
            connection.close();
        }
        return materiais;
    }

    public Material buscarMaterial(long id) throws SQLException {
        String sql = "select *from cotacao_material where id=?";
        Material material = null;
        Connection connection = null;
        try {
            connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                material = new Material();
                material.setId(rst.getLong("id"));
                material.setCodigoCPTM(rst.getString("codigo_cptm"));
                material.setDescricao(rst.getString("descricao"));
                material.setOsm(rst.getString("osm"));
                material.setQuantidade(rst.getDouble("quantidade"));
                material.setTipo(rst.getString("tipo"));
            }

        } catch (SQLException ex) {
            connection.rollback();
        } finally {
            connection.close();
        }
        return material;
    }
}
