/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.osm;

import br.com.lab.modelos.usuario.Usuario;
import br.com.lab.modelos.tabela.Complexidade;
import br.com.lab.modelos.modulo.Modulo;
import br.com.lab.modelos.tabela.Tabela;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author fabio julio
 */
public class OrdemServico {

    private String numero;
    private Date dataAbertura;
    private Date horaAbertura;
    private Date dataFalha;
    private String numeroFalha;
    private String posicao;
    private Tabela local;
    private Tabela estacao;

    //solicitante de osm
    private Usuario solicitante;
    //solicitante que recebe o equipamento osm_entrega
    private Usuario responsavel;

    private Date dataFechamento;
    private Tabela fechamento;
    private Tabela liberacao;

    private Date dataEntrega;
    private Usuario recebedor;
    //funcionario que entrega o equipamento osm_entrega
    private Usuario entregador;
    //responsavel que atuara na manutencao osm_controle

    private Date prazo;

    private Tabela atividade;
    private Tabela avaria;

    //funcionario que abre, fecha osm's e modulos
    private Usuario sistema;

    private Complexidade complexidade;
    private Equipamento equipamento;
    private List<Modulo> modulos;
    private String status;
    private String servico;
    private Integer qtdModulo;
    private Integer equipamentoRestante;
    private String obs;
    private boolean imprimir;
    private String moduloObservacao;

    public OrdemServico() {

        this.responsavel = new Usuario();
        this.entregador = new Usuario();
        this.sistema = new Usuario();

        this.avaria = new Tabela();
        this.atividade = new Tabela();

        this.complexidade = new Complexidade();
        this.equipamento = new Equipamento();

        this.fechamento = new Tabela();
        this.liberacao = new Tabela();

        this.atividade.setCodigo("02");
        this.avaria.setCodigo("9999");
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Date getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(Date horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Tabela getAtividade() {
        return atividade;
    }

    public void setAtividade(Tabela atividade) {
        this.atividade = atividade;
    }

    public String getNumeroFalha() {
        return numeroFalha;
    }

    public void setNumeroFalha(String numeroFalha) {
        this.numeroFalha = numeroFalha;
    }

    public Date getDataFalha() {
        return dataFalha;
    }

    public void setDataFalha(Date dataFalha) {
        this.dataFalha = dataFalha;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Tabela getLocal() {
        return local;
    }

    public void setLocal(Tabela local) {
        this.local = local;
    }

    public Tabela getEstacao() {
        return estacao;
    }

    public void setEstacao(Tabela estacao) {
        this.estacao = estacao;
    }

    public Tabela getFechamento() {
        return fechamento;
    }

    public void setFechamento(Tabela fechamento) {
        this.fechamento = fechamento;
    }

    public Tabela getLiberacao() {
        return liberacao;
    }

    public void setLiberacao(Tabela liberacao) {
        this.liberacao = liberacao;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public Usuario getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Usuario recebedor) {
        this.recebedor = recebedor;
    }

    public Usuario getEntregador() {
        return entregador;
    }

    public void setEntregador(Usuario entregador) {
        this.entregador = entregador;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Tabela getAvaria() {
        return avaria;
    }

    public void setAvaria(Tabela avaria) {
        this.avaria = avaria;
    }

    public Complexidade getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(Complexidade complexidade) {
        this.complexidade = complexidade;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Usuario getSistema() {
        return sistema;
    }

    public void setSistema(Usuario sistema) {
        this.sistema = sistema;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String observacao) {
        this.servico = observacao;
    }

    public Integer getQtdModulo() {
        return qtdModulo;
    }

    public void setQtdModulo(Integer qtdModulo) {
        this.qtdModulo = qtdModulo;
    }

    public Integer getEquipamentoRestante() {
        return equipamentoRestante;
    }

    public void setEquipamentoRestante(Integer equipamentoRestante) {
        this.equipamentoRestante = equipamentoRestante;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public boolean isImprimir() {
        return imprimir;
    }

    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }

    public String getModuloObservacao() {
        return moduloObservacao;
    }

    public void setModuloObservacao(String moduloObservacao) {
        this.moduloObservacao = moduloObservacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.numero);
        hash = 97 * hash + Objects.hashCode(this.dataAbertura);
        hash = 97 * hash + Objects.hashCode(this.horaAbertura);
        hash = 97 * hash + Objects.hashCode(this.dataEntrega);
        hash = 97 * hash + Objects.hashCode(this.dataFalha);
        hash = 97 * hash + Objects.hashCode(this.prazo);
        hash = 97 * hash + Objects.hashCode(this.dataFechamento);
        hash = 97 * hash + Objects.hashCode(this.numeroFalha);
        hash = 97 * hash + Objects.hashCode(this.posicao);
        hash = 97 * hash + Objects.hashCode(this.local);
        hash = 97 * hash + Objects.hashCode(this.estacao);
        hash = 97 * hash + Objects.hashCode(this.fechamento);
        hash = 97 * hash + Objects.hashCode(this.liberacao);
        hash = 97 * hash + Objects.hashCode(this.atividade);
        hash = 97 * hash + Objects.hashCode(this.avaria);
        hash = 97 * hash + Objects.hashCode(this.solicitante);
        hash = 97 * hash + Objects.hashCode(this.recebedor);
        hash = 97 * hash + Objects.hashCode(this.entregador);
        hash = 97 * hash + Objects.hashCode(this.responsavel);
        hash = 97 * hash + Objects.hashCode(this.sistema);
        hash = 97 * hash + Objects.hashCode(this.complexidade);
        hash = 97 * hash + Objects.hashCode(this.equipamento);
        hash = 97 * hash + Objects.hashCode(this.modulos);
        hash = 97 * hash + Objects.hashCode(this.status);
        hash = 97 * hash + Objects.hashCode(this.servico);
        hash = 97 * hash + Objects.hashCode(this.qtdModulo);
        hash = 97 * hash + Objects.hashCode(this.equipamentoRestante);
        hash = 97 * hash + Objects.hashCode(this.obs);
        hash = 97 * hash + Objects.hashCode(this.moduloObservacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdemServico other = (OrdemServico) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.dataAbertura, other.dataAbertura)) {
            return false;
        }
        if (!Objects.equals(this.horaAbertura, other.horaAbertura)) {
            return false;
        }
        if (!Objects.equals(this.moduloObservacao, other.moduloObservacao)) {
            return false;
        }
        if (!Objects.equals(this.dataEntrega, other.dataEntrega)) {
            return false;
        }
        if (!Objects.equals(this.dataFalha, other.dataFalha)) {
            return false;
        }
        if (!Objects.equals(this.prazo, other.prazo)) {
            return false;
        }
        if (!Objects.equals(this.dataFechamento, other.dataFechamento)) {
            return false;
        }
        if (!Objects.equals(this.numeroFalha, other.numeroFalha)) {
            return false;
        }
        if (!Objects.equals(this.posicao, other.posicao)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.estacao, other.estacao)) {
            return false;
        }
        if (!Objects.equals(this.fechamento, other.fechamento)) {
            return false;
        }
        if (!Objects.equals(this.liberacao, other.liberacao)) {
            return false;
        }
        if (!Objects.equals(this.atividade, other.atividade)) {
            return false;
        }
        if (!Objects.equals(this.avaria, other.avaria)) {
            return false;
        }
        if (!Objects.equals(this.solicitante, other.solicitante)) {
            return false;
        }
        if (!Objects.equals(this.recebedor, other.recebedor)) {
            return false;
        }
        if (!Objects.equals(this.entregador, other.entregador)) {
            return false;
        }
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        if (!Objects.equals(this.sistema, other.sistema)) {
            return false;
        }
        if (!Objects.equals(this.complexidade, other.complexidade)) {
            return false;
        }
        if (!Objects.equals(this.equipamento, other.equipamento)) {
            return false;
        }
        if (!Objects.equals(this.modulos, other.modulos)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (!Objects.equals(this.qtdModulo, other.qtdModulo)) {
            return false;
        }
        if (!Objects.equals(this.equipamentoRestante, other.equipamentoRestante)) {
            return false;
        }
        if (!Objects.equals(this.obs, other.obs)) {
            return false;
        }
        return true;
    }

}
