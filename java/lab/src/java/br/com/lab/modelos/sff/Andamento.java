/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.sff;

import java.util.Date;

/**
 *
 * @author fabiolu
 */
public class Andamento {

    private long id;
    private String descricaoAndamento;
    private Date data;
    private long sff;

    public Andamento() {
    }

    public Andamento(long id, String andamento, Date data, long sff) {
        this.id = id;
        this.descricaoAndamento = andamento;
        this.data = data;
        this.sff = sff;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricaoAndamento() {
        return descricaoAndamento;
    }

    public void setDescricaoAndamento(String andamento) {
        this.descricaoAndamento = andamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getSff() {
        return sff;
    }

    public void setSff(long sff) {
        this.sff = sff;
    }

}
