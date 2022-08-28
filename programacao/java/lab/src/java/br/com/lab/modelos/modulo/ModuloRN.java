/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.modulo;

import br.com.lab.modelos.osm.OrdemServicoRN;
import java.util.Date;
import java.util.List;
import br.com.lab.modelos.movimentacao.MovimentacaoRN;
import br.com.lab.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fabio julio
 */
public class ModuloRN {

    public ModuloRN() {
        super();
    }

    public int getNumeroModulo(String osm) {
        int numero = 0;
        try (Connection connection = new ConnectionFactory().getConnection()) {
            ModuloDao moduloDao = new ModuloJDBC(connection);
            numero = moduloDao.carregarModulo(osm);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return numero;
    }

    public int carregar() {
        int numero = 0;
        try (Connection connection = new ConnectionFactory().getConnection()) {
            ModuloDao moduloDao = new ModuloJDBC(connection);
            numero = moduloDao.carregarNumero();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return numero;
    }

    //seta observacao no protocolo de entrega
    public String getModuloObservacao(String osm) {
        try (Connection connection = new ConnectionFactory().getConnection()) {

            ModuloDao moduloDao = new ModuloJDBC(connection);
            int carregarModulo = moduloDao.carregarModulo(osm) - 1;
            String moduloObservacao = moduloDao.getLastObservacao(carregarModulo, osm);
            return moduloObservacao;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void save(Modulo modulo) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            try {
                ModuloDao moduloDao = new ModuloJDBC(connection);
                Date data = new Date();
                modulo.setHoraAbertura(data);
                modulo.setCodigo(moduloDao.carregarNumero());

                moduloDao.saveModulo(modulo);
                saveInstrumentos(modulo, connection);
                saveFinalidade(modulo, connection);
                saveUsuarios(modulo, connection);
                saveMateriais(modulo, connection);
                saveAtrasos(modulo, connection);

                // se for liberada
                if (modulo.getLiberacao().getCodigo().equals("0") || modulo.getLiberacao().getCodigo().equals("1")) {
                    modulo.getOrdemServico().setDataFechamento(data);
                    modulo.getOrdemServico().setLiberacao(modulo.getLiberacao());
                } else {
                    modulo.getOrdemServico().setImprimir(true);
                }
                modulo.getOrdemServico().setFechamento(modulo.getFechamento());
                OrdemServicoRN ordemServicoRN = new OrdemServicoRN();
                ordemServicoRN.salvar(modulo.getOrdemServico());
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public Integer calcularEquipamentoRestante(String osm) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            ModuloDao moduloDao = new ModuloJDBC(connection);
            return moduloDao.quantidadeEquipamento(osm);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Modulo> listarModulos(String osm) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            ModuloDao moduloDao = new ModuloJDBC(connection);
            List<Modulo> modulos = moduloDao.listarModulos(osm);
            for (Modulo m : modulos) {
                Integer codigoModulo = m.getCodigo();
                m.setFinalidades(moduloDao.listFinalidade(codigoModulo));
                m.setInstrumentos(moduloDao.listInstrumentos(codigoModulo));
                m.setAtrasos(moduloDao.listAtraso(codigoModulo));
                m.setMovimentacoes(moduloDao.listMovimentacao(codigoModulo));
                m.setUsuarios(moduloDao.listUsuarios(codigoModulo));
            }
            return modulos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void saveMateriais(Modulo modulo, Connection connection) {
        ModuloDao moduloDao = new ModuloJDBC(connection);
        Date data = new Date();
        if (modulo.getMovimentacoes().size() > 0) {
            MovimentacaoRN movimentacaoRN = new MovimentacaoRN();
            for (ModuloMovimentacao m : modulo.getMovimentacoes()) {
                m.setModulo(modulo.getCodigo());

                m.getMovimentacao().setDocumento("OS-" + modulo.getOrdemServico().getNumero());
                m.getMovimentacao().setNumero(movimentacaoRN.carregar());
                m.getMovimentacao().setRequisitante(modulo.getFuncionario());
                m.getMovimentacao().setDataMovimentacao(data);

                movimentacaoRN.salvar(m.getMovimentacao());
                moduloDao.saveMovimentacao(m);
            }
        }
    }

    private void saveInstrumentos(Modulo modulo, Connection connection) {
        ModuloDao moduloDao = new ModuloJDBC(connection);
        if (modulo.getInstrumentos().size() > 0) {
            for (ModuloInstrumento m : modulo.getInstrumentos()) {
                m.setModulo(modulo.getCodigo());
                moduloDao.saveInstrumento(m);
            }
        }
    }

    private void saveUsuarios(Modulo modulo, Connection connection) {
        ModuloDao moduloDao = new ModuloJDBC(connection);
        if (modulo.getUsuarios().size() > 0) {
            for (ModuloUsuario m : modulo.getUsuarios()) {
                m.setModulo(modulo.getCodigo());
                moduloDao.saveFuncionario(m);
            }
        }
    }

    private void saveAtrasos(Modulo modulo, Connection connection) {
        ModuloDao moduloDao = new ModuloJDBC(connection);
        if (modulo.getAtrasos().size() > 0) {
            for (ModuloAtraso m : modulo.getAtrasos()) {
                m.setModulo(modulo.getCodigo());
                moduloDao.saveAtraso(m);
            }
        }
    }

    //verifica se a lista esta vazia 
    //se nao estiver vazia inseri no bd
    private void saveFinalidade(Modulo modulo, Connection connection) {
        ModuloDao moduloDao = new ModuloJDBC(connection);
        if (modulo.getFinalidades().size() > 0) {
            for (ModuloFinalidade m : modulo.getFinalidades()) {
                m.setModulo(modulo.getCodigo());
                moduloDao.saveFinalidade(m);
            }
        }
    }

}
