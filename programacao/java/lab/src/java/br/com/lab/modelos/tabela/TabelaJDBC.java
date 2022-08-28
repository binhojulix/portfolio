/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.tabela;

import br.com.lab.modelos.modulo.ModuloAtraso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio julio
 */
class TabelaJDBC implements TabelaDao {

    private Connection connection = null;

    public TabelaJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Tabela> listar(String sql, String nome) {
        try {
            List<Tabela> tabelas = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Tabela tabela = new Tabela();
                tabela.setCodigo(resultado.getString(nome + "_CODIGO"));
                tabela.setDescricao(resultado.getString(nome + "_DESCRICAO"));
                tabelas.add(tabela);
            }
            resultado.close();
            stmt.close();
            return tabelas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Tabela getTabela(String codigo, String sql, String nome) {
        Tabela tabela = null;
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, codigo);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                tabela = new Tabela();
                tabela.setCodigo(resultado.getString(nome + "_CODIGO"));
                tabela.setDescricao(resultado.getString(nome + "_DESCRICAO"));
            }
            resultado.close();
            stmt.close();
            return tabela;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getFinalidade(String codigo) {
        try {
            String finalidade = "outros";
            String sql = "SELECT FINALIDADE_DESCRICAO FROM FINALIDADE WHERE FINALIDADE_CODIGO =?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, codigo + "0000");
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                finalidade = resultado.getString("FINALIDADE_DESCRICAO");
            }
            resultado.close();
            stmt.close();
            return finalidade;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Complexidade> listar() {
        try {
            List<Complexidade> complexidades = new ArrayList<>();
            String sql = "SELECT *FROM COMPLEXIDADE";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Complexidade complexidade = new Complexidade();
                complexidade.setCodigo(resultado.getString("CODIGO"));
                complexidade.setFator(resultado.getString("FATOR"));
                complexidade.setNivel(resultado.getString("NIVEL"));
                complexidades.add(complexidade);
            }
            resultado.close();
            stmt.close();
            return complexidades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ModuloAtraso getAtraso(String codigo, String tipo) {
        String sql = "SELECT *FROM ATRASO WHERE TIPO = ? AND ATRASO_CODIGO = ?";
        ModuloAtraso moduloAtraso = null;
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, tipo);
            stmt.setString(2, codigo);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                moduloAtraso = new ModuloAtraso();
                Tabela atraso = new Tabela();
                moduloAtraso.setCodigoAtraso(resultado.getString("CODIGO_ATRASO"));
                atraso.setCodigo(resultado.getString("ATRASO_CODIGO"));
                atraso.setDescricao(resultado.getString("ATRASO_DESCRICAO"));
                moduloAtraso.setTipo(resultado.getString("TIPO"));
                moduloAtraso.setAtraso(atraso);
            }
            resultado.close();
            stmt.close();
            return moduloAtraso;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
