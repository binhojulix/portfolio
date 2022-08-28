/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.movimentacao;

import br.com.lab.modelos.material.MaterialRN;
import java.util.Date;
import java.util.List;
import br.com.lab.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fabio julio
 */
public class MovimentacaoRN {

    public MovimentacaoRN() {
        super();

    }

    //CARREGA O PROXIMO NUMERO A SER GERADO
    public Integer carregar() {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            MovimentacaoDao movimentacaoDao = new MovimentacaoJDBC(connection);
            return movimentacaoDao.carregar();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void salvar(Movimentacao movimentacao) {

        try (Connection connection = new ConnectionFactory().getConnection()) {
            MovimentacaoDao movimentacaoDao = new MovimentacaoJDBC(connection);
            MaterialRN materialDao = new MaterialRN();
            try {
                if (movimentacao.getTipo().equals("SAIDA") || movimentacao.getTipo().equals("AMX")) {
                    movimentacao.getMaterial().setEstoque(movimentacao.getMaterial().getEstoque()
                            - movimentacao.getQuantidade());
                    materialDao.salvar(movimentacao.getMaterial());

                } else if (movimentacao.getTipo().equals("ENTRADA")) {
                    movimentacao.getMaterial().setEstoque(movimentacao.getMaterial().getEstoque()
                            + movimentacao.getQuantidade());
                    materialDao.salvar(movimentacao.getMaterial());
                }
                movimentacao.setDataMovimentacao(new Date());
                movimentacaoDao.salvar(movimentacao);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public List<Movimentacao> listByCriterio(Movimentacao movimentacao) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            MovimentacaoDao movimentacaoDao = new MovimentacaoJDBC(connection);
            return movimentacaoDao.listar(movimentacao);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
