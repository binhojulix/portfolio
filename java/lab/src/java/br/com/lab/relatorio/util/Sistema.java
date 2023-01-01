/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lab.relatorio.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabiolu
 */
public class Sistema {
    
    private String sistema;
    private int total;
    private final List<Subsistema> subsistemas;
    
    public Sistema(){
        this.subsistemas = new ArrayList<>();
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Subsistema> getSubsistemas() {
        return subsistemas;
    }
    
    
    public void adicionar(Subsistema subsistema){
        this.subsistemas.add(subsistema);
    }
    
}
