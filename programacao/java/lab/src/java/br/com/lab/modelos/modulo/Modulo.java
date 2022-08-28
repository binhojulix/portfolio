/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.modulo;

import br.com.lab.modelos.osm.OrdemServico;
import br.com.lab.modelos.usuario.Usuario;
import br.com.lab.modelos.tabela.Tabela;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author fabio julio
 */
public class Modulo {

    //chave primaria
    private Integer codigo;
    private Integer modulo;
    private Date dataAtuacao;
    private Date horaAbertura;
    private Date inicio;
    private Date fim;
    private Integer quantidade;
    private String observacao;
    private String observacaoCausa;
    private String observacaoAtuacao;
    private String servico;
    private OrdemServico ordemServico;
    private Usuario funcionario;
    private Tabela fechamento;
    private Tabela liberacao;

    private List<ModuloAtraso> atrasos;
    private List<ModuloInstrumento> instrumentos;
    private List<ModuloMovimentacao> movimentacoes;
    private List<ModuloFinalidade> finalidades;
    private List<ModuloUsuario> usuarios;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

    public Date getDataAtuacao() {
        return dataAtuacao;
    }

    public void setDataAtuacao(Date dataAtuacao) {
        this.dataAtuacao = dataAtuacao;
    }

    public Date getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(Date horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacaoCausa() {
        return observacaoCausa;
    }

    public void setObservacaoCausa(String observacaoCausa) {
        this.observacaoCausa = observacaoCausa;
    }

    public String getObservacaoAtuacao() {
        return observacaoAtuacao;
    }

    public void setObservacaoAtuacao(String observacaoAtuacao) {
        this.observacaoAtuacao = observacaoAtuacao;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Usuario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Usuario funcionario) {
        this.funcionario = funcionario;
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

    public List<ModuloAtraso> getAtrasos() {
        return atrasos;
    }

    public void setAtrasos(List<ModuloAtraso> atrasos) {
        this.atrasos = atrasos;
    }

    public List<ModuloInstrumento> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<ModuloInstrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public List<ModuloMovimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<ModuloMovimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public List<ModuloFinalidade> getFinalidades() {
        return finalidades;
    }

    public void setFinalidades(List<ModuloFinalidade> finalidades) {
        this.finalidades = finalidades;
    }

    public List<ModuloUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<ModuloUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.codigo);
        hash = 17 * hash + Objects.hashCode(this.modulo);
        hash = 17 * hash + Objects.hashCode(this.dataAtuacao);
        hash = 17 * hash + Objects.hashCode(this.horaAbertura);
        hash = 17 * hash + Objects.hashCode(this.inicio);
        hash = 17 * hash + Objects.hashCode(this.fim);
        hash = 17 * hash + Objects.hashCode(this.quantidade);
        hash = 17 * hash + Objects.hashCode(this.observacao);
        hash = 17 * hash + Objects.hashCode(this.observacaoCausa);
        hash = 17 * hash + Objects.hashCode(this.observacaoAtuacao);
        hash = 17 * hash + Objects.hashCode(this.servico);
        hash = 17 * hash + Objects.hashCode(this.ordemServico);
        hash = 17 * hash + Objects.hashCode(this.funcionario);
        hash = 17 * hash + Objects.hashCode(this.fechamento);
        hash = 17 * hash + Objects.hashCode(this.liberacao);
        hash = 17 * hash + Objects.hashCode(this.atrasos);
        hash = 17 * hash + Objects.hashCode(this.instrumentos);
        hash = 17 * hash + Objects.hashCode(this.movimentacoes);
        hash = 17 * hash + Objects.hashCode(this.finalidades);
        hash = 17 * hash + Objects.hashCode(this.usuarios);
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
        final Modulo other = (Modulo) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.modulo, other.modulo)) {
            return false;
        }
        if (!Objects.equals(this.dataAtuacao, other.dataAtuacao)) {
            return false;
        }
        if (!Objects.equals(this.horaAbertura, other.horaAbertura)) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.fim, other.fim)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.observacaoCausa, other.observacaoCausa)) {
            return false;
        }
        if (!Objects.equals(this.observacaoAtuacao, other.observacaoAtuacao)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (!Objects.equals(this.ordemServico, other.ordemServico)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.fechamento, other.fechamento)) {
            return false;
        }
        if (!Objects.equals(this.liberacao, other.liberacao)) {
            return false;
        }
        if (!Objects.equals(this.atrasos, other.atrasos)) {
            return false;
        }
        if (!Objects.equals(this.instrumentos, other.instrumentos)) {
            return false;
        }
        if (!Objects.equals(this.movimentacoes, other.movimentacoes)) {
            return false;
        }
        if (!Objects.equals(this.finalidades, other.finalidades)) {
            return false;
        }
        if (!Objects.equals(this.usuarios, other.usuarios)) {
            return false;
        }
        return true;
    }

}
