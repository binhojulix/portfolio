package crud.binho.com.br.crudapp;

import android.widget.EditText;
import android.widget.RatingBar;

import crud.binho.com.br.crudapp.FormularioActivity;
import crud.binho.com.br.crudapp.cerveja.Cerveja;

/**
 * Created by binho on 04/01/2016.
 */
public class FormularioHelper {

    private EditText nome;
    private EditText valor;
    private RatingBar nota;
    private Cerveja cerveja;

    public FormularioHelper(FormularioActivity activity) {
        nome = (EditText) activity.findViewById(R.id.edt_nome);
        valor = (EditText) activity.findViewById(R.id.edt_valor);
        nota = (RatingBar) activity.findViewById(R.id.rt_nota);
        cerveja = new Cerveja();
    }

    public Cerveja getCerveja() {
        cerveja.setNome(nome.getEditableText().toString());
        cerveja.setValor(Double.parseDouble(valor.getEditableText().toString()));
        cerveja.setFoto(null);
        cerveja.setNota(nota.getNumStars());
        return cerveja;
    }
}
