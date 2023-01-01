/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.lab.modelos.osm.OrdemServicoRN;
import br.com.lab.modelos.osm.OrdemServico;

/**
 *
 * @author fabiolu
 */
@FacesConverter(forClass = OrdemServico.class)
public class OrdemServicoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            OrdemServicoRN ordemServicoRN = new OrdemServicoRN();
            String osm = (String) value;
            OrdemServico ordemServico = ordemServicoRN.getOrdem(osm);
            return ordemServico;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        OrdemServico ordemServico = (OrdemServico) value;
        return ordemServico.getNumero();
    }

}
