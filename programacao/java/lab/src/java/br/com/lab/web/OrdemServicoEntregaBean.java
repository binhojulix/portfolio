/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.lab.modelos.osm.OrdemServicoRN;
import br.com.lab.util.RelatorioUtil;
import br.com.lab.modelos.usuario.Usuario;
import br.com.lab.modelos.osm.OrdemServico;
import br.com.lab.modelos.modulo.ModuloRN;
import br.com.lab.util.UsuarioUtil;

/**
 *
 * @author fabiolu
 */
@ManagedBean
@ViewScoped
public class OrdemServicoEntregaBean {

    private OrdemServico ordemServico;
    private Usuario recebedor;

    private List<OrdemServico> listagem = new ArrayList<>();

    public void addFechadas() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (this.ordemServico.getStatus().equals("Liberada")) {
            Date data = new Date();
            this.ordemServico.setDataEntrega(data);
            this.ordemServico.setRecebedor(this.recebedor);
     
            ordemServico.setEntregador(new UsuarioUtil().getUsuario());
                
            OrdemServicoRN ordemServicoRN = new OrdemServicoRN();
          
            ordemServicoRN.salvar(ordemServico);
 
            this.ordemServico.setModuloObservacao(new ModuloRN().
                    getModuloObservacao(this.ordemServico.getNumero()));
            this.listagem.add(this.ordemServico);
            this.ordemServico = new OrdemServico();
        } else if (ordemServico.getStatus().equals("Fechada")) {
            context.addMessage(null, new FacesMessage("OS Fechada"));
        } else {
            context.addMessage(null, new FacesMessage("OS não liberada"));
        }
    }

    public void imprimir() {
        //protocolo de recebimento de equipamento
        RelatorioUtil relatorioUtil = new RelatorioUtil();
        relatorioUtil.imprimir(new ArrayList<Object>(this.listagem),
                "protocolo_entrega", "protocolo_entrega", new HashMap<String, Object>());

    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public List<OrdemServico> getListagem() {
        return listagem;
    }

    public void setListagem(List<OrdemServico> listagem) {
        this.listagem = listagem;
    }

    public Usuario getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Usuario recebedor) {
        this.recebedor = recebedor;
    }

}
