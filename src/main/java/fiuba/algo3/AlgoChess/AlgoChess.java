package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public class AlgoChess {
    private ArrayList<Jugador> jugadores;
    private Tablero tablero;

    public  AlgoChess() {
        this.jugadores = new ArrayList<Jugador>();
    }

    public void agregarTablero(Tablero tablero){
        this.tablero = tablero;
    }

}
