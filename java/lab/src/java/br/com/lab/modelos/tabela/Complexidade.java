package br.com.lab.modelos.tabela;

import java.util.Objects;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fabio julio
 */
public class Complexidade {

    private String codigo;
    private String nivel;
    private String fator;
    private Integer tempoMaximoAtuacao;
    private Integer tempoMaximoReparacao;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getFator() {
        return fator;
    }

    public void setFator(String fator) {
        this.fator = fator;
    }

    public Integer getTempoMaximoAtuacao() {
        return tempoMaximoAtuacao;
    }

    public void setTempoMaximoAtuacao(Integer tempoMaximoAtuacao) {
        this.tempoMaximoAtuacao = tempoMaximoAtuacao;
    }

    public Integer getTempoMaximoReparacao() {
        return tempoMaximoReparacao;
    }

    public void setTempoMaximoReparacao(Integer tempoMaximoReparacao) {
        this.tempoMaximoReparacao = tempoMaximoReparacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nivel);
        hash = 97 * hash + Objects.hashCode(this.fator);
        hash = 97 * hash + Objects.hashCode(this.tempoMaximoAtuacao);
        hash = 97 * hash + Objects.hashCode(this.tempoMaximoReparacao);
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
        final Complexidade other = (Complexidade) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        if (!Objects.equals(this.fator, other.fator)) {
            return false;
        }
        if (!Objects.equals(this.tempoMaximoAtuacao, other.tempoMaximoAtuacao)) {
            return false;
        }
        if (!Objects.equals(this.tempoMaximoReparacao, other.tempoMaximoReparacao)) {
            return false;
        }
        return true;
    }

}
