package crud.binho.com.br.crudapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import crud.binho.com.br.crudapp.cerveja.Cerveja;

/**
 * Created by binho on 26/12/2015.
 */
public class CervejaAdapter extends BaseAdapter {

    private List<Cerveja> beers;
    private Context context;

    public CervejaAdapter(List<Cerveja> beers, Context context) {
        this.beers = beers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return beers.size();
    }

    @Override
    public Object getItem(int position) {
        return beers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_beer, parent, false);

        }
        TextView tvNome = (TextView) convertView.findViewById(R.id.textView);

        tvNome.setText(beers.get(position).getNome());

        return convertView;
    }
}
