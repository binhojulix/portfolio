package crud.binho.com.br.crudapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import crud.binho.com.br.crudapp.cerveja.Cerveja;
import crud.binho.com.br.crudapp.cerveja.CervejaDAO;
import crud.binho.com.br.crudapp.cerveja.CervejaDBHelper;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        Button button = (Button) findViewById(R.id.btn_salvar);
        final FormularioHelper helper = new FormularioHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cerveja c = helper.getCerveja();
                Toast.makeText(FormularioActivity.this, "Objeto aluno criado: " + c.getNome(),
                        Toast.LENGTH_SHORT).show();
                CervejaDAO cervejaDAO = new CervejaDAO(FormularioActivity.this);
                cervejaDAO.criar(c);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int option = item.getItemId();
        switch (option) {
            case R.id.menu_novo:
                Intent novo = new Intent(this, FormularioActivity.class);
                startActivity(novo);
                break;

            case R.id.menu_listar_cervejas:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
