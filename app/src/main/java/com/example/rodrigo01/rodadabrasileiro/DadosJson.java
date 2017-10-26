package com.example.rodrigo01.rodadabrasileiro;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by rodrigo01 on 25/10/2017.
 */

public class DadosJson extends AsyncTask<String, String, String> {

    HttpURLConnection urlConnection;
    InputStreamReader in;
    BufferedReader reader;
    URL url;

    @Override
    protected String doInBackground(String... params) {

        int MAX_RETRIES = 5;
        StringBuilder result = new StringBuilder();
        char[] test = new char[2000];
        for (int i = 0; i < MAX_RETRIES; i++){
            Log.d ("tentativa num",""+i);

            try {

                url = new URL("https://api.cartolafc.globo.com/partidas");
                //url = new URL("http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoInput(true);

                in = new InputStreamReader(urlConnection.getInputStream());

                reader = new BufferedReader(in);


                String linha;
                while ((linha = reader.readLine()) != null) {
                    Log.d("linha lida:", linha);
                    result.append(linha);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
            Log.d("fim tentativa", "--+-------++++++++%%%%%%%%%%%%%%%%%%%%%");
        }
        Log.d("chegou ao fim", "--------------+-------++++++++");
        return result.toString();
    }

    protected void onPosExecute(String result){
        //do somethig with json

    }
}
