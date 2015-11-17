package br.com.keepinshape.activity.exercicio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.sql.SQLException;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.helper.DatabaseHelperFactory;
import br.com.keepinshape.core.helper.ExercicioFactory;
import br.com.keepinshape.core.helper.db.DatabaseHelper;
import br.com.keepinshape.core.helper.facade.ExercicioFacadeFactory;
import br.com.keepinshape.core.impl.ExercicioDaoImpl;
import br.com.keepinshape.core.service.Validator;

public class ExercicioRegister extends Activity {

    private EditText nome, tempo, peso, quantidade, pontuacao;
    private ExercicioFactory exercicioFactory;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio_register);
        exercicioFactory = new ExercicioFactory();

    }

    public void handlerSaveExercicio(View view){

        layout = (RelativeLayout) findViewById(R.id.relative_layout_register_exercicio);

        int vetor [] = {R.id.txtNomeExercicio, R.id.txtTempoExercicio, R.id.txtExercicioPeso, R.id.txtExercicioQuantidade,
                        R.id.txtExercicioPontuacao};

        if (Validator.validador(layout, vetor) == true){


            nome = (EditText) findViewById(vetor[0]);
            tempo = (EditText) findViewById(vetor[1]);
            peso = (EditText) findViewById(vetor[2]);
            quantidade = (EditText) findViewById(vetor[3]);
            pontuacao = (EditText) findViewById(vetor[4]);

            Exercicio exercicio = exercicioFactory.exercicioFactory(nome.getText().toString(), Integer.parseInt(tempo.getText().toString()), Float.parseFloat(peso.getText().toString()),
                    Integer.parseInt(quantidade.getText().toString()), Double.parseDouble(pontuacao.getText().toString()));


            if(ExercicioFacadeFactory.getExercicioFacadeFactory().save(exercicio, this)){

                startActivity(new Intent(this, ExercicioList.class));

            } else {


                //Houve um erro

            }

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exercicio_register, menu);
        return true;
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
