/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.osm;

import java.util.List;

/**
 *
 * @author fabio julio
 */
interface OrdemServicoDao {

    String carregar();

    void salvar(OrdemServico ordemServico);

    void atualizar(OrdemServico ordemServico);

    public OrdemServico buscarPorOSM(String numero);
    
    /*
     void atualizarTemporario(String status, String sistema_fk, Date prazo, String OBS, Boolean Imprimir);
     */

    List<OrdemServico> listar(String query);

}
