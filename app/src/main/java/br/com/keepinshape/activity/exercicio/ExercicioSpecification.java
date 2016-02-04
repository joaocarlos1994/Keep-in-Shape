package br.com.keepinshape.activity.exercicio;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.helper.facade.ExercicioFacadeFactory;

public class ExercicioSpecification extends Activity {

    private List<Exercicio> listaExercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio_specification);

        Bundle idExercicio = getIntent().getExtras();
        int id = (int) idExercicio.get("idExercicio");


        listaExercicios = new ArrayList<Exercicio>();
        listaExercicios.add(ExercicioFacadeFactory.getExercicioFacadeFactory().findById(id, this));


        ListView listView = (ListView) findViewById(R.id.listViewExercicioSpecification);
        listView.setAdapter(new ExercicioAdapterSpecification(this, listaExercicios));


    }


    public void handlerDeleteExercicio(View view){

        Bundle idExercicio = getIntent().getExtras();
        int id = (int) idExercicio.get("idExercicio");

        Exercicio exercicio = ExercicioFacadeFactory.getExercicioFacadeFactory().findById(id, this);
        ExercicioFacadeFactory.getExercicioFacadeFactory().remove(exercicio, this);

        startActivity(new Intent(this, ExercicioList.class));

    }

    public void handlerEditExercicio(View view){

        Bundle idExercicio = getIntent().getExtras();
        int id = (int) idExercicio.get("idExercicio");

        Intent intent = new Intent(this, ExercicioRegister.class);
        intent.putExtra("idExercicio", id);
        startActivity(intent);

    }

}
