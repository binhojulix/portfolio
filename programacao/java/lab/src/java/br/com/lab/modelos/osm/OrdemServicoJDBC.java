/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.osm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import br.com.lab.modelos.usuario.Usuario;
import br.com.lab.modelos.tabela.Tabela;

/**
 *
 * @author fabiolu
 */
class OrdemServicoJDBC implements OrdemServicoDao {

    private Connection connection = null;

    public OrdemServicoJDBC(Connection conn) {
        connection = conn;
    }

    @Override
    public String carregar() {
        Integer temp = 0;
        try {
            String pesquisar = "SELECT MAX(CODIGO)AS M FROM OSM";
            PreparedStatement stmt = connection.prepareStatement(pesquisar);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                temp = resultado.getInt("M");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        temp = temp + 1;
        String os = temp.toString();
        Integer StringSize = os.length();
        Integer resultado = 0;
        for (int i = 2; i < os.length() + 2; i++) {
            Integer a = Integer.parseInt(os.charAt(StringSize - 1) + "");
            resultado += a * i;
            StringSize--;
        }
        resultado = (resultado % 10);

        return os + "-" + resultado.toString();
    }

    @Override
    public void salvar(OrdemServico ordemServico) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO OSM(NUMERO, DATA_ABERTURA, HORA_ABERTURA, ATIVIDADE_FK, ");
            sql.append("AVARIA_FK, SOLICITANTE_FK, POSICAO, LOCAL_FK, ESTACAO_FK, COMPLEXIDADE_FK, ");
            sql.append("QUANTIDADE, CODIGO_EQUIPAMENTO, DESCRICAO, SERIE, PATRIMONIO, PLAQUETA, ");
            sql.append("RESPONSAVEL_FK, NUMERO_FALHA, DATA_FALHA, SERVICO, LIBERACAO_FK, SISTEMA_FK, IMPRIMIR) ");
            sql.append("values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            PreparedStatement stmt = connection.prepareStatement(sql.toString());
            stmt.setString(1, ordemServico.getNumero());
            stmt.setDate(2, new java.sql.Date(ordemServico.getDataAbertura().getTime()));
            stmt.setTime(3, new java.sql.Time(ordemServico.getHoraAbertura().getTime()));
            stmt.setString(4, ordemServico.getAtividade().getCodigo());
            stmt.setString(5, ordemServico.getAvaria().getCodigo());
            stmt.setString(6, ordemServico.getSolicitante().getMatricula());
            stmt.setString(7, ordemServico.getPosicao());

            if (ordemServico.getLocal() == null) {
                stmt.setNull(8, Types.CHAR);
            } else {
                stmt.setString(8, ordemServico.getLocal().getCodigo());
            }

            if (ordemServico.getEstacao() == null) {
                stmt.setNull(9, Types.CHAR);
            } else {
                stmt.setString(9, ordemServico.getEstacao().getCodigo());
            }

            stmt.setString(10, ordemServico.getComplexidade().getCodigo());

            if (ordemServico.getEquipamento().getQuantidade() == null) {
                stmt.setInt(11, 0);
            } else {
                stmt.setInt(11, ordemServico.getEquipamento().getQuantidade());
            }
            stmt.setString(12, ordemServico.getEquipamento().getCodigoEquipamento());
            stmt.setString(13, ordemServico.getEquipamento().getDescricao());
            stmt.setString(14, ordemServico.getEquipamento().getSerie());
            stmt.setString(15, ordemServico.getEquipamento().getPatrimonio());
            stmt.setString(16, ordemServico.getEquipamento().getPlaca());
            stmt.setString(17, ordemServico.getResponsavel().getMatricula());
            stmt.setString(18, ordemServico.getNumeroFalha());

            if (ordemServico.getDataFalha() == null) {
                stmt.setNull(19, Types.DATE);
            } else {
                stmt.setDate(19, new java.sql.Date(ordemServico.getDataFalha().getTime()));
            }
            stmt.setString(20, ordemServico.getServico());
            stmt.setString(21, "2");
            stmt.setString(22, ordemServico.getSistema().getMatricula());
            stmt.setBoolean(23, true);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void atualizar(OrdemServico ordemServico) {
        try {

            String sql = "UPDATE OSM SET RESPONSAVEL_FK = ?, CODIGO_EQUIPAMENTO = ? , "
                    + "DESCRICAO = ?, SERIE = ?, PATRIMONIO = ?, PLAQUETA = ?, "
                    + "DATA_ENTREGA = ?, RECEBEDOR_FK = ?, ENTREGADOR_FK = ?, SERVICO =?,"
                    //status
                    + "FECHAMENTO_FK = ?, LIBERACAO_FK = ?, DATA_FECHAMENTO = ?,"
                    //nova
                    + "SOLICITANTE_FK = ?, NUMERO_FALHA = ?, DATA_FALHA = ?,"
                    + "POSICAO = ?, LOCAL_FK = ?, ESTACAO_FK = ?, COMPLEXIDADE_FK = ?, QUANTIDADE = ?, IMPRIMIR = ?"
                    + " WHERE NUMERO = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ordemServico.getResponsavel().getMatricula());
            stmt.setString(2, ordemServico.getEquipamento().getCodigoEquipamento());
            stmt.setString(3, ordemServico.getEquipamento().getDescricao());
            stmt.setString(4, ordemServico.getEquipamento().getSerie());
            stmt.setString(5, ordemServico.getEquipamento().getPatrimonio());
            stmt.setString(6, ordemServico.getEquipamento().getPlaca());
            if (ordemServico.getDataEntrega() == null) {
                stmt.setNull(7, Types.DATE);
            } else {
                stmt.setDate(7, new java.sql.Date(ordemServico.getDataEntrega().getTime()));
            }
            if (ordemServico.getRecebedor() == null) {
                stmt.setNull(8, Types.CHAR);
            } else {
                stmt.setString(8, ordemServico.getRecebedor().getMatricula());
            }

            stmt.setString(9, ordemServico.getEntregador().getMatricula());
            stmt.setString(10, ordemServico.getServico());
            stmt.setString(11, ordemServico.getFechamento().getCodigo());
            stmt.setString(12, ordemServico.getLiberacao().getCodigo());

            if (ordemServico.getDataFechamento() == null) {
                stmt.setNull(13, Types.DATE);
            } else {
                stmt.setDate(13, new java.sql.Date(ordemServico.getDataFechamento().getTime()));
            }
            stmt.setString(14, ordemServico.getSolicitante().getMatricula());
            stmt.setString(15, ordemServico.getNumeroFalha());
            if (ordemServico.getDataFalha() == null) {
                stmt.setNull(16, Types.DATE);
            } else {
                stmt.setDate(16, new java.sql.Date(ordemServico.getDataFalha().getTime()));
            }
            stmt.setString(17, ordemServico.getPosicao());

            if (ordemServico.getLocal() == null) {
                stmt.setNull(18, Types.CHAR);
            } else {
                stmt.setString(18, ordemServico.getLocal().getCodigo());
            }

            if (ordemServico.getEstacao() == null) {
                stmt.setNull(19, Types.CHAR);
            } else {
                stmt.setString(19, ordemServico.getEstacao().getCodigo());
            }
            stmt.setString(20, ordemServico.getComplexidade().getCodigo());
            if (ordemServico.getEquipamento().getQuantidade() == null) {
                stmt.setInt(21, 0);
            } else {
                stmt.setInt(21, ordemServico.getEquipamento().getQuantidade());
            }
            stmt.setBoolean(22, ordemServico.isImprimir());
            stmt.setString(23, ordemServico.getNumero());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrdemServico buscarPorOSM(String numero) {
        OrdemServico osm = null;
        try {
            String sql = "SELECT *FROM ((((((((OSM)"
                    + "LEFT JOIN ATIVIDADE ON OSM.ATIVIDADE_FK = ATIVIDADE.ATIVIDADE_CODIGO) "
                    + "LEFT JOIN AVARIA ON OSM.AVARIA_FK = AVARIA.AVARIA_CODIGO) "
                    + "LEFT JOIN LOCAL ON OSM.LOCAL_FK = LOCAL.LOCAL_CODIGO) "
                    + "LEFT JOIN ESTACAO ON OSM.ESTACAO_FK = ESTACAO.ESTACAO_CODIGO) "
                    + "INNER JOIN COMPLEXIDADE ON OSM.COMPLEXIDADE_FK = COMPLEXIDADE.CODIGO) "
                    + "LEFT JOIN FECHAMENTO ON OSM.FECHAMENTO_FK = FECHAMENTO.FECHAMENTO_CODIGO) "
                    + "LEFT JOIN LIBERACAO ON OSM.LIBERACAO_FK = LIBERACAO.LIBERACAO_CODIGO) WHERE OSM.NUMERO = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, numero);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                osm = new OrdemServico();
                Usuario recebedor = new Usuario();
                Usuario solicitante = new Usuario();
                Tabela local = new Tabela();
                Tabela estacao = new Tabela();
                osm.setNumero(resultado.getString("NUMERO"));
                osm.setDataAbertura(resultado.getDate("DATA_ABERTURA"));
                osm.setHoraAbertura(resultado.getTime("HORA_ABERTURA"));
                osm.setPosicao(resultado.getString("POSICAO"));

                solicitante.setMatricula(resultado.getString("SOLICITANTE_FK"));
                osm.setSolicitante(solicitante);

                osm.getEquipamento().setQuantidade(resultado.getInt("QUANTIDADE"));
                osm.getEquipamento().setCodigoEquipamento(resultado.getString("CODIGO_EQUIPAMENTO"));
                osm.getEquipamento().setDescricao(resultado.getString("DESCRICAO"));
                osm.getEquipamento().setPatrimonio(resultado.getString("PATRIMONIO"));
                osm.getEquipamento().setPlaca(resultado.getString("PLAQUETA"));
                osm.getEquipamento().setSerie(resultado.getString("SERIE"));

                osm.getAtividade().setCodigo(resultado.getString("ATIVIDADE_CODIGO"));
                osm.getAtividade().setDescricao(resultado.getString("ATIVIDADE_DESCRICAO"));

                osm.getAvaria().setCodigo(resultado.getString("AVARIA_CODIGO"));
                osm.getAvaria().setDescricao(resultado.getString("AVARIA_DESCRICAO"));

                local.setCodigo(resultado.getString("LOCAL_CODIGO"));
                local.setDescricao(resultado.getString("LOCAL_DESCRICAO"));

                estacao.setCodigo(resultado.getString("ESTACAO_CODIGO"));
                estacao.setDescricao(resultado.getString("ESTACAO_DESCRICAO"));

                osm.setLocal(local);
                osm.setEstacao(estacao);

                osm.setNumeroFalha(resultado.getString("NUMERO_FALHA"));
                osm.setDataFalha(resultado.getDate("DATA_FALHA"));
                osm.getComplexidade().setCodigo(resultado.getString("COMPLEXIDADE_FK"));
                osm.getComplexidade().setFator(resultado.getString("FATOR"));
                osm.getComplexidade().setNivel(resultado.getString("NIVEL"));
                osm.getComplexidade().setTempoMaximoReparacao(resultado.getInt("MAX_REPARACAO-DIA"));
                osm.getFechamento().setCodigo(resultado.getString("FECHAMENTO_CODIGO"));
                osm.getFechamento().setDescricao(resultado.getString("FECHAMENTO_DESCRICAO"));
                osm.getLiberacao().setCodigo(resultado.getString("LIBERACAO_CODIGO"));
                osm.getLiberacao().setDescricao(resultado.getString("LIBERACAO_DESCRICAO"));
                osm.setDataFechamento(resultado.getDate("DATA_FECHAMENTO"));
                osm.getResponsavel().setMatricula(resultado.getString("RESPONSAVEL_FK"));
                osm.getEntregador().setMatricula(resultado.getString("ENTREGADOR_FK"));

                recebedor.setMatricula(resultado.getString("RECEBEDOR_FK"));
                osm.setRecebedor(recebedor);

                osm.getSistema().setMatricula(resultado.getString("SISTEMA_FK"));

                osm.setDataEntrega(resultado.getDate("DATA_ENTREGA"));
                osm.setServico(resultado.getString("SERVICO"));

            }
            resultado.close();
            stmt.close();
            return osm;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrdemServico> listar(String query) {
        try {
            List<OrdemServico> ordens = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                OrdemServico osm = new OrdemServico();
                Tabela local = new Tabela();
                Tabela estacao = new Tabela();
                osm.setNumero(resultado.getString("NUMERO"));
                osm.setDataAbertura(resultado.getDate("DATA_ABERTURA"));
                osm.getEquipamento().setCodigoEquipamento(resultado.getString("CODIGO_EQUIPAMENTO"));
                osm.getEquipamento().setDescricao(resultado.getString("DESCRICAO"));
                osm.getEquipamento().setPatrimonio(resultado.getString("PATRIMONIO"));
                osm.getEquipamento().setPlaca(resultado.getString("PLAQUETA"));
                osm.getEquipamento().setSerie(resultado.getString("SERIE"));
                osm.getResponsavel().setMatricula(resultado.getString("MATRICULA"));
                osm.getResponsavel().setNome(resultado.getString("NOME"));
                local.setCodigo(resultado.getString("LOCAL_FK"));
                estacao.setCodigo(resultado.getString("ESTACAO_FK"));
                osm.setEstacao(estacao);
                osm.setLocal(local);
                ordens.add(osm);
            }
            resultado.close();
            stmt.close();
            return ordens;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
