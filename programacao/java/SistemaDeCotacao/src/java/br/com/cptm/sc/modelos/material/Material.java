/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cptm.sc.modelos.material;



import br.com.cptm.sc.modelos.usuario.Usuario;
import java.util.Date;

/**
 *
 * @author fabiolu
 */
public class Material {

    private long id;
    private String codigoCPTM;
    private String descricao;
    private String osm;
    private double quantidade;
    private String tipo;
    private String status;
    private Usuario usuario;
    private Date dataSolicitacao;

    public Material() {
    }

    public Material(long id, String codigoCPTM, String descricao, String osm, double quantidade, String tipo, String status) {
        this.id = id;
        this.codigoCPTM = codigoCPTM;
        this.descricao = descricao;
        this.osm = osm;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getOsm() {
        return osm;
    }

    public void setOsm(String osm) {
        this.osm = osm;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

}
