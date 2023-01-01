/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.material;

import java.util.Objects;

/**
 *
 * @author fabio julio
 */
public class Material {

    private String codigoMaterial;
    private String codigoCPTM;
    private String descricao;
    private String gaveta;
    private Double estoque;
    private String sistema;
    private String unidade;
    private String setor;

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public String getCodigoCPTM() {
        return codigoCPTM;
    }

    public void setCodigoCPTM(String codigoCPTM) {
        this.codigoCPTM = codigoCPTM;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGaveta() {
        return gaveta;
    }

    public void setGaveta(String gaveta) {
        this.gaveta = gaveta;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.codigoMaterial);
        hash = 71 * hash + Objects.hashCode(this.codigoCPTM);
        hash = 71 * hash + Objects.hashCode(this.descricao);
        hash = 71 * hash + Objects.hashCode(this.gaveta);
        hash = 71 * hash + Objects.hashCode(this.estoque);
        hash = 71 * hash + Objects.hashCode(this.sistema);
        hash = 71 * hash + Objects.hashCode(this.unidade);
        hash = 71 * hash + Objects.hashCode(this.setor);
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
        final Material other = (Material) obj;
        if (!Objects.equals(this.codigoMaterial, other.codigoMaterial)) {
            return false;
        }
        if (!Objects.equals(this.codigoCPTM, other.codigoCPTM)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.gaveta, other.gaveta)) {
            return false;
        }
        if (!Objects.equals(this.estoque, other.estoque)) {
            return false;
        }
        if (!Objects.equals(this.sistema, other.sistema)) {
            return false;
        }
        if (!Objects.equals(this.unidade, other.unidade)) {
            return false;
        }
        if (!Objects.equals(this.setor, other.setor)) {
            return false;
        }
        return true;
    }

}
