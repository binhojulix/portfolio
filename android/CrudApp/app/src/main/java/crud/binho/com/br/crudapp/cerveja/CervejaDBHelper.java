package crud.binho.com.br.crudapp.cerveja;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by binho on 26/12/2015.
 */
public class CervejaDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MYDB.db";
    public static final String TABLE_NAME = "BEERD";
    public static final String COLUMN_NAME_BEER_ID = "ID";
    public static final String COLUMN_NAME_NOME = "NOME";
    public static final String COLUMN_NAME_IMAGEM = "FOTO";
    public static final String COLUMN_NAME_NOTA = "NOTA";

    public static final String SQL_CREATE_TABELA = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME_BEER_ID +
            " INTEGER PRIMARY KEY  AUTOINCREMENT, NOME TEXT, FOTO TEXT, NOTA INTEGER)";

    public static final String SQL_DELETE_TABELA = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public CervejaDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABELA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABELA);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
