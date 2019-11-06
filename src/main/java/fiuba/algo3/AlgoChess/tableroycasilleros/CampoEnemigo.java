package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Unidad;

import java.util.ArrayList;

public class CampoEnemigo{

    private Jugador jugador;
    private int maximoHorizontal;
    private int minimoHorizontal;

    public CampoEnemigo(Jugador jugadorAAsignarLado){
        this.jugador = jugadorAAsignarLado;
        this.maximoHorizontal = 8;
        this.minimoHorizontal = 5;
    }

   public boolean esCasilleroEnemigo(int x, int y){
        if(x >= minimoHorizontal && x <= maximoHorizontal && y >= 1 && y <= 5){
            return true;
        }
        throw new CampoContrarioException();
   }

   public Jugador getJugador(){
        return this.jugador;
   }


}