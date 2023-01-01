/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.web;

import java.util.ArrayList;
import java.util.List;
import br.com.lab.modelos.finalidade.FinalidadeRN;
import br.com.lab.modelos.finalidade.Equipamento;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author fabiolu
 */
@ManagedBean
@ViewScoped
public class FinalidadeBBean {

    private String opt;
    private final FinalidadeRN finalidadeRN;

    private HtmlOutputText mensagemAcao;

    private HtmlInputText inputEquipamento;
    private HtmlInputText inputSubsistema;
    private HtmlInputText inputSistema;
    private HtmlInputText inputDescricao;

    private HtmlSelectOneMenu sistemas;
    private HtmlSelectOneMenu subsistemas;

    private HtmlOutputLabel lbdescricao;

    private List<SelectItem> selectisistemas;
    private List<SelectItem> selectisubsistemas;
    private List<Equipamento> listarTodos;
    private List<Equipamento> listarFilter;
    private Equipamento eqpt_operacoes;

    public FinalidadeBBean() {
        super();
        this.listarFilter=null;
        this.finalidadeRN = new FinalidadeRN();
        this.eqpt_operacoes = new Equipamento();
    }

    private void novoSistema() {
        this.inputEquipamento.setDisabled(true);
        this.inputSubsistema.setDisabled(true);
        this.sistemas.setDisabled(true);
        this.subsistemas.setDisabled(true);
        this.inputSistema.setRequired(false);
        this.inputSistema.setRequired(true);
        this.inputSistema.setRequiredMessage("Campo codigo do Sistema obrigatório");
        disableButton("Sistema:");
    }

    private void novoSub() {
        this.inputEquipamento.setDisabled(true);
        this.inputSistema.setDisabled(true);
        this.subsistemas.setDisabled(true);

        this.sistemas.setRequired(true);
        this.sistemas.setRequiredMessage("Selecione uma sistema");

        this.inputSistema.setRequired(true);
        this.inputSistema.setRequiredMessage("Campo codigo do Sistema obrigatório");

        this.inputSubsistema.setRequired(true);
        this.inputSubsistema.setRequiredMessage("Campo codigo do Sub Sistema obrigatório");

        disableButton("Subsistema:");
    }

    private void novoEquipamento() {
        inputSistema.setDisabled(true);
        inputSubsistema.setDisabled(true);

        sistemas.setRequired(true);
        sistemas.setRequiredMessage("Selecione uma sistema");

        subsistemas.setRequired(true);
        subsistemas.setRequiredMessage("Selecione uma subsistema");

        inputSistema.setRequired(true);
        inputSistema.setRequiredMessage("Campo codigo do Sistema obrigatório");

        inputSubsistema.setRequired(true);
        inputSubsistema.setRequiredMessage("Campo codigo do Sub Sistema obrigatório");

        inputEquipamento.setRequired(true);
        inputEquipamento.setRequiredMessage("Campo codigo do Equipamento obrigatório");

        this.disableButton("Equipamento:");
    }

    private void disableButton(String mensagem) {
        this.mensagemAcao.setValue(mensagem);
        this.lbdescricao.setValue(mensagem);
        this.inputDescricao.setRequired(true);
        this.inputDescricao.setRequiredMessage("Campo Descricao obrigatório");
    }

    private void reset() {
        this.inputEquipamento.setRequired(false);
        this.inputEquipamento.setDisabled(false);
        this.inputDescricao.setValue(null);

        this.inputSubsistema.setRequired(false);
        this.inputSubsistema.setDisabled(false);
        this.inputSubsistema.setValue(null);

        this.inputSistema.setDisabled(false);
        this.inputSistema.setRequired(false);
        this.inputSistema.setValue(null);

        this.inputDescricao.setDisabled(false);
        this.inputDescricao.setRequired(false);
        this.inputDescricao.setValue(null);

        this.sistemas.setDisabled(false);
        this.sistemas.setRequired(false);
        this.sistemas.setValue(null);

        this.subsistemas.setDisabled(false);
        this.subsistemas.setRequired(false);
        this.subsistemas.setValue(null);

    }

    public void novaFinalidade() {
        reset();
        if (opt.equals("sistema")) {
            novoSistema();
        } else if (opt.equals("subsistema")) {
            novoSub();
        } else if (opt.equals("equipamento")) {
            novoEquipamento();
        }
    }

    public String tipoFinalidade(String param) {
        if (finalidadeRN.isSub(param)) {
            return "subsistema";
        } else if (finalidadeRN.isSistema(param)) {
            return "sistema";
        } else {
            return "equipamento";
        }
    }

    private List<SelectItem> preencherSelectItem(String label, List<Equipamento> equipamentos) {
        List<SelectItem> selecItens = new ArrayList<>();
        SelectItemGroup selectItem = new SelectItemGroup(label);
        SelectItem vetor[] = new SelectItem[equipamentos.size()];
        int contador = 0;
        for (Equipamento e : equipamentos) {
            vetor[contador] = new SelectItem(e.getCodigo(), e.getCodigo() + " - " + e.getDescricao());
            contador++;
        }
        selectItem.setSelectItems(vetor);
        selecItens.add(selectItem);
        return selecItens;
    }

    public void editar() {
        String codigo = this.eqpt_operacoes.getCodigo();
        String descricao = this.eqpt_operacoes.getDescricao();
        this.opt = tipoFinalidade(codigo);
        novaFinalidade();

        // sistema
        if (this.opt.equals("sistema")) {
            String sis = codigo.substring(0, 3).concat("00000000");
            this.sistemas.setValue(sis);
            this.inputSistema.setValue(sis.substring(0, 3));
            this.inputDescricao.setValue(descricao);

            //subsistema
        } else if (this.opt.equals("subsistema")) {
            String sis = codigo.substring(0, 3).concat("00000000");
            String sub = codigo.substring(0, 5).concat("000000");
            this.sistemas.setValue(sis);
            this.inputSistema.setValue(sis.substring(0, 3));
            this.inputDescricao.setValue(descricao);
            atualizarSistema();
            this.subsistemas.setValue(sub);
            this.inputSubsistema.setValue(sub.substring(3, 5));

            //equipamento
        } else {
            String sis = codigo.substring(0, 3).concat("00000000");
            String sub = codigo.substring(0, 5).concat("000000");
            String eqpt = codigo.substring(5, 7);
            this.sistemas.setValue(sis);
            this.inputSistema.setValue(sis.substring(0, 3));
            this.inputEquipamento.setValue(eqpt);
            this.inputDescricao.setValue(descricao);
            atualizarSistema();
            this.subsistemas.setValue(sub);
            this.inputSubsistema.setValue(sub.substring(3, 5));

        }

    }

    public String salvar() {

        String descricao = this.inputDescricao.getValue().toString();
        String codigo = null;

        if (mensagemAcao.getValue().equals("Equipamento:")) {
            String strCodSubSistema = this.subsistemas.getValue().toString().substring(3, 5);
            String strCodSistema = this.sistemas.getValue().toString().substring(0, 3);
            String equipamento = this.inputEquipamento.getValue().toString();
            codigo = strCodSistema + strCodSubSistema + equipamento + "0000";

        } else if (mensagemAcao.getValue().equals("Subsistema:")) {
            String sub = this.inputSubsistema.getValue().toString();
            String strCodSistema = this.sistemas.getValue().toString().substring(0, 3);
            codigo = strCodSistema.substring(0, 3) + sub + "000000";

        } else if (mensagemAcao.getValue().equals("Sistema:")) {
            String sistema = this.inputSistema.getValue().toString();
            codigo = sistema + "00000000";
        }

        Equipamento equi = new Equipamento();

        equi.setCodigo(codigo);
        equi.setDescricao(descricao);
        finalidadeRN.salvarEditar(equi);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(this.lbdescricao.getValue() + " Salvo com sucesso Descricao: "
                + equi.getDescricao() + " Codigo: " + equi.getCodigo()));

        return "finalidades.xhtml";
    }

    public void excluir() {
        String codigo = this.eqpt_operacoes.getCodigo();
        finalidadeRN.excluir(codigo);
        this.listarTodos = null;
        this.eqpt_operacoes = new Equipamento();
    }

    public void atualizarSub() {
        String strCodSubSistema = this.subsistemas.getValue().toString().substring(3, 5);
        this.inputSubsistema.setValue(strCodSubSistema);
    }

    public void atualizarSistema() {
        String strCodSistema = this.sistemas.getValue().toString().substring(0, 3);
        this.inputSistema.setValue(strCodSistema);
        List<Equipamento> lista = this.finalidadeRN.listar(strCodSistema);
        this.selectisubsistemas = preencherSelectItem("Subsistema", lista);
    }

    public List<SelectItem> getSelectisistemas() {
        List<Equipamento> lista = this.finalidadeRN.listar();
        this.selectisistemas = preencherSelectItem("Sistemas", lista);
        return selectisistemas;
    }

    public void setSelectisistemas(List<SelectItem> selectisistemas) {
        this.selectisistemas = selectisistemas;
    }

    public List<SelectItem> getSelectisubsistemas() {
        return selectisubsistemas;
    }

    public void setSelectisubsistemas(List<SelectItem> selectisubsistemas) {
        this.selectisubsistemas = selectisubsistemas;
    }

    public HtmlInputText getInputEquipamento() {
        return inputEquipamento;
    }

    public void setInputEquipamento(HtmlInputText inputEquipamento) {
        this.inputEquipamento = inputEquipamento;
    }

    public HtmlInputText getInputSubsistema() {
        return inputSubsistema;
    }

    public void setInputSubsistema(HtmlInputText inputSubsistema) {
        this.inputSubsistema = inputSubsistema;
    }

    public HtmlInputText getInputSistema() {
        return inputSistema;
    }

    public void setInputSistema(HtmlInputText inputSistema) {
        this.inputSistema = inputSistema;
    }

    public HtmlOutputText getMensagemAcao() {
        return mensagemAcao;
    }

    public void setMensagemAcao(HtmlOutputText mensagemAcao) {
        this.mensagemAcao = mensagemAcao;
    }

    public HtmlSelectOneMenu getSistemas() {
        return sistemas;
    }

    public void setSistemas(HtmlSelectOneMenu sistemas) {
        this.sistemas = sistemas;
    }

    public HtmlSelectOneMenu getSubsistemas() {
        return subsistemas;
    }

    public void setSubsistemas(HtmlSelectOneMenu subsistemas) {
        this.subsistemas = subsistemas;
    }

    public HtmlOutputLabel getLbdescricao() {
        return lbdescricao;
    }

    public void setLbdescricao(HtmlOutputLabel lbdescricao) {
        this.lbdescricao = lbdescricao;
    }

    public HtmlInputText getInputDescricao() {
        return inputDescricao;
    }

    public void setInputDescricao(HtmlInputText inputDescricao) {
        this.inputDescricao = inputDescricao;
    }

    public List<Equipamento> getListarTodos() {
        if (this.listarTodos == null) {
            this.listarTodos = finalidadeRN.listarAll();
        }
        return listarTodos;
    }

    public void setListarTodos(List<Equipamento> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public Equipamento getEqpt_operacoes() {
        return eqpt_operacoes;
    }

    public void setEqpt_operacoes(Equipamento eqpt_operacoes) {
        this.eqpt_operacoes = eqpt_operacoes;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public List<Equipamento> getListarFilter() {
        return listarFilter;
    }

    public void setListarFilter(List<Equipamento> listarFilter) {
        this.listarFilter = listarFilter;
    }

}
