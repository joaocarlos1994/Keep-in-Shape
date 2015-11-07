package br.com.keepinshape.activity.treino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.activity.exercicio.ExercicioAdapter;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.service.ConvertToTypes;

/**
 * Created by root on 07/11/15.
 */
public class TreinoAdapterSpecification extends BaseAdapter {

    private Context context;
    private List<Treino> treinos;
    private View view;

    public TreinoAdapterSpecification(Context context, List<Treino> treino, View view){
        this.context = context;
        this.treinos = treino;
        this.view = view;
    }


    @Override
    public int getCount() {
        return treinos.size();
    }

    @Override
    public Object getItem(int position) {
        return treinos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Treino treino = treinos.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.treino_specification, null);

        TextView nome = (TextView) layout.findViewById(R.id.txtNomeTreino);
        nome.setText(treino.getNome());

        TextView semana = (TextView) layout.findViewById(R.id.txtTreinoSemana);
        semana.setText(treino.getDiaSemana());

        TextView tipo = (TextView) layout.findViewById(R.id.txtTreinoTipo);
        tipo.setText(treino.getTipo());

        TextView pontosTotal = (TextView) layout.findViewById(R.id.txtTreinosPontosTotal);
        pontosTotal.setText(ConvertToTypes.convertDoubleToString(treino.getPontosTotal()));

        TextView pontosMaximo = (TextView) layout.findViewById(R.id.txtTreinosPontosMaximo);
        pontosMaximo.setText(ConvertToTypes.convertDoubleToString(treino.getPontosMaximo()));

        ListView listView = (ListView) view.findViewById(R.id.treinoListCadastroExercicio);

        listView.setAdapter(new ExercicioAdapter(context, (List <Exercicio>)treino.getListaExercicios()));


        return layout;
    }
}
