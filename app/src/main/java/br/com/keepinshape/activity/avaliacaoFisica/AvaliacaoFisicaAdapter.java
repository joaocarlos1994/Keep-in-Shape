package br.com.keepinshape.activity.avaliacaoFisica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.AvaliacaoFisica;
import br.com.keepinshape.core.service.ConvertToTypes;

/**
 * Created by root on 12/02/16.
 */
public class AvaliacaoFisicaAdapter extends BaseAdapter {

    private Context context;
    private List<AvaliacaoFisica> avaliacaoFisicas;

    public AvaliacaoFisicaAdapter(Context context, List<AvaliacaoFisica> avaliacaoFisicas){
        this.context = context;
        this.avaliacaoFisicas = avaliacaoFisicas;
    }

    @Override
    public int getCount() {
        return avaliacaoFisicas.size();
    }

    @Override
    public Object getItem(int position) {
        return avaliacaoFisicas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicas.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.avaliacao_fisica, null);

        TextView dataAvaliacao = (TextView) layout.findViewById(R.id.txtViewAvaliacaoFisicaLista);
        dataAvaliacao.setText(ConvertToTypes.convertDateToString(avaliacaoFisica.getDateAvaliacao()));

        return layout;
    }
}
