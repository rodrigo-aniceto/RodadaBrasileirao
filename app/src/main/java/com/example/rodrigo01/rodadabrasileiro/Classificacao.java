package com.example.rodrigo01.rodadabrasileiro;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Classificacao extends AppCompatActivity {

    boolean setaCima = true;
    Button setaOrdem;

    Context _context;
    ProgressDialog mBar;

    ListView lista_clubes;

    ArrayList<Time> lista_sessao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classificacao);

        setaOrdem = (Button) findViewById(R.id.botaoOrdem);

        lista_clubes = (ListView) findViewById(R.id.lista_clubes);
        lista_sessao = new DadosSalvos().getLista_times_reduzida();

        lista_clubes.setAdapter(new customAdapter(lista_sessao, Classificacao.this));

    }

    public void mudarOrdem(View view) {

        if (setaCima == true) {
            setaCima = false;
            setaOrdem.setBackgroundResource(R.drawable.downarrow);
            Collections.sort(lista_sessao);
            lista_clubes.setAdapter(new customAdapter(lista_sessao, Classificacao.this));
            Log.d("lista em ordem", "----");
        } else if (setaCima == false) {
            setaCima = true;
            setaOrdem.setBackgroundResource(R.drawable.uparrow);
            Collections.reverse(lista_sessao);
            lista_clubes.setAdapter(new customAdapter(lista_sessao, Classificacao.this));
            Log.d("lista revertida", "----");
        }

    }

    public class customAdapter extends BaseAdapter {
        Context mContext;
        //private int[] colors = new int[]{0xD1D4E8,0xBBBED2};
        LayoutInflater inflator = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ArrayList<Time> list;

        public customAdapter(ArrayList<Time> list, Context mContext) {

            for (Time time : list) {
                Log.d("time:", time.getNome());
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
            if (convertView == null) {
                convertView = inflator.inflate(R.layout.layout_lista, root, false);
                holder = new userHolder();
                holder.nome = (TextView) convertView.findViewById(R.id.nom_time);
                holder.pos = (TextView) convertView.findViewById(R.id.pos_time);
                holder.escudo = (ImageView) convertView.findViewById(R.id.img_time);

                convertView.setTag(holder);
            } else {
                holder = (userHolder) convertView.getTag();
            }

            holder.nome.setText(list.get(position).getNome());

            holder.pos.setText(Integer.toString(list.get(position).getPosicao()));

            try {
                InputStream is = mContext.getAssets().open(list.get(position).getEscudo());
                Drawable drawable = Drawable.createFromStream(is, null);
                holder.escudo.setImageDrawable(drawable);

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
                holder.escudo.setImageDrawable(drawable);
            }

            return convertView;
        }
        class userHolder {
            TextView nome;
            TextView pos;
            ImageView escudo;
        }
    }
}