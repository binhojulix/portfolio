package com.example.rm40246.demolivraria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import adapter.LivrosAdapter;
import dao.LivroDao;
import model.Livro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ListActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        LivroDao crud = new LivroDao(this);

        Livro livro = new Livro();

        livro.setTitulo("titulo 1");

        Livro livro2 = new Livro();

        livro2.setTitulo("titulo 1");

        Livro livro3 = new Livro();

        livro3.setTitulo("titulo 1");
        List<Livro> livrosInserir = Arrays.asList(livro, livro2, livro3);

        for(Livro l:livrosInserir){
            crud.salvar(l);
        }
/*

        listView = (ListView) findViewById(R.id.lvLivros);
        List<Livro> livros = new LivroDao(this).getLivros();
        listView.setAdapter(new LivrosAdapter(livros, this));
*/
    }
}
