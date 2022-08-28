package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import model.Livro;

/**
 * Created by rm40246 on 26/11/2015.
 */
public class MeuBD extends SQLiteOpenHelper {

    public static final String TABELA_LIVRO = "LIVRO";
    public static final String NOME_BANCO = "livraria.db";
    public static final int VERSAO_BANCO = 1;


    public MeuBD(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = createBD();
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_LIVRO);
        onCreate(db);
    }

    private String createBD() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE ");
        sql.append(TABELA_LIVRO);
        sql.append(" (");
        sql.append(LivroDao.ID);
        sql.append(" integer primary key autoincrement, ");
        sql.append(LivroDao.TITULO);
        sql.append(" text, ");
        sql.append(LivroDao.AUTOR);
        sql.append(" text, ");
        sql.append(LivroDao.ISBN);
        sql.append(" text, ");
        sql.append(LivroDao.EDITORA);
        sql.append(" text, ");
        sql.append(LivroDao.DESCRICAO);
        sql.append(" text)");

        return toString();
    }


}
