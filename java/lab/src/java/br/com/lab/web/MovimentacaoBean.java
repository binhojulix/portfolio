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
import br.com.lab.modelos.movimentacao.MovimentacaoRN;
import br.com.lab.util.RelatorioUtil;
import br.com.lab.modelos.movimentacao.Movimentacao;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author fabio julio
 */
@ManagedBean
@ViewScoped
public class MovimentacaoBean {

    /**
     * Creates a new instance of MovimentacaoBean
     */
    private List<Movimentacao> movimentacoes;
    private Movimentacao movimentacao = new Movimentacao();

    private MovimentacaoRN getMovimentacaoRN() {
        MovimentacaoRN movimentacaoRN = new MovimentacaoRN();
        return movimentacaoRN;
    }

    public String salvarMovimentacao() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (movimentacao.getQuantidade() > movimentacao.getMaterial().getEstoque()
                && movimentacao.getTipo().equals("SAIDA")) {
            context.addMessage(null, new FacesMessage("Quantidade Solicitada maior que estoque"));
        } else {
            getMovimentacaoRN().salvar(movimentacao);
            movimentacao = new Movimentacao();
            context.addMessage(null, new FacesMessage("Movimentação realizada com sucesso"));
        }
        return "";
    }

    public void consultar() {
        movimentacoes = getMovimentacaoRN().listByCriterio(this.movimentacao);
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

}
