/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cptm.sc.controller;

import br.com.cptm.sc.modelos.material.Material;
import br.com.cptm.sc.modelos.material.MaterialRN;
import br.com.cptm.sc.modelos.usuario.util.UsuarioUtil;
import br.com.cptm.sc.util.RelatorioUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MaterialController implements Serializable {

    private Material material;
    private List<Material> materiaisSelecionados;
    private List<Material> materiaisFiltrados;
    private List<Material> materiais;
    private int PDF;

    @PostConstruct
    public void init() {
        this.material = new Material();
        this.material.setDataSolicitacao(new Date());
        this.material.setStatus("Solicitada");
        //  this.material.setUsuario(new UsuarioUtil().getUsuario());
    }

    public String salvar() {
        MaterialRN materialRN = new MaterialRN();
        materialRN.salvar(this.material);
        this.material = new Material();
        return "home.xhtml";
    }

    public void imprimir() {
        System.out.println("herre");
        List<Material> listagem = new ArrayList<>();
        RelatorioUtil relatorioUtil = new RelatorioUtil();
        FacesContext context = FacesContext.getCurrentInstance();
        switch (PDF) {
            //protocolo de recebimento de equipamento
            case 1:

                relatorioUtil.imprimir(new ArrayList<Object>(listagem),
                        "cotacao", "cotacao", new HashMap<String, Object>());
                System.out.println("herre");
                break;

        }
    }

    public List<Material> getMateriais() {

        if (materiais == null) {
            this.materiais = new MaterialRN().listar();
        }
        return materiais;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Material> getMateriaisSelecionados() {
        return materiaisSelecionados;
    }

    public void setMateriaisSelecionados(List<Material> materiaisSelecionados) {
        this.materiaisSelecionados = materiaisSelecionados;
    }

    public int getPDF() {
        return PDF;
    }

    public void setPDF(int PDF) {
        this.PDF = PDF;
    }

    public List<Material> getMateriaisFiltrados() {
        return materiaisFiltrados;
    }

    public void setMateriaisFiltrados(List<Material> materiaisFiltrados) {
        this.materiaisFiltrados = materiaisFiltrados;
    }

}
