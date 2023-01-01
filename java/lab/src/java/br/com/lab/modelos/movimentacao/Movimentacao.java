/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.movimentacao;

import br.com.lab.modelos.material.Material;
import br.com.lab.modelos.usuario.Usuario;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author fabiolu
 */
public class Movimentacao {

    private Integer numero;
    private Date dataMovimentacao;
    private String documento;
    private String tipo;
    private Double quantidade;
    private Material material;
    private Usuario requisitante;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Usuario getRequisitante() {
        return requisitante;
    }

    public void setRequisitante(Usuario requisitante) {
        this.requisitante = requisitante;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.numero);
        hash = 47 * hash + Objects.hashCode(this.dataMovimentacao);
        hash = 47 * hash + Objects.hashCode(this.documento);
        hash = 47 * hash + Objects.hashCode(this.tipo);
        hash = 47 * hash + Objects.hashCode(this.quantidade);
        hash = 47 * hash + Objects.hashCode(this.material);
        hash = 47 * hash + Objects.hashCode(this.requisitante);
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
        final Movimentacao other = (Movimentacao) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.dataMovimentacao, other.dataMovimentacao)) {
            return false;
        }
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.requisitante, other.requisitante)) {
            return false;
        }
        return true;
    }

}
