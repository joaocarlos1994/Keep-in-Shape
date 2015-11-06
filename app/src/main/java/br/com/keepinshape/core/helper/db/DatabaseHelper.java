package br.com.keepinshape.core.helper.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.keepinshape.api.entity.Agenda;
import br.com.keepinshape.api.entity.Alimento;
import br.com.keepinshape.api.entity.Dieta;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.api.entity.Treino;

/**
 * Created by Joao on 18/08/2015.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String BD_NAME = "KEEP_IN_SHAPE";
    private static final int BD_VERSION = 2;

    public DatabaseHelper(Context ctx){
        super(ctx, DatabaseHelper.BD_NAME, null, DatabaseHelper.BD_VERSION); //Atencao: Construtor apenas adicionado para parar de dar erro.
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource cs) {

        try {

            TableUtils.createTable(cs, Agenda.class);
            TableUtils.createTable(cs, Alimento.class);
            TableUtils.createTable(cs, Dieta.class);
            TableUtils.createTable(cs, Exercicio.class);
            TableUtils.createTable(cs, Pessoa.class);
            TableUtils.createTable(cs, Treino.class);

        } catch (SQLException ex){

            Log.d("DatabaseHelper Erro: ", ex.toString());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sd, ConnectionSource cs, int oldVersion, int newVersion) {

        try {

            TableUtils.dropTable(cs, Agenda.class, true); //ultimo parametro serve para ignorar os erros.
            TableUtils.dropTable(cs, Alimento.class, true); //ultimo parametro serve para ignorar os erros.
            TableUtils.dropTable(cs, Dieta.class, true); //ultimo parametro serve para ignorar os erros.
            TableUtils.dropTable(cs, Exercicio.class, true); //ultimo parametro serve para ignorar os erros.
            TableUtils.dropTable(cs, Pessoa.class, true); //ultimo parametro serve para ignorar os erros.
            TableUtils.dropTable(cs, Treino.class, true); //ultimo parametro serve para ignorar os erros.

            onCreate(sd, cs); //Criando as tabelas novamente.

        } catch (SQLException ex){

            ex.printStackTrace();
        }

    }

    @Override
    public void close(){
        super.close();
    }

}
