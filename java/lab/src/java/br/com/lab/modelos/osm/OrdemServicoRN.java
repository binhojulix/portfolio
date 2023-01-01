/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.osm;

import br.com.lab.modelos.usuario.UsuarioRN;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import br.com.lab.modelos.usuario.Usuario;
import br.com.lab.modelos.modulo.ModuloRN;
import br.com.lab.util.ConnectionFactory;
import br.com.lab.util.UsuarioUtil;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fabio julio
 */
public class OrdemServicoRN {

    public OrdemServicoRN() {
        super();
    }

    public void salvar(OrdemServico ordemServico) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            try {
                OrdemServicoDao ordemServicoDao = new OrdemServicoJDBC(connection);
                if (ordemServico.getStatus().equals("Liberada") || ordemServico.getStatus().equals("Aberta")
                        || ordemServico.getStatus().equals("Fechada")) {
                    ordemServicoDao.atualizar(ordemServico);
                } else {
                    ordemServico.setNumero(ordemServicoDao.carregar());
                    Date date = new Date();
                    ordemServico.setDataAbertura(date);
                    ordemServico.setHoraAbertura(date);
                    ordemServico.setSistema(new UsuarioUtil().getUsuario());
                    ordemServicoDao.salvar(ordemServico);
                    connection.commit();
                }
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<OrdemServico> listarPesquisas(String status) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            OrdemServicoDao ordemServicoDao = new OrdemServicoJDBC(connection);
            String query = montarQuery(status);
            List<OrdemServico> listOrdens = ordemServicoDao.listar(query);
            return listOrdens;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public OrdemServico getOrdem(String ordem) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            OrdemServicoDao ordemServicoDao = new OrdemServicoJDBC(connection);
            OrdemServico ordemServico = ordemServicoDao.buscarPorOSM(ordem);

            if (ordemServico != null) {
                ModuloRN moduloRN = new ModuloRN();
                Integer qtdModulo = moduloRN.getNumeroModulo(ordemServico.getNumero());
                ordemServico.setQtdModulo(qtdModulo);

                UsuarioRN funcionarioRN = new UsuarioRN();

                Integer equipRestante = moduloRN.calcularEquipamentoRestante(ordemServico.getNumero());
                ordemServico.setEquipamentoRestante(ordemServico.getEquipamento().getQuantidade() - equipRestante);

                Usuario solicitante = funcionarioRN.buscarPorMatricula(ordemServico.getSolicitante().getMatricula());
                Usuario responsavel = funcionarioRN.buscarPorMatricula(ordemServico.getResponsavel().getMatricula());
                Usuario sistema = funcionarioRN.buscarPorMatricula(ordemServico.getSistema().getMatricula());

                ordemServico.setSolicitante(solicitante);
                ordemServico.setResponsavel(responsavel);
                ordemServico.setSistema(sistema);

                if (ordemServico.getRecebedor().getMatricula() != null && ordemServico.getEntregador().getMatricula() != null) {
                    ordemServico.setRecebedor(funcionarioRN.buscarPorMatricula(ordemServico.getRecebedor().getMatricula()));
                    ordemServico.setEntregador(funcionarioRN.buscarPorMatricula(ordemServico.getEntregador().getMatricula()));
                }

                ordemServico.setPrazo(calcularData(ordemServico.getDataAbertura(),
                        ordemServico.getComplexidade().getTempoMaximoReparacao()));

                if (ordemServico.getDataFechamento() == null) {
                    ordemServico.setStatus("Aberta");
                } else if (ordemServico.getDataEntrega() != null) {
                    ordemServico.setStatus("Fechada");
                } else {
                    ordemServico.setStatus("Liberada");
                }

                if (ordemServico.getEquipamento().getCodigoEquipamento().equalsIgnoreCase("BLO1133")) {
                    ordemServico.setObs("HORA EXTRA");
                } else if (ordemServico.getEquipamento().getCodigoEquipamento().equals("MAC1023")
                        || ordemServico.getEquipamento().getCodigoEquipamento().equals("MAC1024")
                        || ordemServico.getEquipamento().getCodigoEquipamento().equals("LOC1105")
                        || ordemServico.getEquipamento().getCodigoEquipamento().equals("LOC1106")) {
                    ordemServico.setObs("PASTA ATC");

                }
            }
            return ordemServico;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String montarQuery(String status) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *FROM OSM INNER JOIN SOLICITANTE ON OSM.RESPONSAVEL_FK = SOLICITANTE.MATRICULA ");

        switch (status) {
            case "Fechadas":
                sql.append("WHERE (LIBERACAO_FK = '0' OR LIBERACAO_FK = '1') AND DATA_ENTREGA IS NOT NULL ");
                break;
            case "Liberadas":
                sql.append("WHERE (LIBERACAO_FK ='0' OR LIBERACAO_FK = '1') AND DATA_ENTREGA IS NULL ");
                break;
            case "Abertas":
                sql.append("WHERE LIBERACAO_FK = '2'");
                break;
            case "Imprimir":
                sql.append("WHERE IMPRIMIR = TRUE ");
                break;
        }

        sql.append("ORDER BY OSM.CODIGO DESC");
        return sql.toString();
    }

    private Date calcularData(Date data, Integer calcular) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, calcular);
        return calendar.getTime();
    }

}
