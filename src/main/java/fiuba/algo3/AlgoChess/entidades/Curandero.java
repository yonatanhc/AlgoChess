package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.AtaqueDeSanacion;
import fiuba.algo3.AlgoChess.acciones.Movilidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

public class Curandero extends Unidad {

    private Movilidad movilidad;

    public Curandero(){
        super(75,2);
        this.movilidad = new Movilidad();
    }

    public void moverUnidadA(int x, int y, Tablero tablero) {
        Casillero destino = tablero.obtenerCasillero(x,y);
        this.movilidad.moverUnidadA(this,getUbicacion(),destino);
    }

}