/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.web;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.lab.modelos.tabela.TabelaRN;
import br.com.lab.modelos.tabela.Tabela;
import java.io.Serializable;

/**
 *
 * @author 1366
 */
@ManagedBean
@SessionScoped
public class TabelaBean implements Serializable{

    private List<Tabela> tabelas = new ArrayList<>();
    private List<Tabela> tabelasFiltrada;
    private int tabelado;

    public TabelaBean() {

    }

    public void consultarTabela() {
        this.tabelas.clear();
        this.tabelasFiltrada = null;
        this.tabelas = new TabelaRN().ListarTabela(tabelado);
    }

    public List<Tabela> getTabelasFiltrada() {
        return tabelasFiltrada;
    }

    public void setTabelasFiltrada(List<Tabela> tabelasFiltrada) {
        this.tabelasFiltrada = tabelasFiltrada;
    }

    public List<Tabela> getTabelas() {
        return tabelas;
    }

    public int getTabelado() {
        return tabelado;
    }

    public void setTabelado(int tabelado) {
        this.tabelado = tabelado;
    }
}
