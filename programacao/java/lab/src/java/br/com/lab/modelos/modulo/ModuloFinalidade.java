/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.modulo;

import br.com.lab.modelos.tabela.Tabela;
import java.util.Objects;

/**
 *
 * @author fabio julio
 */
public class ModuloFinalidade {

    private Integer modulo;
    private Tabela atuacao;
    private Tabela causa;
    private String finalidade = "00000";
    private Integer item = 0;

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

    public Tabela getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(Tabela atuacao) {
        this.atuacao = atuacao;
    }

    public Tabela getCausa() {
        return causa;
    }

    public void setCausa(Tabela causa) {
        this.causa = causa;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.modulo);
        hash = 23 * hash + Objects.hashCode(this.atuacao);
        hash = 23 * hash + Objects.hashCode(this.causa);
        hash = 23 * hash + Objects.hashCode(this.finalidade);
        hash = 23 * hash + Objects.hashCode(this.item);
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
        final ModuloFinalidade other = (ModuloFinalidade) obj;
        if (!Objects.equals(this.modulo, other.modulo)) {
            return false;
        }
        if (!Objects.equals(this.atuacao, other.atuacao)) {
            return false;
        }
        if (!Objects.equals(this.causa, other.causa)) {
            return false;
        }
        if (!Objects.equals(this.finalidade, other.finalidade)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }

}
