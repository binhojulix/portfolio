/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.lab.modelos.usuario.UsuarioRN;
import br.com.lab.modelos.usuario.Usuario;

/**
 *
 * @author fabio julio
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            UsuarioRN usuarioRN = new UsuarioRN();
            String matricula = value.trim();
            Usuario usuario = usuarioRN.buscarPorMatricula(matricula);
            return usuario;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Usuario usuario = (Usuario) value;
        return usuario.getMatricula();
    }
}
