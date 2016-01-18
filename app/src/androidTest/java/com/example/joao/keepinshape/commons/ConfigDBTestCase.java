package com.example.joao.keepinshape.commons;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import org.junit.After;
import org.junit.Before;

import br.com.keepinshape.core.helper.DatabaseHelperFactory;

/**
 * Created by root on 18/01/16.
 */
public abstract class ConfigDBTestCase extends AndroidTestCase {

    private static final String BD_TEST = "DATABASE_TEST";
    private RenamingDelegatingContext context = null;

    @Before
    public void setUp() throws Exception {

        context = new RenamingDelegatingContext(getContext(), BD_TEST);

        DatabaseHelperFactory.getIntanceConnection(context);

    }

    @After
    public void setDown() {
        DatabaseHelperFactory.getIntanceConnection(context).close();
    }



}
