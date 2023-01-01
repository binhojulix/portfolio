/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.sff;

import br.com.lab.modelos.osm.OrdemServico;
import java.util.List;
import br.com.lab.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author fabiolu
 */
public class SffRN {

    public SffRN() {
        super();
    }

    public void salvarSFF(Sff sff) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            SffDao sffDao = new SffJDBC(conn);

            boolean exist = sffDao.exist(sff.getId());

            try {
                if (exist && sff.getId() != 0) {

                        sffDao.editar(sff);

                } else {
                    sff.setUltimoAndamento("Novo Processo");
                    sffDao.salvarSFF(sff);
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
 

    public void salvarAndamento(Sff sff) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            SffDao sffDao = new SffJDBC(conn);
            try {
                
                
                Sff ultimaSff = sffDao.buscar(sff.getId());
                
                if(!sff.getUltimoAndamento().equals(ultimaSff.getUltimoAndamento())){
                    
                    Andamento andamento = new Andamento();
                    andamento.setData(ultimaSff.getDataUltimoAndamento());
                    andamento.setDescricaoAndamento(ultimaSff.getUltimoAndamento());
                    andamento.setSff(ultimaSff.getId());
                    sffDao.salvar(andamento);

                    Date data = new Date();
                    sff.setDataUltimoAndamento(data);
                    sffDao.atualizarStatus(sff);
                }
                
                
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void deletar(long id) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            SffDao sffDao = new SffJDBC(conn);
            try {
                sffDao.deletar(id);
                sffDao.deletarAndamento(id);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Sff> listar() {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            SffDao sffDao = new SffJDBC(conn);
            List<Sff> lista = sffDao.listar();
            return lista;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Andamento> listarAndamentos(Long sff) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            SffDao dao = new SffJDBC(conn);
            return dao.listarAndamentos(sff);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public OrdemServico buscarOsm(String numero) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            SffDao dao = new SffJDBC(conn);
            return dao.buscarOSM(numero);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Sff buscarSff(long id) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            SffDao dao = new SffJDBC(conn);
            return dao.buscar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
