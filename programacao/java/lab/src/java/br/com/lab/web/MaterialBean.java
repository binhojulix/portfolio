/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.web;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.lab.modelos.material.MaterialRN;
import br.com.lab.modelos.material.Material;

/**
 *
 * @author fabio julio
 */
@ManagedBean
@ViewScoped
public class MaterialBean {

    private String criterio;
    private String coluna;
    private Material material = new Material();
    private List<Material> materiais = new ArrayList<>();

    private MaterialRN getMaterialRN() {
        MaterialRN materialRN = new MaterialRN();
        return materialRN;
    }

    public String salvarMaterial() {
        getMaterialRN().salvar(this.material);
        this.material = new Material();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Material cadastrado"));
        return "";
    }

    public void listarMaterial() {
        this.materiais = getMaterialRN().listarMateriais(criterio, coluna);
    }

    public List<Material> completarMaterial(String query) {
        List<Material> materiaisComplete = getMaterialRN().listarMateriais(query);
        return materiaisComplete;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public String getColuna() {
        return coluna;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }
}
