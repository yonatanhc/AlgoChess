package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Unidad;


import java.util.ArrayList;

public class CampoAliado {

    private Jugador jugador;
    private int maximoHorizontal;
    private int minimoHorizontal;

    public CampoAliado(Jugador jugadorAAsignarLado) {
        this.jugador = jugadorAAsignarLado;
        this.maximoHorizontal = 4;
        this.minimoHorizontal = 1;
    }

    public Jugador getJugador(){
        return this.jugador;
    }

    public boolean esCasilleroAliado(int x, int y) {
        if(x >= minimoHorizontal && x <= maximoHorizontal && y >= 1 && y <= 5){
            return true;
        }
        throw new CampoContrarioException();
    }

}