/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.lab.modelos.tabela.TabelaRN;
import br.com.lab.modelos.tabela.Tabela;

/**
 *
 * @author fabio julio
 */
@FacesConverter(forClass = Tabela.class)
public class TabelaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            String codigo = (String) value;
            String id = (String) component.getId();
            TabelaRN tabelaRN = new TabelaRN();
            Tabela tabela = tabelaRN.getTabela(codigo, tabelaRN.returnId(id));
            return tabela;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Tabela tabela = (Tabela) value;
        return tabela.getCodigo();
    }
}
