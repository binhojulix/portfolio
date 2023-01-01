/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.movimentacao;

import br.com.lab.modelos.material.Material;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.lab.modelos.tabela.Tabela;
import br.com.lab.modelos.usuario.Usuario;

/**
 *
 * @author fabio julio
 */
class MovimentacaoJDBC implements MovimentacaoDao {

    private Connection connection = null;

    public MovimentacaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvar(Movimentacao movimentacao) {
        String sql = "INSERT INTO MOVIMENTACAO (MATERIAL_FK, QUANTIDADE, SOLICITANTE_FK, DATA_MOVIMENTACAO, DOCUMENTO, TIPO) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, movimentacao.getMaterial().getCodigoMaterial());
            stmt.setDouble(2, movimentacao.getQuantidade());
            stmt.setString(3, movimentacao.getRequisitante().getMatricula());
            stmt.setDate(4, new Date(movimentacao.getDataMovimentacao().getTime()));
            stmt.setString(5, movimentacao.getDocumento());
            stmt.setString(6, movimentacao.getTipo());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Movimentacao> listar(Movimentacao mov) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT *FROM((MOVIMENTACAO) ");
            sql.append("INNER JOIN SOLICITANTE ON MOVIMENTACAO.SOLICITANTE_FK = SOLICITANTE.MATRICULA) ");
            sql.append("INNER JOIN MATERIAL ON MOVIMENTACAO.MATERIAL_FK = MATERIAL.CODIGO_MATERIAL ");
            sql.append("INNER JOIN AREA ON SOLICITANTE.AREA = AREA.AREA_CODIGO ");
            sql.append("WHERE MOVIMENTACAO.MATERIAL_FK = ? AND TIPO = ? ");
            if (mov.getDataMovimentacao() != null) {
                sql.append("AND MOVIMENTACAO.DATA_MOVIMENTACAO BETWEEN ? AND ? ");
            }
            sql.append("ORDER BY MOVIMENTACAO.DATA_MOVIMENTACAO DESC");
            List<Movimentacao> movimentacoes = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement(sql.toString());
            stmt.setString(1, mov.getMaterial().getCodigoMaterial());
            stmt.setString(2, mov.getTipo());
            if (mov.getDataMovimentacao() != null) {
                stmt.setDate(3, new Date(mov.getDataMovimentacao().getTime()));
                stmt.setDate(4, new Date(new java.util.Date().getTime()));
            }
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Movimentacao movimentacao = new Movimentacao();
                Usuario usuario = new Usuario();
                Tabela area = new Tabela();
                Material material = new Material();

                movimentacao.setNumero(resultado.getInt("NUMERO"));
                movimentacao.setDocumento(resultado.getString("DOCUMENTO"));
                movimentacao.setDataMovimentacao(resultado.getDate("DATA_MOVIMENTACAO"));
                movimentacao.setTipo(resultado.getString("TIPO"));
                movimentacao.setQuantidade(resultado.getDouble("QUANTIDADE"));

                usuario.setMatricula(resultado.getString("MATRICULA"));
                usuario.setNome(resultado.getString("NOME"));
                usuario.setTelefone(resultado.getString("TELEFONE"));
                usuario.setCargo(resultado.getString("CARGO"));
                usuario.setManutenedor(resultado.getBoolean("MANTENEDOR"));
                usuario.setLogin(resultado.getString("LOGIN"));
                area.setCodigo(resultado.getString("AREA_CODIGO"));
                area.setCodigo(resultado.getString("AREA_DESCRICAO"));
                usuario.setArea(area);
                movimentacao.setRequisitante(usuario);

                material.setCodigoCPTM(resultado.getString("CODIGO_CPTM"));
                material.setCodigoMaterial(resultado.getString("CODIGO_MATERIAL"));
                material.setDescricao(resultado.getString("DESCRICAO"));
                material.setGaveta(resultado.getString("GAVETA"));
                material.setEstoque(resultado.getDouble("ESTOQUE"));
                material.setSistema(resultado.getString("SISTEMA"));
                material.setUnidade(resultado.getString("UNIDADE"));
                material.setSetor(resultado.getString("SETOR"));
                movimentacao.setMaterial(material);

                movimentacoes.add(movimentacao);
            }
            resultado.close();
            stmt.close();
            return movimentacoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer carregar() {
        int numero = 0;
        try {
            String pesquisar = "SELECT MAX(NUMERO)AS M FROM MOVIMENTACAO";
            PreparedStatement stmt = this.connection.prepareStatement(pesquisar);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                numero = resultado.getInt("M");
            }
            resultado.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numero += 1;
    }
}
