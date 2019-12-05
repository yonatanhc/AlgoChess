package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.AtaqueDeJinete;
import fiuba.algo3.AlgoChess.acciones.Rango;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

import java.util.ArrayList;

public class Jinete extends Unidad {

    public Jinete() {
        super(100, 3);
        this.nombreDeUnidad = "Jinete";
    }

    public void activarHabilidad() {
        asignarTipoDeHabilidad(new AtaqueDeJinete(getTablero()));
        getTipoDeHabilidad().activarHabilidad(this);
    }

    @Override
    public void moverUnidad(Casillero destino) {
        getUbicacion().cambiarEstadoDelCasilleroALibre();
        setUbicacion(destino);
    }


}