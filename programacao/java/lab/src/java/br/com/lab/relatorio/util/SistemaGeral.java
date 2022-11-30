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
public class SistemaGeral {
    
    private String sistemaGeral;
    private int total;
    private final List<Sistema> sistemas;
    
    public SistemaGeral(){
        this.sistemas = new ArrayList<>();
    }

    public String getSistemaGeral() {
        return sistemaGeral;
    }

    public void setSistemaGeral(String sistemaGeral) {
        this.sistemaGeral = sistemaGeral;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Sistema> getSistemas() {
        return sistemas;
    }
    public void adicionar(Sistema sistema){
        this.sistemas.add(sistema);
    }
}
