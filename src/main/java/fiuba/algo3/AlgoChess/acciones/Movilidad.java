package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

public class Movilidad {

    public void moverUnidadA(Unidad unidad, Casillero origen, Casillero destino){
        if(destino.casilleroOcupado()){
            unidad.setUbicacion(destino);
            destino.ocuparCasilleroConUnidad(unidad);
        }
    }

}
