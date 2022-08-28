package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

import model.Livro;

import java.util.List;

/**
 * Created by rm40246 on 26/11/2015.
 */
public class LivroDao {

    public static final String ID = "id";
    public static final String TITULO = "TITULO";
    public static final String AUTOR = "AUTOR";
    public static final String ISBN = "ISBN";
    public static final String DESCRICAO = "DESCRICAO";
    public static final String EDITORA = "EDITORA";

    private MeuBD meuBD;
    private SQLiteDatabase db;

    public LivroDao(Context context) {
        meuBD = new MeuBD(context);
    }


    public String salvar(Livro livro) {

        ContentValues valores = new ContentValues();
        valores.put(TITULO, livro.getTitulo());
        valores.put(AUTOR, livro.getAutor());
        valores.put(ISBN, livro.getISBN());
        valores.put(EDITORA, livro.getEditora());
        valores.put(DESCRICAO, livro.getDescricao());

        db = meuBD.getWritableDatabase();

        long resultado = db.insert(MeuBD.TABELA_LIVRO, null, valores);

        db.close();

        if (resultado == -1) {
            return "Erro ao cadastrar o Livro";
        } else {
            return "Livro cadastrado com sucesso";
        }
    }




    public Livro buscar(int id) {
        return null;
    }

    public List<Livro> getLivros() {
        List<Livro> livros = new ArrayList<>();
        Cursor cursor;
        db = meuBD.getReadableDatabase();
        cursor = db.query(MeuBD.TABELA_LIVRO, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();

            while (cursor.moveToNext()) {

                Livro livro = new Livro();
                livro.setId(cursor.getInt(cursor.getColumnIndex(ID)));
                livro.setAutor(cursor.getString(cursor.getColumnIndex(AUTOR)));
                livro.setDescricao(cursor.getString(cursor.getColumnIndex(DESCRICAO)));
                livro.setEditora(cursor.getString(cursor.getColumnIndex(EDITORA)));
                livro.setISBN(cursor.getString(cursor.getColumnIndex(ISBN)));
                livro.setTitulo(cursor.getString(cursor.getColumnIndex(TITULO)));

                livros.add(livro);
            }
        }

        db.close();

        return livros;
    }


}
