/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.web;

import br.com.lab.modelos.sff.Sff;
import br.com.lab.modelos.sff.SffRN;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author fabiolu
 */
@ManagedBean
@ViewScoped
public class SffBeanCadastro implements Serializable {

    private Sff sff;
    private List<Sff> sffs;

    public SffBeanCadastro() {
        this.sff = new Sff();
        this.sffs = new ArrayList<>();
    }

    public String salvarSFF() {
        for (Sff s : sffs) {
            SffRN sffRN = new SffRN();
            sffRN.salvarSFF(s);
        }
        
        return "adm-sff";
    }

    public void adicionar() {
        this.sffs.add(this.sff);
        this.sff = new Sff();
        FacesMessage msg
                = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Elemento adicionado com sucesso", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void remover() {
        this.sffs.remove(this.sff);
        this.sff = new Sff();
        FacesMessage msg
                = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Sff removida", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Sff getSff() {
        return sff;
    }

    public void setSff(Sff sff) {
        this.sff = sff;
    }

    public List<Sff> getSffs() {
        return sffs;
    }

    public void setSffs(List<Sff> sffs) {
        this.sffs = sffs;
    }

}
