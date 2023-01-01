/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.sff;

import br.com.lab.modelos.osm.OrdemServico;
import br.com.lab.modelos.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author fabiolu
 */
public class Sff {

    private long id;
    private String sff;
    private Usuario solicitante;
    private String ultimoAndamento;
    private Date dataUltimoAndamento;
    private String material;
    private Integer qtdMaterial;
    
    private OrdemServico osm;
    private List<Andamento> andamentos;

    public Sff() {
        this.andamentos = new ArrayList<>();
    }

    public Sff(long id, String sff, Usuario solicitante,
            String ultimoAndamento,
            Date dataUltimoAndamento, String material,
            Integer qtdMaterial, OrdemServico osm) {

        this.andamentos = new ArrayList<>();
        this.id = id;
        this.sff = sff;
        this.solicitante = solicitante;
        this.ultimoAndamento = ultimoAndamento;
        this.dataUltimoAndamento = dataUltimoAndamento;
        this.material = material;
        this.qtdMaterial = qtdMaterial;
        this.osm = osm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSff() {
        return sff;
    }

    public void setSff(String sff) {
        this.sff = sff;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public List<Andamento> getAndamentos() {
        return andamentos;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getQtdMaterial() {
        return qtdMaterial;
    }

    public void setQtdMaterial(Integer qtdMaterial) {
        this.qtdMaterial = qtdMaterial;
    }

    public void adicionarAndamento(Andamento andamento) {
        this.andamentos.add(andamento);
    }

    public void setAndamentos(List<Andamento> andamentos) {
        this.andamentos = andamentos;
    }

    public OrdemServico getOsm() {
        return osm;
    }

    public void setOsm(OrdemServico osm) {
        this.osm = osm;
    }

    public String getUltimoAndamento() {
        return ultimoAndamento;
    }

    public void setUltimoAndamento(String ultimoAndamento) {
        this.ultimoAndamento = ultimoAndamento;
    }

    public Date getDataUltimoAndamento() {
        return dataUltimoAndamento;
    }

    public void setDataUltimoAndamento(Date dataUltimoAndamento) {
        this.dataUltimoAndamento = dataUltimoAndamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.ultimoAndamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sff other = (Sff) obj;
        if (!Objects.equals(this.ultimoAndamento, other.ultimoAndamento)) {
            return false;
        }
        return true;
    }

  
}
