/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.tabela;

import br.com.lab.modelos.modulo.ModuloAtraso;
import java.util.List;

/**
 *
 * @author fabio julio
 */
interface TabelaDao {

    public Tabela getTabela(String codigo, String sql, String tabela);

    public String getFinalidade(String codigo);

    public ModuloAtraso getAtraso(String codigo, String tipo);

    public List<Complexidade> listar();

    public List<Tabela> listar(String sql, String tabela);

}
