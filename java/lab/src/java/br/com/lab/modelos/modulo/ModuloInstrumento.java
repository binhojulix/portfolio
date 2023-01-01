/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.modulo;

import br.com.lab.modelos.tabela.Tabela;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author fabio julio
 */
public class ModuloInstrumento {

    private Integer modulo;
    private Tabela instrumento;
    private Date tempoUtilizacao;

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

    public Tabela getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Tabela instrumento) {
        this.instrumento = instrumento;
    }

    public Date getTempoUtilizacao() {
        return tempoUtilizacao;
    }

    public void setTempoUtilizacao(Date tempoUtilizacao) {
        this.tempoUtilizacao = tempoUtilizacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.modulo);
        hash = 47 * hash + Objects.hashCode(this.instrumento);
        hash = 47 * hash + Objects.hashCode(this.tempoUtilizacao);
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
        final ModuloInstrumento other = (ModuloInstrumento) obj;
        if (!Objects.equals(this.modulo, other.modulo)) {
            return false;
        }
        if (!Objects.equals(this.instrumento, other.instrumento)) {
            return false;
        }
        if (!Objects.equals(this.tempoUtilizacao, other.tempoUtilizacao)) {
            return false;
        }
        return true;
    }

}
