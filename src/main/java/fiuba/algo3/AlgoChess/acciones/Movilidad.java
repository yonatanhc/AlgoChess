package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.CasilleroOcupadoException;

public class Movilidad {

    public void moverUnidadA(Unidad unidad, Casillero origen, Casillero destino){
        if(destino.casilleroLibre()){
            unidad.setUbicacion(destino);
            origen.cambiarEstadoDelCasilleroALibre();
        }
        else{
            throw new CasilleroOcupadoException();
        }
    }

}
