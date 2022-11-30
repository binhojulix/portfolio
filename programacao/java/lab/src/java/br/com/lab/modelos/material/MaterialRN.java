/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.material;

import java.util.List;
import br.com.lab.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fabio julio
 */
public class MaterialRN {

    public MaterialRN() {
        super();
    }

    //se o codigo ja existir update se não save
    public void salvar(Material material) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            try {
                MaterialDao materialDao = new MaterialJDBC(connection);
                if (getMaterialPorCodigo(material.getCodigoMaterial()) == null) {
                    materialDao.salvar(material);
                } else {
                    materialDao.atualizar(material);
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //verificar se o material existe
    public Material getMaterialPorCodigo(String codigoMaterial) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            MaterialDao materialDao = new MaterialJDBC(connection);
            return materialDao.bucarPorCodigoMaterial(codigoMaterial);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //lista do material autocomplete
    public List<Material> listarMateriais(String criterio) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            MaterialDao materialDao = new MaterialJDBC(connection);
            List<Material> materiais = materialDao.listar(criterio);
            return materiais;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    //lista do material pesquisar
    public List<Material> listarMateriais(String criterio, String coluna) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            MaterialDao materialDao = new MaterialJDBC(connection);
            List<Material> materiais = materialDao.listar(criterio, coluna);
            return materiais;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
