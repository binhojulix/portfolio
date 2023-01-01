/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.modulo;

import br.com.lab.modelos.movimentacao.Movimentacao;
import java.util.Objects;

/**
 *
 * @author fabio julio
 */
public class ModuloMovimentacao {

    private Integer modulo;
    private Movimentacao movimentacao;

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.modulo);
        hash = 47 * hash + Objects.hashCode(this.movimentacao);
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
        final ModuloMovimentacao other = (ModuloMovimentacao) obj;
        if (!Objects.equals(this.modulo, other.modulo)) {
            return false;
        }
        if (!Objects.equals(this.movimentacao, other.movimentacao)) {
            return false;
        }
        return true;
    }

}
