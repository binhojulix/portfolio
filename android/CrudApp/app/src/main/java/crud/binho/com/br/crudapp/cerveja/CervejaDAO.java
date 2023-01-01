package crud.binho.com.br.crudapp.cerveja;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

/**
 * Created by binho on 26/12/2015.
 */
public class CervejaDAO {
    CervejaDBHelper helper;

    public CervejaDAO(Context context) {
        helper = new CervejaDBHelper(context);
    }


    public long criar(Cerveja beer) {
        ContentValues values = new ContentValues();
        values.put(CervejaDBHelper.COLUMN_NAME_NOME, beer.getNome());
        values.put(CervejaDBHelper.COLUMN_NAME_IMAGEM, beer.getFoto());
        values.put(CervejaDBHelper.COLUMN_NAME_NOTA, beer.getNota());

        long newRowId = helper.getWritableDatabase().insert(CervejaDBHelper.TABLE_NAME, null, values);
        return newRowId;
    }


    public long atualizar(Cerveja beer) {
        ContentValues values = new ContentValues();
        values.put(CervejaDBHelper.COLUMN_NAME_NOME, beer.getNome());
        values.put(CervejaDBHelper.COLUMN_NAME_IMAGEM, beer.getFoto());
        values.put(CervejaDBHelper.COLUMN_NAME_NOTA, beer.getNota());

        long newRowId = helper.getWritableDatabase().update(CervejaDBHelper.TABLE_NAME, values,
                CervejaDBHelper.COLUMN_NAME_BEER_ID + "=?", new String[]{beer.getId().toString()});
        return newRowId;
    }


    public void deletar(int id) {

    }


    public Cerveja buscar(int id) {
        return null;
    }


    public List<Cerveja> listar(int inicio, int porPage) {
        return null;
    }


    public List<Cerveja> listar(String coluna, String busca, int inicio, int porPage) {
        return null;
    }
}
