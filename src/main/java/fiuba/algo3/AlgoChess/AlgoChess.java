package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import fiuba.algo3.AlgoChess.tableroycasilleros.TableroAliado;
import fiuba.algo3.AlgoChess.tableroycasilleros.TableroEnemigo;

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
