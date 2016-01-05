package br.com.keepinshape;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.keepinshape.activity.exercicio.ExercicioList;
import br.com.keepinshape.activity.exercicio.ExercicioRegister;
import br.com.keepinshape.activity.treino.TreinoList;
import br.com.keepinshape.activity.treino.TreinoRegister;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.helper.DatabaseHelperFactory;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelperFactory.getIntanceConnection(MainActivity.this); //Criando o banco ou carregando conexões

    }

    public void handlerStartAcitivityExercicioList (View view){
        startActivity(new Intent(this, ExercicioList.class));
    }

    public void handlerStartAcitivityExercicioRegister (View view){
        startActivity(new Intent(this, ExercicioRegister.class));
    }

    public void handlerStartAcitivityTreinoList (View view){
        startActivity(new Intent(this, TreinoList.class));
    }

    public void handlerStartAcitivityTreinoRegister(View view){
        startActivity(new Intent(this, TreinoRegister.class));
    }



    //IMC, relação cintura quadril, dobras cuntania


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
