/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.finalidade;

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
public class FinalidadeJDBC implements FinalidadeDao {

    private final Connection connection;

    public FinalidadeJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvar(Equipamento finalidade) {
        String sql = "insert into finalidade(finalidade_codigo, finalidade_descricao)values(?,?)";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setString(1, finalidade.getCodigo());
            preparedStatement.setString(2, finalidade.getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void editar(Equipamento finalidade) {
        String sql = "update finalidade set finalidade_descricao = ? where finalidade_codigo = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setString(1, finalidade.getDescricao());
            preparedStatement.setString(2, finalidade.getCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir(String codigo) {
        String sql = "delete from finalidade where finalidade_codigo = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setString(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Equipamento getFinalidades(String codigo) {
        String sql = "select *from finalidade where finalidade_codigo = ? ";
        Equipamento finalidade = null;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setString(1, codigo);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    finalidade = new Equipamento();
                    finalidade.setCodigo(resultSet.getString("finalidade_codigo"));
                    finalidade.setDescricao(resultSet.getString("finalidade_descricao"));
                }
            }
            return finalidade;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Equipamento> listar() {
        String sql = "select *from finalidade where"
                + " (select substring(finalidade.FINALIDADE_CODIGO, 4, 8)) = '00000000' "
                + "order by finalidade_codigo ";

        List<Equipamento> equipamentos = new ArrayList<>();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String codigo = resultSet.getString("finalidade_codigo");
                    String descricao = resultSet.getString("finalidade_descricao");
                    Equipamento equipamento = new Equipamento();
                    equipamento.setCodigo(codigo);
                    equipamento.setDescricao(descricao);
                    equipamentos.add(equipamento);
                }
            }
            return equipamentos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Equipamento> listar(String search) {
        String sql = "select *from finalidade where"
                + "(select substring(finalidade.FINALIDADE_CODIGO, 4, 2)) <> '00' "
                + "AND (select substring(finalidade.FINALIDADE_CODIGO, 6, 6)) = '000000' "
                + "and finalidade_codigo like ? order by finalidade_codigo";

        List<Equipamento> equipamentos = new ArrayList<>();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + search + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String codigo = resultSet.getString("finalidade_codigo");
                    String descricao = resultSet.getString("finalidade_descricao");
                    Equipamento equipamento = new Equipamento();
                    equipamento.setCodigo(codigo);
                    equipamento.setDescricao(descricao);
                    equipamentos.add(equipamento);
                }
            }
            return equipamentos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Equipamento> listAll() {
        String sql = "select *from finalidade where (select substring(finalidade.FINALIDADE_CODIGO, 8, 12)) = '0000' order by finalidade_codigo";

        List<Equipamento> equipamentos = new ArrayList<>();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String codigo = resultSet.getString("finalidade_codigo");
                    String descricao = resultSet.getString("finalidade_descricao");
                    Equipamento equipamento = new Equipamento();
                    equipamento.setCodigo(codigo);
                    equipamento.setDescricao(descricao);
                    equipamentos.add(equipamento);
                }
            }
            return equipamentos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
