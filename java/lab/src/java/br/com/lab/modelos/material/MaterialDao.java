/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.material;

import java.util.List;

/**
 *
 * @author fabio julio
 */
interface MaterialDao {

    void salvar(Material material);

    void atualizar(Material material);

    Material bucarPorCodigoMaterial(String criterio);

    List<Material> listar(String criterio);

    List<Material> listar(String criterio, String coluna);

}
