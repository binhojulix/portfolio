    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.ToggleEvent;
import br.com.lab.modelos.modulo.ModuloRN;
import br.com.lab.modelos.osm.OrdemServicoRN;
import br.com.lab.util.RelatorioUtil;
import br.com.lab.modelos.osm.OrdemServico;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author fabio julio
 */
@ManagedBean
@ViewScoped
public class OrdemServicoBean implements Serializable{

    private List<OrdemServico> listOrdens = new ArrayList<>();
    private List<OrdemServico> listFiltrada = null;
    private List<OrdemServico> listSelected = null;
    private OrdemServico ordemServico = new OrdemServico();
    private Integer PDF;
    private String status="Abertas";

    /**
     * Creates a new instance of OrdemServicoBean
     */
    //metodo responsavel por passar osm para outro funcionario
    private OrdemServicoRN getOrdemServicoRN() {
        OrdemServicoRN ordemServicoRN = new OrdemServicoRN();
        return ordemServicoRN;
    }

    public void mostrarOSM(ToggleEvent event) {
        String numero = ((OrdemServico) event.getData()).getNumero();
        this.ordemServico = getOrdemServicoRN().getOrdem(numero);
        this.ordemServico.setModulos(new ModuloRN().listarModulos(numero));
    }

    public void imprimir() {
        List<OrdemServico> listagem = new ArrayList<>();
        RelatorioUtil relatorioUtil = new RelatorioUtil();
        FacesContext context = FacesContext.getCurrentInstance();
        switch (PDF) {
            //protocolo de recebimento de equipamento
            case 1:

                try {
                    if (listSelected == null) {
                        context.addMessage(null, new FacesMessage("NENHUMA OS SELECIONADA"));
                        break;
                    } else if (!listSelected.isEmpty()) {
                        for (OrdemServico o : listSelected) {
                            listagem.add(getOrdemServicoRN().getOrdem(o.getNumero()));
                        }
                        relatorioUtil.imprimir(new ArrayList<Object>(listagem),
                                "protocolo_recebimento", "protocolo_recebimento", new HashMap<String, Object>());
                        break;
                    }
                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
                break;

            //novo modulo    
            case 3:
                try {
                    if (listSelected == null) {
                        context.addMessage(null, new FacesMessage("NENHUMA OS SELECIONADA"));
                        break;
                    } else if (!listSelected.isEmpty()) {
                        OrdemServico tempory;
                        for (OrdemServico o : listSelected) {
                            tempory = getOrdemServicoRN().getOrdem(o.getNumero());
                            listagem.add(tempory);
                            tempory.setImprimir(false);
                            getOrdemServicoRN().salvar(tempory);
                        }
                        relatorioUtil.imprimir(new ArrayList<Object>(listagem),
                                "protocolo", "protocolo", new HashMap<String, Object>());
                        break;
                    }
                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    public void consultar() {
        listFiltrada = null;
        this.listOrdens = getOrdemServicoRN().listarPesquisas(this.status);
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public List<OrdemServico> getListOrdens() {
        if (this.listOrdens.isEmpty()) {
            this.listOrdens = getOrdemServicoRN().listarPesquisas(this.status);
        }
        return listOrdens;
    }

    public Integer getPDF() {
        return PDF;
    }

    public void setPDF(Integer PDF) {
        this.PDF = PDF;
    }

    public List<OrdemServico> getListFiltrada() {
        return listFiltrada;
    }

    public void setListFiltrada(List<OrdemServico> listFiltrada) {
        this.listFiltrada = listFiltrada;
    }

    public List<OrdemServico> getListSelected() {
        return listSelected;
    }

    public void setListSelected(List<OrdemServico> listSelected) {
        this.listSelected = listSelected;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
