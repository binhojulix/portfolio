/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.com.lab.modelos.modulo.ModuloRN;
import br.com.lab.modelos.tabela.TabelaRN;
import br.com.lab.modelos.modulo.Modulo;
import br.com.lab.modelos.modulo.ModuloAtraso;
import br.com.lab.modelos.modulo.ModuloFinalidade;
import br.com.lab.modelos.modulo.ModuloInstrumento;
import br.com.lab.modelos.modulo.ModuloMovimentacao;
import br.com.lab.modelos.modulo.ModuloUsuario;
import br.com.lab.modelos.movimentacao.Movimentacao;
import br.com.lab.modelos.tabela.Tabela;
import br.com.lab.modelos.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author fabio julio
 */
@ManagedBean
@ViewScoped
public class ModuloBean {

    private Modulo modulo = new Modulo();

    private ModuloInstrumento moduloIntrumento = new ModuloInstrumento();
    private ModuloFinalidade moduloFinalidade = new ModuloFinalidade();
    private ModuloMovimentacao moduloMovimentacao = new ModuloMovimentacao();
    private ModuloAtraso moduloAtraso = new ModuloAtraso();
    private ModuloUsuario moduloUsuario = new ModuloUsuario();
    private Movimentacao movimentacao = new Movimentacao();
    private List<ModuloInstrumento> moduloInstrumentos = new ArrayList<>();
    private List<ModuloFinalidade> moduloFinalidades = new ArrayList<>();
    private List<ModuloMovimentacao> moduloMovimentacoes = new ArrayList<>();
    private List<ModuloAtraso> moduloAtrasos = new ArrayList<>();
    private Tabela atraso = new Tabela();
    private List<ModuloUsuario> moduloUsuarios = new ArrayList<>();
    private Usuario passarUsuario;

    public String salvarModulo() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (this.modulo.getInicio().after(this.modulo.getFim())) {
            context.addMessage(null, new FacesMessage("hora inicial maior que final"));
            return "";
        } else if (!this.modulo.getOrdemServico().getLiberacao().getCodigo().equals("2")) {
            context.addMessage(null, new FacesMessage("OS Fechada"));
            return "";
        } else if (this.modulo.getQuantidade() > this.modulo.getOrdemServico().getEquipamentoRestante()) {
            context.addMessage(null, new FacesMessage("Qtd.: de equpamento maior que Qtd.: solicitada"));
            return "";
        } else {
            ModuloRN moduloRN = new ModuloRN();
            this.modulo.setModulo(moduloRN.getNumeroModulo(this.modulo.getOrdemServico().getNumero()));
            this.modulo.setFuncionario(this.modulo.getOrdemServico().getResponsavel());

            if (this.passarUsuario != null) {
                this.modulo.getOrdemServico().setResponsavel(this.passarUsuario);
            }

            String proximoServico = this.modulo.getServico();
            this.modulo.setServico(this.modulo.getOrdemServico().getServico());

            if (!proximoServico.isEmpty()) {
                this.modulo.getOrdemServico().setServico(proximoServico);
            }

            this.modulo.setInstrumentos(this.moduloInstrumentos);
            this.modulo.setFinalidades(this.moduloFinalidades);
            this.modulo.setMovimentacoes(this.moduloMovimentacoes);
            this.modulo.setAtrasos(this.moduloAtrasos);
            this.modulo.setUsuarios(this.moduloUsuarios);

            moduloRN.save(this.modulo);
            this.modulo = new Modulo();
            return "home";
        }
    }

    public void addInstrumentos() {
        this.moduloInstrumentos.add(this.moduloIntrumento);
        this.moduloIntrumento = new ModuloInstrumento();
    }

    public void removeInstrumento() {
        this.moduloInstrumentos.remove(this.moduloIntrumento);
        this.moduloIntrumento = new ModuloInstrumento();
    }

    public void addFinalidades() {
        this.moduloFinalidades.add(this.moduloFinalidade);
        this.moduloFinalidade = new ModuloFinalidade();
    }

    public void removerFinalidade() {
        this.moduloFinalidades.remove(this.moduloFinalidade);
        this.moduloFinalidade = new ModuloFinalidade();
    }

    public void addUsuarios() {
        if (!this.moduloUsuarios.contains(this.moduloUsuario)) {
            this.moduloUsuarios.add(this.moduloUsuario);
            this.moduloUsuario = new ModuloUsuario();
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Usuário já adicionado"));
        }
    }

    public void removeUsuario() {
        this.moduloUsuarios.remove(this.moduloUsuario);
        this.moduloUsuario = new ModuloUsuario();
    }

    public void addAtrasos() {
        TabelaRN tabelaRN = new TabelaRN();
        ModuloAtraso temp;
        temp = tabelaRN.getAtraso(this.atraso.getCodigo(), moduloAtraso.getTipo());
        if (temp != null) {
            this.moduloAtraso = temp;
            this.moduloAtrasos.add(this.moduloAtraso);
            this.moduloAtraso = new ModuloAtraso();
            this.atraso = new Tabela();
        } else {
            FacesContext contexo = FacesContext.getCurrentInstance();
            contexo.addMessage(null, new FacesMessage("Código inválido"));
        }
    }

    public void removeAtraso() {
        this.moduloAtrasos.remove(this.moduloAtraso);
        this.moduloAtraso = new ModuloAtraso();

    }

    public void addMovimentacoes() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.movimentacao.getQuantidade()
                > this.movimentacao.getMaterial().getEstoque()
                && this.movimentacao.getTipo().equals("AMX")) {
            context.addMessage(null, new FacesMessage("Valor solicitado maior que estoque"));
        } else {
            this.moduloMovimentacao.setMovimentacao(this.movimentacao);
            this.moduloMovimentacoes.add(this.moduloMovimentacao);
            this.moduloMovimentacao = new ModuloMovimentacao();
            this.movimentacao = new Movimentacao();
        }
    }

    public void removerMovimentacao() {
        this.moduloMovimentacoes.remove(this.moduloMovimentacao);
        this.moduloMovimentacao = new ModuloMovimentacao();
    }

    // gets and sets
    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public ModuloInstrumento getModuloIntrumento() {
        return moduloIntrumento;
    }

    public void setModuloIntrumento(ModuloInstrumento moduloIntrumento) {
        this.moduloIntrumento = moduloIntrumento;
    }

    public ModuloFinalidade getModuloFinalidade() {
        return moduloFinalidade;
    }

    public void setModuloFinalidade(ModuloFinalidade moduloFinalidade) {
        this.moduloFinalidade = moduloFinalidade;
    }

    public ModuloMovimentacao getModuloMovimentacao() {
        return moduloMovimentacao;
    }

    public void setModuloMovimentacao(ModuloMovimentacao moduloMovimentacao) {
        this.moduloMovimentacao = moduloMovimentacao;
    }

    public ModuloAtraso getModuloAtraso() {
        return moduloAtraso;
    }

    public void setModuloAtraso(ModuloAtraso moduloAtraso) {
        this.moduloAtraso = moduloAtraso;
    }

    public ModuloUsuario getModuloUsuario() {
        return moduloUsuario;
    }

    public void setModuloUsuario(ModuloUsuario moduloUsuario) {
        this.moduloUsuario = moduloUsuario;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public List<ModuloInstrumento> getModuloInstrumentos() {
        return moduloInstrumentos;
    }

    public void setModuloInstrumentos(List<ModuloInstrumento> moduloInstrumentos) {
        this.moduloInstrumentos = moduloInstrumentos;
    }

    public List<ModuloFinalidade> getModuloFinalidades() {
        return moduloFinalidades;
    }

    public void setModuloFinalidades(List<ModuloFinalidade> moduloFinalidades) {
        this.moduloFinalidades = moduloFinalidades;
    }

    public List<ModuloMovimentacao> getModuloMovimentacoes() {
        return moduloMovimentacoes;
    }

    public void setModuloMovimentacoes(List<ModuloMovimentacao> moduloMovimentacoes) {
        this.moduloMovimentacoes = moduloMovimentacoes;
    }

    public List<ModuloAtraso> getModuloAtrasos() {
        return moduloAtrasos;
    }

    public void setModuloAtrasos(List<ModuloAtraso> moduloAtrasos) {
        this.moduloAtrasos = moduloAtrasos;
    }

    public Tabela getAtraso() {
        return atraso;
    }

    public void setAtraso(Tabela atraso) {
        this.atraso = atraso;
    }

    public List<ModuloUsuario> getModuloUsuarios() {
        return moduloUsuarios;
    }

    public void setModuloUsuarios(List<ModuloUsuario> moduloUsuarios) {
        this.moduloUsuarios = moduloUsuarios;
    }

    public Usuario getPassarUsuario() {
        return passarUsuario;
    }

    public void setPassarUsuario(Usuario passarUsuario) {
        this.passarUsuario = passarUsuario;
    }

}
