package br.com.keepinshape.activity.exercicio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.service.ConvertToTypes;

/**
 * Created by root on 22/01/16.
 */
public class ExercicioAdapterSpecification extends BaseAdapter {

    private List<Exercicio> listaExercicios;
    private Context context;

    public ExercicioAdapterSpecification (Context context, List<Exercicio> listaExercicios){
        this.context = context;
        this.listaExercicios = listaExercicios;
    }


    @Override
    public int getCount() {
        return listaExercicios.size();
    }

    @Override
    public Object getItem(int position) {
        return listaExercicios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Exercicio exercicio = listaExercicios.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutExercicioSpecification = inflater.inflate(R.layout.exercicio_specification, null);

        TextView nome = (TextView) layoutExercicioSpecification.findViewById(R.id.txtViewExercicioNome);
        nome.setText(exercicio.getNome());

        TextView tempo = (TextView) layoutExercicioSpecification.findViewById(R.id.txtViewExercicioTempo);
        tempo.setText(ConvertToTypes.convertDoubleToString(exercicio.getTempo()));

        TextView peso = (TextView) layoutExercicioSpecification.findViewById(R.id.txtViewExercicioPeso);
        peso.setText(ConvertToTypes.convertDoubleToString(exercicio.getPeso()));

        TextView quantidade = (TextView) layoutExercicioSpecification.findViewById(R.id.txtViewExercicioQuantidade);
        quantidade.setText(ConvertToTypes.convertDoubleToString(exercicio.getQuantidade()));

        TextView pontuacao = (TextView) layoutExercicioSpecification.findViewById(R.id.txtViewExercicioPontuacao);
        pontuacao.setText(ConvertToTypes.convertDoubleToString(exercicio.getPontuacao()));

        return layoutExercicioSpecification;

    }
}
