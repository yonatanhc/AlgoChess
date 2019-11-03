package model;

import java.util.ArrayList;

public abstract class AlgoChess {
    private ArrayList<Jugador> jugadores;

    public  AlgoChess() {
        this.jugadores = new ArrayList<Jugador>();
    }

    public void agregarJugador(Jugador jugador) {
        if(this.jugadores.size() == 0) {
            jugador.asignarTablero(new TableroAliado());
        }
        else {
            jugador.asignarTablero(new TableroEnemigo());
        }
        this.jugadores.add(jugador);
    }

}
