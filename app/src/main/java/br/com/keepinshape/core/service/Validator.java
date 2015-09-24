package br.com.keepinshape.core.service;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

/**
 * Created by root on 24/09/15.
 */
public class Validator {

    //example of code https://nuvemandroid.wordpress.com/2013/12/13/validacao-de-campos-em-formularios/comment-page-1/


    public static boolean validateNotNull(View pView, String pMessage) {

        if (pView instanceof EditText) {
            EditText edText = (EditText) pView;
            Editable text = edText.getText();
            if (text != null) {
                String strText = text.toString();
                if (!TextUtils.isEmpty(strText)) {
                    return true;
                }
            }
            // em qualquer outra condição é gerado um erro
            edText.setError(pMessage);
            edText.setFocusable(true);
            edText.requestFocus();
            return false;
        }
        return false;
    }

    public static boolean validador(View view, int vetor[]) {

        EditText textValidator;
        boolean validacao = true;

        for (int i = 0; i < (vetor.length - 1); i++){
            textValidator = (EditText) view.findViewById(vetor[i]);
            Validator.validateNotNull(textValidator, "Campo Vázio");

            if(Validator.validateNotNull(textValidator, "Campo Vázio") == false){
                validacao = false;
            }

            textValidator.setText("");
        }

        return validacao;
    }

}
