/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.tabela;

import java.util.List;

/**
 *
 * @author fabiolu
 */
public class teste {

    public static void main(String args[]) {
        TabelaRN tabelaRN = new TabelaRN();
        List<Tabela> tabelas = tabelaRN.ListarTabela(TabelaRN.TAB_FINALIDADE);
        for(Tabela t:tabelas){
            System.out.println(t.getDescricao());
        }
    }
}
