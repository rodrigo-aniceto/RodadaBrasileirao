package com.example.rodrigo01.rodadabrasileiro;

/**
 * Created by rodrigo01 on 24/10/2017.
 */

public class Partida implements Comparable<Partida>{
    private int partida_id, clube_casa_id, clube_visitante_id, placar_oficial_mandante, placar_oficial_visitante;
    private String partida_data, local;

    public Partida (int partida_id, int clube_casa_id, int clube_visitante_id, String partida_data, String local, int placar_oficial_mandante, int placar_oficial_visitante){
        this.setClube_casa_id(clube_casa_id);
        this.setClube_visitante_id(clube_visitante_id);
        this.setLocal(local);
        this.setPartida_data(partida_data);
        this.setPartida_id(partida_id);
        this.setPlacar_oficial_mandante(placar_oficial_mandante);
        this.setPlacar_oficial_visitante(placar_oficial_visitante);
    }

    public int getPartida_id() {
        return partida_id;
    }

    public void setPartida_id(int partida_id) {
        this.partida_id = partida_id;
    }

    public int getClube_casa_id() {
        return clube_casa_id;
    }

    public void setClube_visitante_id(int clube_visitante_id) {
        this.clube_visitante_id = clube_visitante_id;
    }

    public int getPlacar_oficial_mandante() {
        return placar_oficial_mandante;
    }

    public void setPlacar_oficial_mandante(int placar_oficial_mandante) {
        this.placar_oficial_mandante = placar_oficial_mandante;
    }

    public int getPlacar_oficial_visitante() {
        return placar_oficial_visitante;
    }

    public void setPlacar_oficial_visitante(int placar_oficial_visitante) {
        this.placar_oficial_visitante = placar_oficial_visitante;
    }

    public String getPartida_data() {
        return partida_data;
    }

    public void setPartida_data(String partida_data) {
        this.partida_data = partida_data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setClube_casa_id(int clube_casa_id) {
        this.clube_casa_id = clube_casa_id;
    }

    public int getClube_visitante_id() {
        return clube_visitante_id;
    }

    @Override
    public int compareTo(Partida arg0) {
        return this.partida_data.compareTo(arg0.getPartida_data());
    }

}
