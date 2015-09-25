package br.com.keepinshape.activity.exercicio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.service.ConvertToTypes;

/**
 * Created by root on 24/09/15.
 */
public class ExercicioAdapter extends BaseAdapter {

    private Context context;
    private List<Exercicio> exercicios;

    public ExercicioAdapter(Context context, List<Exercicio> exercicios){
        this.context = context;
        this.exercicios = exercicios;
    }

    @Override
    public int getCount() {
        return exercicios.size();
    }

    @Override
    public Object getItem(int position) {
        return exercicios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Exercicio exercicio = exercicios.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.exercicio, null);

        TextView nome = (TextView) layout.findViewById(R.id.textViewNome);
        nome.setText("Nome: " + exercicio.getNome());

        TextView tempo = (TextView) layout.findViewById(R.id.textViewTempo);
        tempo.setText("Tempo: " + ConvertToTypes.convertIntToString(exercicio.getTempo()));

        TextView peso = (TextView) layout.findViewById(R.id.textViewPeso);
        peso.setText("Peso: " + ConvertToTypes.convertFloatToString(exercicio.getPeso()));

        TextView quantidade = (TextView) layout.findViewById(R.id.textViewQuantidade);
        quantidade.setText("Quantidade: " + ConvertToTypes.convertIntToString(exercicio.getQuantidade()));

        TextView pontuacao = (TextView) layout.findViewById(R.id.textViewPontuacao);
        pontuacao.setText("Pontuação: " + ConvertToTypes.convertDoubleToString(exercicio.getPontuacao()));

        return layout;

    }
}
