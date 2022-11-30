/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.web;

import br.com.lab.modelos.osm.OrdemServico;
import br.com.lab.modelos.sff.Andamento;
import br.com.lab.modelos.sff.Sff;
import br.com.lab.modelos.sff.SffRN;
import java.util.List;
import org.primefaces.event.RowEditEvent;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author fabiolu
 */
@ManagedBean
@ViewScoped
public class SffBean implements Serializable {

    private Sff sff;
    private List<Sff> sffs;
    private List<Sff> sffsFilter = null;

    public SffBean() {
        this.sff = new Sff();
    }

    public void onRowEdit(RowEditEvent event) {

             FacesMessage msg
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Novo andamento adicionado",null);
             
            FacesContext.getCurrentInstance().addMessage(null, msg);
           
        Sff editSff = ((Sff) event.getObject());
       
        SffRN sffRN = new SffRN();
        long id = editSff.getId();
        editSff.setAndamentos(getAndamentos(id));
        sffRN.salvarAndamento(editSff);

        this.sff = new Sff();
        this.sffs = null;
        this.sffsFilter = null;
        
    }

    public void excluir() {
        SffRN sffRN = new SffRN();
        sffRN.deletar(this.sff.getId());
        this.sff = new Sff();
        this.sffs = null;
        this.sffsFilter = null;
    }

    
   public void showDetails(ToggleEvent event) {
        Sff detail = ((Sff) event.getData());
        String numero = detail.getOsm().getNumero();
        Long id = detail.getId();
        
        this.sff.setAndamentos(getAndamentos(id));
        this.sff.setOsm(new SffRN().buscarOsm(numero));
       
   }
   
   
   
    private List<Andamento> getAndamentos(long id) {
        SffRN sffRN = new SffRN();
        return sffRN.listarAndamentos(id);
    }

    
    public Sff getSff() {
        return sff;
    }

    public void setSff(Sff sff) {
        this.sff = sff;
    }

    public List<Sff> getSffs() {
        if (this.sffs == null) {
            this.sffs = new SffRN().listar();
        }
        return sffs;
    }

    public void setSffs(List<Sff> sffs) {
        this.sffs = sffs;
    }

    public List<Sff> getSffsFilter() {
        return sffsFilter;
    }

    public void setSffsFilter(List<Sff> sffsFilter) {
        this.sffsFilter = sffsFilter;
    }

}
