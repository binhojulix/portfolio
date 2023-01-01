package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.rm40246.demolivraria.R;

import model.Livro;

import java.util.List;

/**
 * Created by rm40246 on 26/11/2015.
 */
public class LivrosAdapter extends BaseAdapter {

    private List<Livro> livros;
    private Context context;

    public LivrosAdapter(List<Livro> livros, Context context) {
        this.livros = livros;
        this.context = context;
    }

    @Override
    public int getCount() {
        return livros.size();
    }

    @Override
    public Object getItem(int position) {
        return livros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return livros.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {

            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_livro, parent, false);
            holder.tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitulo.setText(livros.get(position).getTitulo());


        return convertView;
    }

    private class ViewHolder {
        protected TextView tvTitulo;
    }
}
