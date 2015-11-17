package br.com.keepinshape.activity.treino;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.activity.exercicio.ExercicioAdapter;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.helper.DatabaseHelperFactory;
import br.com.keepinshape.core.helper.ExercicioFactory;
import br.com.keepinshape.core.helper.TreinoFactory;
import br.com.keepinshape.core.helper.facade.ExercicioFacadeFactory;
import br.com.keepinshape.core.helper.facade.TreinoFacadeFactory;
import br.com.keepinshape.core.impl.ExercicioDaoImpl;
import br.com.keepinshape.core.impl.TreinoDaoImpl;
import br.com.keepinshape.core.service.Validator;

public class TreinoRegister extends ActionBarActivity {

    private EditText edtTreino, edtTipoTreino, edtSemana, edtPtnTotal, edtPtnMaximo;
    private List<Exercicio> exercicios;
    private List<Exercicio> exerciciosSelecionados = new ArrayList<Exercicio>();
    private ExercicioAdapter exercicioAdapter;
    private Spinner sp;
    private TreinoFactory treinoFactory;
    private TreinoDaoImpl treinoDaoImpl;
    private RelativeLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_register);

        treinoFactory = new TreinoFactory();

        loadAllExerciseSpinner();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_treino_register, menu);
        return true;
    }

    public void loadAllExerciseSpinner (){

        exercicioAdapter = new ExercicioAdapter(this, ExercicioFacadeFactory.getExercicioFacadeFactory().findAll(this));
        sp = (Spinner) findViewById(R.id.spinnerExercicio);
        sp.setAdapter(exercicioAdapter);



        ArrayAdapter<Exercicio> dataAdapter = new ArrayAdapter<Exercicio>(this,
                android.R.layout.simple_spinner_item, exercicios);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


    }

    public void handlerTreinoAddExercicio(View view) {

        sp = (Spinner) findViewById(R.id.spinnerExercicio);
        Exercicio exercicio = (Exercicio) sp.getSelectedItem();
        exerciciosSelecionados.add(exercicio);


        GridView gridView = (GridView) findViewById(R.id.gridViewExercicioCadastrados);
        final ExercicioAdapter exercicioAdapter = new ExercicioAdapter(this, exerciciosSelecionados);
        gridView.setAdapter(exercicioAdapter);

        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Exercicio exercicio = (Exercicio) exercicioAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void handlerSalvarTreino(View view) {

        layout = (RelativeLayout) findViewById(R.id.relative_layout_register_treino);

        int vetor [] = {R.id.editTextNomeTreino, R.id.editTreinotTipo, R.id.editTextDiaSemana,
                        R.id.editTextPontosTotal, R.id.editTextPontosMaximo};

        if(Validator.validador(layout, vetor) == true){

            edtTreino = (EditText) findViewById(vetor[0]);
            edtTipoTreino = (EditText) findViewById(vetor[1]);
            edtSemana = (EditText) findViewById(vetor[2]);
            edtPtnTotal = (EditText) findViewById(vetor[3]);
            edtPtnMaximo = (EditText) findViewById(vetor[4]);

            Treino treino = treinoFactory.treinoFactory(edtTreino.getText().toString(), edtTipoTreino.getText().toString(), "Segunda",
                                        exerciciosSelecionados, Double.parseDouble(edtPtnTotal.getText().toString()),
                                        Double.parseDouble(edtPtnMaximo.getText().toString()));


            if(TreinoFacadeFactory.getInstanceTreinoFacade().save(treino, this)){

                startActivity(new Intent(this, TreinoList.class));

            } else {

                Log.d("Erro: , Tipo: ", "Falha ao adicionar Treino");

            }


        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
