/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.movimentacao;

import java.util.List;

/**
 *
 * @author fabio julio
 */
interface MovimentacaoDao {

    Integer carregar();

    void salvar(Movimentacao movimentacao);

    List<Movimentacao> listar(Movimentacao movimentacao);

}
