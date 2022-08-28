/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.lab.modelos.material.MaterialRN;
import br.com.lab.modelos.material.Material;

/**
 *
 * @author fabio julio
 */
@FacesConverter(forClass = Material.class)
public class MaterialConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            MaterialRN materialRN = new MaterialRN();
            String codigoMaterial = (String) value;
            Material material = materialRN.getMaterialPorCodigo(codigoMaterial);
            return material;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Material material = (Material) value;
        return material.getCodigoMaterial();
    }
}
