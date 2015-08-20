package br.com.keepinshape.core.helper.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    private static final int BD_VERSION = 1;

    public DatabaseHelper(Context ctx){
        super(ctx, DatabaseHelper.BD_NAME, null, DatabaseHelper.BD_VERSION); //Atenção: Construtor apenas adicionado para parar de dar erro.
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

            ex.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource cs, int oldVersion, int newVersion) {

        try {

            TableUtils.dropTable(cs, Agenda.class, true);
            TableUtils.dropTable(cs, Alimento.class, true);
            TableUtils.dropTable(cs, Dieta.class, true);
            TableUtils.dropTable(cs, Exercicio.class, true);
            TableUtils.dropTable(cs, Pessoa.class, true);
            TableUtils.dropTable(cs, Treino.class, true);

        } catch (SQLException ex){

            ex.printStackTrace();
        }

    }

    @Override
    public void close(){
        super.close();
    }

}
