package com.example.rodrigo01.rodadabrasileiro;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Collections;

public class MenuPrincipal extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //new DadosJson().execute();

    }

    public void consultaClassificacao (View view) {
        Intent intent = new Intent(this, Classificacao.class);
        startActivity(intent);
    }

    public void consultaRodada (View view) {
        Intent intent = new Intent(this, Rodada.class);
        startActivity(intent);
    }
}
