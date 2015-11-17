package br.com.keepinshape.activity.exercicio;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.helper.DatabaseHelperFactory;
import br.com.keepinshape.core.helper.ExercicioFactory;
import br.com.keepinshape.core.helper.facade.ExercicioFacadeFactory;
import br.com.keepinshape.core.impl.ExercicioDaoImpl;

public class ExercicioList extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio_list);


        listaExercicios();


    }


    public void listaExercicios(){

        ListView listView = (ListView) findViewById(R.id.listViewExercicio);
        listView.setAdapter(new ExercicioAdapter(this, ExercicioFacadeFactory.getExercicioFacadeFactory().findAll(this)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exercicio_list, menu);
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
