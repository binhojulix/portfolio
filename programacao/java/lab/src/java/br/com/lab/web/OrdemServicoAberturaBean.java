/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.web;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import br.com.lab.modelos.osm.OrdemServicoRN;
import br.com.lab.modelos.tabela.TabelaRN;
import br.com.lab.modelos.osm.OrdemServico;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author fabiolu
 */
@ManagedBean
@RequestScoped
public class OrdemServicoAberturaBean {

    private String titulo = "Abertura";
    private OrdemServico ordemServico = new OrdemServico();
    private List<SelectItem> options;

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();

        if ((this.ordemServico.getDataFalha() == null) && (!this.ordemServico.getNumeroFalha().isEmpty())) {
            context.addMessage(null, new FacesMessage("Data da falha obrigatório"));
        } else if ((this.ordemServico.getNumeroFalha().isEmpty() || this.ordemServico.getNumeroFalha() == null) && (this.ordemServico.getDataFalha() != null)) {
            context.addMessage(null, new FacesMessage("Número da falha obrigatório"));
        } else {

            OrdemServicoRN ordemServicoRN = new OrdemServicoRN();
            ordemServicoRN.salvar(ordemServico);
            context.addMessage(null, new FacesMessage("OSM SALVA COM SUCESSO"));
        }
    }

    public String editar() {
        String os = this.ordemServico.getNumero();
        this.ordemServico = new OrdemServicoRN().getOrdem(os);
        if (ordemServico.getStatus().equals("Aberta")) {
            return "/restrict/abertura.xhtml";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Apenas OSM abertas podem ser editadas"));
            return "/publico/home.xhtml";
        }
    }

    public void completarFinalidade() {
        TabelaRN tabelaRN = new TabelaRN();
        this.ordemServico.getEquipamento().setDescricao(tabelaRN.getFinalidade(ordemServico.getEquipamento()
                .getCodigoEquipamento()));
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public List<SelectItem> getOptions() {
        if (this.options == null) {
            this.options = new ArrayList<>();

            SelectItemGroup nivel1 = new SelectItemGroup("Nivel 1");
            nivel1.setSelectItems(new SelectItem[]{
                new SelectItem("01", "Fator A (01 Dia)"),
                new SelectItem("02", "Fator B (02 Dias)"),
                new SelectItem("03", "Fator C (04 Dias)")});

            SelectItemGroup nivel2 = new SelectItemGroup("Nivel 2");
            nivel2.setSelectItems(new SelectItem[]{
                new SelectItem("04", "Fator A (03 Dias)"),
                new SelectItem("05", "Fator B (06 Dias)"),
                new SelectItem("06", "Fator C (12 Dias)")});

            SelectItemGroup nivel3 = new SelectItemGroup("Nivel 3");
            nivel3.setSelectItems(new SelectItem[]{
                new SelectItem("07", "Fator A (06 Dias)"),
                new SelectItem("08", "Fator B (12 Dias)"),
                new SelectItem("09", "Fator C (24 Dias)")});

            SelectItemGroup nivel4 = new SelectItemGroup("Nivel 4");
            nivel4.setSelectItems(new SelectItem[]{
                new SelectItem("10", "Fator A (48 Dias)"),
                new SelectItem("11", "Fator B (96 Dias)"),
                new SelectItem("12", "Fator C (192 Dias)")});

            this.options.add(nivel1);
            this.options.add(nivel2);
            this.options.add(nivel3);
            this.options.add(nivel4);
        }
        return options;
    }

    public void setOptions(List<SelectItem> options) {
        this.options = options;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
