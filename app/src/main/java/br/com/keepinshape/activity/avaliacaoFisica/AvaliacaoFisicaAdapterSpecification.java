package br.com.keepinshape.activity.avaliacaoFisica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.AvaliacaoFisica;
import br.com.keepinshape.core.service.ConvertToTypes;

/**
 * Created by root on 13/02/16.
 */
public class AvaliacaoFisicaAdapterSpecification extends AvaliacaoFisicaAdapter {


    public AvaliacaoFisicaAdapterSpecification(Context context, List<AvaliacaoFisica> avaliacaoFisicas) {
        super(context, avaliacaoFisicas);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AvaliacaoFisica avaliacaoFisica = (AvaliacaoFisica) getItem(position);
        LayoutInflater inflater = (LayoutInflater) super.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.avaliacao_fisica_specification, null);

        TextView peso = (TextView) layout.findViewById(R.id.txtAvaFisiSpecificationPeso);
        peso.setText(ConvertToTypes.convertDoubleToString(avaliacaoFisica.getPeso()));

        TextView altura = (TextView) layout.findViewById(R.id.txtAvaFisiSpecificationAltura);
        altura.setText(ConvertToTypes.convertDoubleToString(avaliacaoFisica.getAltura()));

        TextView idade = (TextView) layout.findViewById(R.id.txtAvaFisiSpecificationIdade);
        idade.setText(ConvertToTypes.convertIntToString(avaliacaoFisica.getIdade()));

        TextView cintura = (TextView) layout.findViewById(R.id.txtAvaFisiSpecificationCintura);
        cintura.setText(ConvertToTypes.convertDoubleToString(avaliacaoFisica.getCintura()));

        TextView quadril = (TextView) layout.findViewById(R.id.txtAvaFisiSpecificationQuadril);
        quadril.setText(ConvertToTypes.convertDoubleToString(avaliacaoFisica.getQuadril()));

        return layout;
    }
}
