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
public class Subsistema {

    private String subsistema;
    private int total;
    private final List<Equipamento> equipamentos;

    public Subsistema() {
        this.equipamentos = new ArrayList<>();
    }

    public String getSubsistema() {
        return subsistema;
    }

    public void setSubsistema(String subsistema) {
        this.subsistema = subsistema;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Equipamento> getEquipamentos() {
        return this.equipamentos;
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        this.equipamentos.add(equipamento);
    }

}
