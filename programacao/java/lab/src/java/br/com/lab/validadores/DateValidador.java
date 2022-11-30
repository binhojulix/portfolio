/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;
import javax.faces.validator.FacesValidator;

/**
 *
 * @author fabio julio
 */
@FacesValidator("data-atual")
public class DateValidador implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value != null) {
            Date data = (Date) value;
            Date dataAtual = new Date();
            if (data.getTime() > dataAtual.getTime()) {
                ((UIInput) component).setValid(false);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data maior que a data atual", "");
                context.addMessage(component.getClientId(context), message);
            }
        }
    }
}

