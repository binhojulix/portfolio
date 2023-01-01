/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.web;

import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import br.com.lab.modelos.usuario.UsuarioRN;
import br.com.lab.modelos.usuario.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author fabio julio
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {

    private List<Usuario> usuarios;
    private Usuario usuario = new Usuario();

    private UsuarioRN getUsuarioRN() {
        UsuarioRN usuarioRN = new UsuarioRN();
        return usuarioRN;
    }

    public String salvar() {
        getUsuarioRN().salvar(this.usuario);
        this.usuario = new Usuario();
        FacesContext contexo = FacesContext.getCurrentInstance();
        contexo.addMessage(null, new FacesMessage("Usuário gravado com sucesso"));
        return "";
    }

    public List<Usuario> completar(String query) {
        List<Usuario> solicitantes = getUsuarioRN().listarUsuarios(query);
        return solicitantes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        this.usuarios = getUsuarioRN().listarUsuarios();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
