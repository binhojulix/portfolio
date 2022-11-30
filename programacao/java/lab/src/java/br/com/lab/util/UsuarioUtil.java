/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import br.com.lab.modelos.usuario.UsuarioRN;
import br.com.lab.modelos.usuario.Usuario;

/**
 *
 * @author fabiolu
 */
public class UsuarioUtil {

    private Usuario usuario;

    public Usuario getUsuario() {
        UsuarioRN usuarioRN = new UsuarioRN();
        this.usuario = usuarioRN.buscarPorLogin(getLogin());
        return usuario;

    }

    private String getLogin() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        String login = ec.getUserPrincipal().getName();
        return login;

    }
}
