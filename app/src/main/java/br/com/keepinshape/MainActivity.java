package br.com.keepinshape;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.helper.ExercicioFactory;
import br.com.keepinshape.core.helper.PessoaFactory;
import br.com.keepinshape.core.helper.TreinoFactory;
import br.com.keepinshape.core.helper.db.DatabaseHelper;
import br.com.keepinshape.core.impl.ExercicioDaoImpl;
import br.com.keepinshape.core.impl.TreinoDaoImpl;

public class MainActivity extends ActionBarActivity {

    private DatabaseHelper databaseHelper;
    private TreinoFactory treinoFactory = new TreinoFactory();
    private ExercicioFactory exercicioFactory = new ExercicioFactory();
    private Collection<Exercicio> listaExercicio = new ArrayList<Exercicio>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        try {
            ExercicioDaoImpl exerciciosImpl = new ExercicioDaoImpl(databaseHelper.getConnectionSource());
            TreinoDaoImpl treinoImpl = new TreinoDaoImpl(databaseHelper.getConnectionSource());
            Exercicio exercicio =  exercicioFactory.exercicioFactory("Supino", 30, 50, 3, 10);

            exerciciosImpl.create(exercicio);

            listaExercicio.add(exercicio);
            Treino treino = treinoFactory.treinoFactory("Treino A", "Costas", new Date(),listaExercicio, 100, 100);

            treinoImpl.create(treino);


            Log.d("Usuario cadastrado:", treinoImpl.queryForId(1).getNome());

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

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
