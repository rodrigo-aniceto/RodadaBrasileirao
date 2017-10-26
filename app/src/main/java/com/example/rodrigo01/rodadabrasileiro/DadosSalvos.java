package com.example.rodrigo01.rodadabrasileiro;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rodrigo01 on 25/10/2017.
 */

public class DadosSalvos {

    private ArrayList<Partida> lista_partidas;
    private ArrayList<Time> lista_times;
    private ArrayList<Time> lista_times_reduzida;

    public DadosSalvos(){
        lista_partidas = new ArrayList<Partida>();

        lista_partidas.add(new Partida(211319, 263, 264, "2017-10-23 20:00:00", "Engenhão", -1, -1));
        lista_partidas.add(new Partida(211320, 267, 294, "2017-10-21 17:00:00", "Maracanã", 1, 1));
        lista_partidas.add(new Partida(211321, 277, 373, "2017-10-22 17:00:00", "Vila Belmiro", 1, 0));
        lista_partidas.add(new Partida(211322, 276, 262, "2017-10-22 17:00:00", "Pacaembu", 2, 0));
        lista_partidas.add(new Partida(211323, 283, 282, "2017-10-22 17:00:00", "Mineirão", 1, 3));
        lista_partidas.add(new Partida(211324, 293, 292, "2017-10-22 17:00:00", "Arena da Baixada", 2, 1));
        lista_partidas.add(new Partida(211325, 284, 275, "2017-10-22 17:00:00", "Arena do Grêmio", 1, 3));
        lista_partidas.add(new Partida(211326, 265, 287, "2017-10-22 17:00:00", "Fonte Nova", 2, 1));
        lista_partidas.add(new Partida(211327, 303, 314, "2017-10-22 19:00:00", "Moisés Lucarelli", 1, 2));
        lista_partidas.add(new Partida(211328, 315, 266, "2017-10-22 19:00:00", "Arena Condá", 2, 0));

        Collections.sort(lista_partidas);

        lista_times = new ArrayList<Time>();

        lista_times.add(new Time(262, "Flamengo", "FLA", 6, "flamengo_60x60.png"));
        lista_times.add(new Time(263, "Botafogo", "BOT", 7, "botafogo_60x60.png"));
        lista_times.add(new Time(264, "Corinthians", "COR", 1, "corinthians_60x60.png"));
        lista_times.add(new Time(267, "Vasco", "VAS", 8, "vasco_60x60.png"));
        lista_times.add(new Time(275, "Palmeiras", "PAL", 3, "palmeiras_60x60.png"));
        lista_times.add(new Time(277, "Santos", "SAN", 4, "santos_60x60.png"));
        lista_times.add(new Time(282, "Atlético-MG", "ATL", 10, "atletico_mg_60x60.png"));
        lista_times.add(new Time(283, "Cruzeiro", "CRU", 5, "cruzeiro_60x60.png"));
        lista_times.add(new Time(284, "Grêmio", "GRE", 2, "gremio_60x60.png"));
        lista_times.add(new Time(293, "Atlético-PR", "ATL", 9, "atletico_pr_2015_65.png"));

        lista_times.add(new Time(265,"Bahia","BAH",13,"bahia_60x60.png"));
        lista_times.add(new Time(266,"Fluminense","FLU",11,"fluminense_60x60.png"));
        lista_times.add(new Time(276,"São Paulo","SAO",15,"sao_paulo_60x60.png"));
        lista_times.add(new Time(287,"Vitória","VIT",16,"vitoria_60x60.png"));
        lista_times.add(new Time(292,"Sport","SPO",14,"sport65.png"));
        lista_times.add(new Time(294,"Coritiba","COR",18,"coritiba65.png"));
        lista_times.add(new Time(303,"Ponte Preta","PON",17,"ponte_preta_60x60.png"));
        lista_times.add(new Time(314,"Avaí","AVA",19,"avai_60x60_.png"));
        lista_times.add(new Time(315,"Chapecoense","CHA",12,"escudo_chape_165.png"));
        lista_times.add(new Time(373,"Atlético-GO","ATL",20,"atletico_go_65.png"));

        Collections.sort(lista_times);

        lista_times_reduzida = new ArrayList<Time>();

        lista_times_reduzida.add(new Time(262, "Flamengo", "FLA", 6, "flamengo_60x60.png"));
        lista_times_reduzida.add(new Time(263, "Botafogo", "BOT", 7, "botafogo_60x60.png"));
        lista_times_reduzida.add(new Time(264, "Corinthians", "COR", 1, "corinthians_60x60.png"));
        lista_times_reduzida.add(new Time(267, "Vasco", "VAS", 8, "vasco_60x60.png"));
        lista_times_reduzida.add(new Time(275, "Palmeiras", "PAL", 3, "palmeiras_60x60.png"));
        lista_times_reduzida.add(new Time(277, "Santos", "SAN", 4, "santos_60x60.png"));
        lista_times_reduzida.add(new Time(282, "Atlético-MG", "ATL", 10, "atletico_mg_60x60.png"));
        lista_times_reduzida.add(new Time(283, "Cruzeiro", "CRU", 5, "cruzeiro_60x60.png"));
        lista_times_reduzida.add(new Time(284, "Grêmio", "GRE", 2, "gremio_60x60.png"));
        lista_times_reduzida.add(new Time(293, "Atlético-PR", "ATL", 9, "atletico_pr_2015_65.png"));

        Collections.sort(lista_times_reduzida);

    }

    ArrayList<Time> getLista_times(){
        return lista_times;
    }

    ArrayList<Partida> getLista_partidas(){
        return lista_partidas;
    }

    ArrayList<Time> getLista_times_reduzida(){
        return lista_times_reduzida;
    }
}
