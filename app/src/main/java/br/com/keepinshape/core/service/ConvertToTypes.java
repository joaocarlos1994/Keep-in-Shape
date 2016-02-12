package br.com.keepinshape.core.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 24/09/15.
 */
public class ConvertToTypes {

    public static String convertIntToString(int value){
        String valor = Integer.toString(value);
        return valor;
    }

    public static String convertFloatToString(float value){
        String valor = Float.toString(value);
        return valor;
    }

    public static String convertDoubleToString(double value){
        String valor = Double.toString(value);
        return valor;
    }

    public static String convertDateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String data = format.format(date);
        return data;
    }

}
