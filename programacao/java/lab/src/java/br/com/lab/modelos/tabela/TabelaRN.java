/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.tabela;

import br.com.lab.modelos.modulo.ModuloAtraso;
import java.util.List;
import br.com.lab.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fabio julio
 */
public class TabelaRN {

    public TabelaRN() {
        super();
    }
    public final static int TAB_AREA = 1;
    public final static int TAB_ATIVIDADE = 2;
    public final static int TAB_AVARIA = 3;
    public final static int TAB_CAUSA = 4;
    public final static int TAB_ESTACAO = 6;
    public final static int TAB_FECHAMENTO = 7;
    public final static int TAB_FINALIDADE = 8;
    public final static int TAB_INSTRUMENTO = 9;
    public final static int TAB_LIBERACAO = 10;
    public final static int TAB_LOCAL = 11;

    public final static int TAB_ATRASO_REPARACAO = 13;
    public final static int TAB_ATRASO_ATUACAO = 14;
    public final static int TAB_ATRASO_INICIO_ATUACAO = 15;
    public final static int TAB_ATRASO_TEMPO_REPARACAO = 16;
    public final static int TAB_ATUACAO = 17;

    public Tabela getTabela(String codigo, int tabela) {
        String sql = null;
        String nome = null;

        switch (tabela) {
            case TAB_AREA:
                sql = "SELECT *FROM AREA WHERE AREA_CODIGO = ?";
                nome = "AREA";
                break;
            case TAB_ATIVIDADE:
                sql = "SELECT *FROM ATIVIDADE WHERE ATIVIDADE_CODIGO = ?";
                nome = "ATIVIDADE";
                break;
            case TAB_AVARIA:
                sql = "SELECT *FROM AVARIA WHERE AVARIA_CODIGO = ?";
                nome = "AVARIA";
                break;
            case TAB_CAUSA:
                sql = "SELECT *FROM CAUSA WHERE CAUSA_CODIGO = ?";
                nome = "CAUSA";
                break;

            case TAB_ESTACAO:
                sql = "SELECT *FROM ESTACAO WHERE ESTACAO_CODIGO = ?";
                nome = "ESTACAO";
                break;
            case TAB_FECHAMENTO:
                sql = "SELECT *FROM FECHAMENTO WHERE FECHAMENTO_CODIGO = ?";
                nome = "FECHAMENTO";
                break;
            case TAB_LIBERACAO:
                sql = "SELECT *FROM LIBERACAO WHERE LIBERACAO_CODIGO = ?";
                nome = "LIBERACAO";
                break;
            case TAB_INSTRUMENTO:
                sql = "SELECT *FROM INSTRUMENTO WHERE INSTRUMENTO_CODIGO = ?";
                nome = "INSTRUMENTO";
                break;
            case TAB_LOCAL:
                sql = "SELECT *FROM LOCAL WHERE LOCAL_CODIGO = ?";
                nome = "LOCAL";
                break;

            case TAB_ATRASO_ATUACAO:
                sql = "SELECT *FROM ATRASO WHERE TIPO = 'A' AND  CODIGO = ?";
                break;
            case TAB_ATRASO_INICIO_ATUACAO:
                sql = "SELECT *FROM ATRASO WHERE TIPO = 'I' AND CODIGO = ?";
                break;
            case TAB_ATRASO_REPARACAO:
                sql = "SELECT *FROM ATRASO WHERE TIPO = 'R' AND CODIGO = ?";
                break;
            case TAB_ATRASO_TEMPO_REPARACAO:
                sql = "SELECT *FROM ATRASO WHERE TIPO = 'T' AND CODIGO = ?";
                break;
            case TAB_ATUACAO:
                sql = "SELECT *FROM ATUACAO WHERE ATUACAO_CODIGO = ?";
                nome = "ATUACAO";
                break;
            case TAB_FINALIDADE:
                sql = "select *from finalidade where (select substring(finalidade.FINALIDADE_CODIGO, 8, 12)) = '0000' and codigo=?";
                nome = "FINALIDADE";
                break;
        }
        try (Connection connection = new ConnectionFactory().getConnection()) {
            TabelaDao tabelaDao = new TabelaJDBC(connection);
            return tabelaDao.getTabela(codigo, sql, nome);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Tabela> ListarTabela(int tabela) {
        String sql = null;
        String nome = null;
        switch (tabela) {
            case TAB_AREA:
                sql = "SELECT *FROM AREA";
                nome = "AREA";
                break;
            case TAB_ATIVIDADE:
                sql = "SELECT *FROM ATIVIDADE";
                nome = "ATIVIDADE";
                break;
            case TAB_AVARIA:
                sql = "SELECT *FROM AVARIA";
                nome = "AVARIA";
                break;
            case TAB_CAUSA:
                sql = "SELECT *FROM CAUSA";
                nome = "CAUSA";
                break;

            case TAB_ESTACAO:
                sql = "SELECT *FROM ESTACAO";
                nome = "ESTACAO";
                break;
            case TAB_FECHAMENTO:
                sql = "SELECT *FROM FECHAMENTO";
                nome = "FECHAMENTO";
                break;
            case TAB_LIBERACAO:
                sql = "SELECT *FROM LIBERACAO";
                nome = "LIBERACAO";
                break;
            case TAB_FINALIDADE:
                sql = "select *from finalidade where (select substring(finalidade.FINALIDADE_CODIGO, 8, 12)) = '0000' order by finalidade_codigo ";
                nome = "FINALIDADE";
                break;
            case TAB_LOCAL:
                sql = "SELECT *FROM LOCAL";
                nome = "LOCAL";
                break;

            case TAB_ATRASO_ATUACAO:
                sql = "SELECT *FROM ATRASO WHERE TIPO = 'A'";
                nome = "ATRASO";
                break;
            case TAB_ATRASO_INICIO_ATUACAO:
                sql = "SELECT *FROM ATRASO WHERE TIPO = 'I'";
                nome = "ATRASO";
                break;
            case TAB_ATRASO_REPARACAO:
                sql = "SELECT *FROM ATRASO WHERE TIPO = 'R'";
                nome = "ATRASO";
                break;
            case TAB_ATRASO_TEMPO_REPARACAO:
                sql = "SELECT *FROM ATRASO WHERE TIPO = 'T'";
                nome = "ATRASO";
                break;
            case TAB_ATUACAO:
                sql = "SELECT *FROM ATUACAO";
                nome = "ATUACAO";
                break;
            case TAB_INSTRUMENTO:
                sql = "SELECT *FROM INSTRUMENTO";
                nome = "INSTRUMENTO";
                break;
        }

        try (Connection connection = new ConnectionFactory().getConnection()) {
            TabelaDao tabelaDao = new TabelaJDBC(connection);
            return tabelaDao.listar(sql, nome);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Integer returnId(String value) {

        if (value.equals("TAB_AREA")) {
            return TAB_AREA;
        }
        if (value.equals("TAB_ATIVIDADE")) {
            return TAB_ATIVIDADE;
        }
        if (value.equals("TAB_AVARIA")) {
            return TAB_AVARIA;
        }
        if (value.equals("TAB_CAUSA")) {
            return TAB_CAUSA;
        }

        if (value.equals("TAB_ESTACAO")) {
            return TAB_ESTACAO;
        }
        if (value.equals("TAB_FECHAMENTO")) {
            return TAB_FECHAMENTO;
        }
        if (value.equals("TAB_FINALIDADE")) {
            return TAB_FINALIDADE;
        }
        if (value.equals("TAB_INSTRUMENTO")) {
            return TAB_INSTRUMENTO;
        }
        if (value.equals("TAB_LIBERACAO")) {
            return TAB_LIBERACAO;
        }
        if (value.equals("TAB_LOCAL")) {
            return TAB_LOCAL;
        }

        if (value.equals("TAB_ATRASO_REPARACAO")) {
            return TAB_ATRASO_REPARACAO;
        }
        if (value.equals("TAB_ATRASO_ATUACAO")) {
            return TAB_ATRASO_ATUACAO;
        }
        if (value.equals("TAB_ATRASO_INICIO_ATUACAO")) {
            return TAB_ATRASO_INICIO_ATUACAO;
        }
        if (value.equals("TAB_ATRASO_TEMPO_REPARACAO")) {
            return TAB_ATRASO_TEMPO_REPARACAO;
        }
        if (value.equals("TAB_ATUACAO")) {
            return TAB_ATUACAO;
        } else {
            return 0;
        }
    }

    public List<Complexidade> listarComplexidade() {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            TabelaDao tabelaDao = new TabelaJDBC(connection);
            return tabelaDao.listar();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String getFinalidade(String codigo) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            TabelaDao tabelaDao = new TabelaJDBC(connection);
            return tabelaDao.getFinalidade(codigo);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ModuloAtraso getAtraso(String codigo, String tipo) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            TabelaDao tabelaDao = new TabelaJDBC(connection);
            return tabelaDao.getAtraso(codigo, tipo);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
