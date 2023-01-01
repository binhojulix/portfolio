/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.finalidade;

import br.com.lab.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fabiolu
 */
public class FinalidadeRN {

    public FinalidadeRN() {
        super();
    }

    public void salvarEditar(Equipamento equipamento) {
    
        if (getFinalidade(equipamento.getCodigo()) == null) {
            salvar(equipamento);
        } else {
            editar(equipamento);
        }
    }

    private void salvar(Equipamento finalidade) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            try {
                FinalidadeJDBC finalidadeJDBC = new FinalidadeJDBC(connection);
                finalidadeJDBC.salvar(finalidade);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void editar(Equipamento finalidade) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            try {
                FinalidadeJDBC finalidadeJDBC = new FinalidadeJDBC(connection);
                finalidadeJDBC.editar(finalidade);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluir(String codigo) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            FinalidadeJDBC finalidadeJDBC = new FinalidadeJDBC(connection);
            finalidadeJDBC.excluir(codigo);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Equipamento getFinalidade(String codigo) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            FinalidadeJDBC finalidadeJDBC = new FinalidadeJDBC(connection);
            return finalidadeJDBC.getFinalidades(codigo);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Equipamento> listar() {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            FinalidadeJDBC finalidadeJDBC = new FinalidadeJDBC(connection);
            return finalidadeJDBC.listar();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Equipamento> listar(String codigo) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            FinalidadeJDBC finalidadeJDBC = new FinalidadeJDBC(connection);
            return finalidadeJDBC.listar(codigo);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Equipamento> listarAll() {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            FinalidadeJDBC finalidadeJDBC = new FinalidadeJDBC(connection);
            return finalidadeJDBC.listAll();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean isSistema(String param) {
        return param.substring(3, 11).equals("00000000");
    }

    public boolean isSub(String param) {
        return param.substring(5, 11).equals("000000") && !isSistema(param);
    }

}
