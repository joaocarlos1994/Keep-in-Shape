package br.com.keepinshape.core.helper;

import android.content.Context;

import br.com.keepinshape.core.helper.db.DatabaseHelper;

/**
 * Created by root on 24/09/15.
 */
public class DatabaseHelperFactory {

    private static DatabaseHelper databaseHelper = null;

    public static DatabaseHelper getIntanceConnection(Context context) {
        if (databaseHelper == null){
            databaseHelper = new DatabaseHelper(context);
            return databaseHelper;
        }
        return databaseHelper;
    }

}
