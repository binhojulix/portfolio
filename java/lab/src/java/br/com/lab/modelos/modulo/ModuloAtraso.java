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
public class ModuloAtraso {

    private Integer modulo;
    private Tabela atraso;
    private String tipo;
    private String codigoAtraso;

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

    public Tabela getAtraso() {
        return atraso;
    }

    public void setAtraso(Tabela atraso) {
        this.atraso = atraso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoAtraso() {
        return codigoAtraso;
    }

    public void setCodigoAtraso(String codigoAtraso) {
        this.codigoAtraso = codigoAtraso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.modulo);
        hash = 11 * hash + Objects.hashCode(this.atraso);
        hash = 11 * hash + Objects.hashCode(this.tipo);
        hash = 11 * hash + Objects.hashCode(this.codigoAtraso);
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
        final ModuloAtraso other = (ModuloAtraso) obj;
        if (!Objects.equals(this.modulo, other.modulo)) {
            return false;
        }
        if (!Objects.equals(this.atraso, other.atraso)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.codigoAtraso, other.codigoAtraso)) {
            return false;
        }
        return true;
    }
}
