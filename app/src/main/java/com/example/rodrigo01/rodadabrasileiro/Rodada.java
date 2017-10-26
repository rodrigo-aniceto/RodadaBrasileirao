package com.example.rodrigo01.rodadabrasileiro;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import static com.example.rodrigo01.rodadabrasileiro.R.id.lista_clubes;
import static com.example.rodrigo01.rodadabrasileiro.R.id.nom_time1;

public class Rodada extends AppCompatActivity {

    ListView lista_partidas;

    ArrayList<Time> lista_sessaoTimes;
    ArrayList<Partida> lista_sessaoPartidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodada);

        lista_partidas = (ListView) findViewById(R.id.lista_partidas);
        lista_sessaoPartidas = new DadosSalvos().getLista_partidas();
        lista_sessaoTimes = new DadosSalvos().getLista_times();
        lista_partidas.setAdapter(new customAdapter(lista_sessaoPartidas, Rodada.this));

    }


    public class customAdapter extends BaseAdapter {
        Context mContext;
        //private int[] colors = new int[]{0xD1D4E8,0xBBBED2};
        LayoutInflater inflator = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ArrayList<Partida> list;

        public customAdapter(ArrayList<Partida> list, Context mContext) {

            for (Partida partida : list) {
                Log.d("partida em:", partida.getLocal());
            }
            this.mContext = mContext;
            this.list = list;
            this.notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup root) {
            userHolder holder = null;

            if (convertView == null){
                convertView = inflator.inflate(R.layout.layout_agenda, root, false);
                holder = new userHolder();

                holder.nome1 = (TextView)convertView.findViewById(R.id.nom_time1);
                holder.gols1 = (TextView)convertView.findViewById(R.id.placar_time1);
                holder.nome2 = (TextView)convertView.findViewById(R.id.nom_time2);
                holder.gols2 = (TextView)convertView.findViewById(R.id.placar_time2);
                holder.escudo1 = (ImageView)convertView.findViewById(R.id.img_time1);
                holder.escudo2 = (ImageView)convertView.findViewById(R.id.img_time2);
                holder.dataHora = (TextView)convertView.findViewById(R.id.data_hora);
                holder.local = (TextView)convertView.findViewById(R.id.local);

                convertView.setTag(holder);
            }
            else {
                holder = (userHolder)convertView.getTag();
            }

            int aux;
            String sigla1 = null, sigla2 = null, escudo1 = null, escudo2 = null;
            for (Time time : lista_sessaoTimes){
                if (time.getId() == list.get(position).getClube_casa_id()){
                    sigla1 = time.getAbrev();
                    escudo1 = time.getEscudo();
                }
                else if (time.getId() == list.get(position).getClube_visitante_id()){
                    sigla2 = time.getAbrev();
                    escudo2 = time.getEscudo();
                }
            }

            holder.nome1.setText(sigla1);
            holder.nome2.setText(sigla2);

            aux = list.get(position).getPlacar_oficial_mandante();
            if (aux == -1){
                holder.gols1.setText(" ");
                holder.gols2.setText(" ");
            }
            else {
                holder.gols1.setText(Integer.toString(list.get(position).getPlacar_oficial_mandante()));
                holder.gols2.setText(Integer.toString(list.get(position).getPlacar_oficial_visitante()));
            }
            holder.dataHora.setText(formatData(list.get(position).getPartida_data()));
            holder.local.setText(list.get(position).getLocal());


            Log.d("dados:","nome1: "+sigla1+" nome2: "+sigla2+" datahora: "+formatData(list.get(position).getPartida_data())+" escudos: "+escudo1+""+escudo2);

            try {
                InputStream is = mContext.getAssets().open(escudo1);
                Drawable drawable = Drawable.createFromStream(is, null);
                holder.escudo1.setImageDrawable(drawable);

            } catch (Exception e) {
                e.printStackTrace();
                Log.e("ERROR", "" + e);
                InputStream is = null;
                try {
                    is = mContext.getAssets().open("nope.png");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                Drawable drawable = Drawable.createFromStream(is, null);
                holder.escudo1.setImageDrawable(drawable);
            }

            try {
                InputStream is = mContext.getAssets().open(escudo2);
                Drawable drawable = Drawable.createFromStream(is, null);
                holder.escudo2.setImageDrawable(drawable);

            } catch (Exception e) {
                e.printStackTrace();
                Log.e("ERROR", "" + e);
                InputStream is = null;
                try {
                    is = mContext.getAssets().open("nope.png");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                Drawable drawable = Drawable.createFromStream(is, null);
                holder.escudo2.setImageDrawable(drawable);
            }



            return convertView;
        }

        public String formatData (String data_hora){
            String ano, mes, dia, hora, minuto, result;
            ano = data_hora.substring(2,4);
            mes = data_hora.substring(5,7);
            dia = data_hora.substring(8,10);
            hora = data_hora.substring(11,13);
            minuto = data_hora.substring(14,16);

            result = dia + "/" + mes + "/" + ano + " - " + hora + ":" + minuto +" - ";
            return result;
        }
    }
    class userHolder {
        TextView nome1;
        TextView gols1;
        TextView nome2;
        TextView gols2;
        ImageView escudo1;
        ImageView escudo2;
        TextView dataHora;
        TextView local;
    }
}