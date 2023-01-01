package crud.binho.com.br.crudapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import crud.binho.com.br.crudapp.cerveja.Cerveja;

public class MainActivity extends AppCompatActivity {

    ListView listaDeCervejas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Cerveja> cervejas = Arrays.asList(
                new Cerveja("itaipava", 7, "itapiava"),
                new Cerveja("brahma", 7, "itapiava"),
                new Cerveja("skol", 7, "itapiava"),
                new Cerveja("heineken", 7, "itapiava"),
                new Cerveja("sol", 7, "itapiava"),
                new Cerveja("serra malte", 7, "itapiava"),
                new Cerveja("budwiser", 7, "itapiava"),
                new Cerveja("antartica", 7, "itapiava"));

        listaDeCervejas = (ListView) findViewById(R.id.lista_de_cervejas);
        CervejaAdapter adapter = new CervejaAdapter(cervejas, this);
        listaDeCervejas.setAdapter(adapter);

        listaDeCervejas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
                Toast.makeText(MainActivity.this, "Meu texto de aviso", Toast.LENGTH_SHORT).show();
            }
        });


        listaDeCervejas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click longo", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        registerForContextMenu(listaDeCervejas);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("Remover");
        menu.add("Editar");
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
                Intent novo= new Intent(this, FormularioActivity.class);
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
